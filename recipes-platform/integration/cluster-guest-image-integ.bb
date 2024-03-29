SUMMARY = "A small image just capable of allowing a device to boot."

DEPEND = "cluster-guest-image"

IMAGE_FSTYPES = "erofs"

INSTALL_ROOTFS_IMAGE ??= "cluster-guest-image-${MACHINE}${MACHINE_SUFFIX}.erofs-lz4hc"

EXTRA_IMAGECMD:append_erofs = "--all-root"

inherit image

do_image() {
    rm -rf ${IMAGE_ROOTFS}
    mkdir ${IMAGE_ROOTFS}

    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_ROOTFS_IMAGE} ${IMAGE_ROOTFS}/

    rm -rf ${IMGDEPLOYDIR}
    mkdir ${IMGDEPLOYDIR}
}

do_rootfs[noexec] = "1"
do_image[depends] = "cluster-guest-image:do_image_complete"
