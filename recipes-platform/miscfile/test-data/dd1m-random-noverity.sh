#!/bin/sh

echo "mount"
mount /dev/mtdblock1 /mnt -o ro
taskset e diskbench /mnt/opt/test-data/random.dat M
umount /mnt

mount /dev/mtdblock1 /mnt -o ro
taskset e diskbench /mnt/opt/test-data/random.dat M
umount /mnt

mount /dev/mtdblock1 /mnt -o ro
taskset e diskbench /mnt/opt/test-data/random.dat M
umount /mnt

mount /dev/mtdblock1/mnt -o ro
taskset e diskbench /mnt/opt/test-data/random.dat M
umount /mnt

mount /dev/mtdblock1 /mnt -o ro
taskset e diskbench /mnt/opt/test-data/random.dat M


echo "no mount"
taskset e diskbench /mnt/opt/test-data/random.dat M
taskset e diskbench /mnt/opt/test-data/random.dat M
taskset e diskbench /mnt/opt/test-data/random.dat M
taskset e diskbench /mnt/opt/test-data/random.dat M
taskset e diskbench /mnt/opt/test-data/random.dat M

echo "flush 1"
echo 1 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 1 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 1 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 1 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 1 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo "flush 3"
echo 3 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 3 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 3 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 3 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

echo 3 > /proc/sys/vm/drop_caches
taskset e diskbench /mnt/opt/test-data/random.dat M

umount /mnt
