#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
#include <stdint.h>
#include <string.h>


int main(int argc, char *argv[])
{
	size_t buffer_size = 0;
	size_t total_buffer_size = 0;
	ssize_t read_bytes = 0;
	void *pbuffer = NULL;
	int fd = -1;
	struct timespec start_time;
	struct timespec end_time;
	uint64_t start_nsec = 0, end_nsec = 0;

	if (argc < 3)
		return -1;

	start_time.tv_sec = 0;
	start_time.tv_nsec = 0;
	end_time.tv_sec = 0;
	end_time.tv_nsec = 0;

	printf("%s: %s: %s\n", argv[0], argv[1], argv[2]);

	if (argv[2][0] == 'M') {
		buffer_size = 1024u * 1024u;
	} else if (argv[2][0] == 'K') {
		buffer_size = 4 * 1024u;
	}

	if (buffer_size == 0)
		return -1;

	pbuffer = malloc(buffer_size);
	memset(pbuffer, 0, buffer_size);

	fd = open(argv[1], O_RDONLY);
	if (fd >= 0) {
		clock_gettime(CLOCK_MONOTONIC, &start_time);

		do {
			total_buffer_size += (size_t)read_bytes;
			read_bytes = read(fd, pbuffer, buffer_size);
		} while (read_bytes > 0);

		clock_gettime(CLOCK_MONOTONIC, &end_time);

		start_nsec = (start_time.tv_sec * 1000 * 1000 * 1000) + start_time.tv_nsec;
		end_nsec = (end_time.tv_sec * 1000 * 1000 * 1000) + end_time.tv_nsec;
		
		double mb = ((double)total_buffer_size) / (1024.0 * 1024.0);
		double pers = ((double)(end_nsec - start_nsec)) / (1000.0 * 1000.0 * 1000.0);
		double mbs = mb / pers;

		printf("%.3lf mb/s\n",mbs);
	}

	free(pbuffer);
	if (fd != -1)
	close(fd);

	return 0;
}
