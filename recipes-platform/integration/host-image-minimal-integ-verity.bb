SUMMARY = "A small image just capable of allowing a device to boot."

DEPENDS = "host-image-minimal"

IMAGE_FSTYPES = "erofs"

INSTALL_ROOTFS_IMAGE ??= "host-image-minimal-${MACHINE}${MACHINE_SUFFIX}.rootfs.erofs"
INSTALL_ROOTFS_IMAGE_VERITY ??= "${INSTALL_ROOTFS_IMAGE}.verity"
INSTALL_KERNEL_IMAGE ??= "Image"
INSTALL_KERNELDTB_IMAGE ??= "r8a77951-ulcb-kf.dtb"

EXTRA_IMAGECMD:append:erofs = "--all-root"

inherit image

do_image() {
    rm -rf ${IMAGE_ROOTFS}
    mkdir ${IMAGE_ROOTFS}

    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_ROOTFS_IMAGE_VERITY} ${IMAGE_ROOTFS}/${INSTALL_ROOTFS_IMAGE}
    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_KERNEL_IMAGE} ${IMAGE_ROOTFS}/
    cp ${TOPDIR}/tmp/deploy/images/${MACHINE}/${INSTALL_KERNELDTB_IMAGE} ${IMAGE_ROOTFS}/

    cp ${STAGING_VERITY_DIR}/${DM_VERITY_IMAGE}.${DM_VERITY_IMAGE_TYPE}.verity.env ${IMAGE_ROOTFS}/${INSTALL_ROOTFS_IMAGE_VERITY}.env

    rm -rf ${IMGDEPLOYDIR}
    mkdir ${IMGDEPLOYDIR}
}

do_rootfs[noexec] = "1"
do_image[depends] = "host-image-minimal:do_image_complete"
