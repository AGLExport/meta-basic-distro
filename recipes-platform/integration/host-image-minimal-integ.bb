SUMMARY = "A small image just capable of allowing a device to boot."

DEPEND = "host-image-minimal"

IMAGE_FSTYPES = "erofs"

INSTALL_ROOTFS_IMAGE ??= "host-image-minimal-${MACHINE}${MACHINE_SUFFIX}.erofs-lz4hc"
INSTALL_KERNEL_IMAGE ??= "Image"

inherit image

do_image() {
    rm -rf ${IMAGE_ROOTFS}
    mkdir ${IMAGE_ROOTFS}

    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_ROOTFS_IMAGE} ${IMAGE_ROOTFS}/
    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_KERNEL_IMAGE} ${IMAGE_ROOTFS}/

    rm -rf ${IMGDEPLOYDIR}
    mkdir ${IMGDEPLOYDIR}
}

do_rootfs[noexec] = "1"
do_image[depends] = "host-image-minimal:do_image_complete"
