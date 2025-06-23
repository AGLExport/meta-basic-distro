SUMMARY = "A small image just capable of allowing a device to boot."

DEPENDS = "host-image-minimal"

IMAGE_FSTYPES = "erofs"

INSTALL_ROOTFS_IMAGE ??= "host-image-minimal-${MACHINE}${MACHINE_SUFFIX}.rootfs.erofs-lz4hc"
INSTALL_KERNEL_IMAGE ??= "Image"
INSTALL_KERNELDTB_IMAGE ??= "r8a77951-ulcb-kf.dtb"

EXTRA_IMAGECMD:append_erofs = "--all-root"

inherit image

do_image() {
    rm -rf ${IMAGE_ROOTFS}
    mkdir ${IMAGE_ROOTFS}

    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_ROOTFS_IMAGE} ${IMAGE_ROOTFS}/
    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_KERNEL_IMAGE} ${IMAGE_ROOTFS}/
    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_KERNELDTB_IMAGE} ${IMAGE_ROOTFS}/

    sha256sum -b ${IMAGE_ROOTFS}/${INSTALL_ROOTFS_IMAGE} | awk '{print $1}' > ${IMAGE_ROOTFS}/${INSTALL_ROOTFS_IMAGE}.hash

    rm -rf ${IMGDEPLOYDIR}
    mkdir ${IMGDEPLOYDIR}
}

do_rootfs[noexec] = "1"
do_image[depends] = "host-image-minimal:do_image_complete"
