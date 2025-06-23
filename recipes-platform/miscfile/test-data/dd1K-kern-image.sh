#!/bin/sh

echo "mount"
mount /dev/dm-1 /mnt -o ro
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
umount /mnt

mount /dev/dm-1 /mnt -o ro
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
umount /mnt

mount /dev/dm-1 /mnt -o ro
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
umount /mnt

mount /dev/dm-1 /mnt -o ro
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
umount /mnt

mount /dev/dm-1 /mnt -o ro
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K


echo "no mount"
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
taskset e diskbench /mnt/boot/Image-5.10.117-yocto-standard K
umount /mnt

