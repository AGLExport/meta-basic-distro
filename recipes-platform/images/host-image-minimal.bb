SUMMARY = "A small image just capable of allowing a device to boot."

NO_RECOMMENDATIONS = "1"

IMAGE_FEATURES:append = " read-only-rootfs"

IMAGE_INSTALL = " \
        packagegroup-core-boot \
        ${CORE_IMAGE_EXTRA_INSTALL} \
        kernel-module-brd \
        \
        packagegroup-container-host \
        packagegroup-graphics-kernel \
        packagegroup-multimedia-kernel \
        \
        packagegroup-standard-library-set \
        dlt-daemon dlt-daemon-systemd \
        mounter-nonvolatile mounter-volatile \
        \
        libudev \
      "
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

# container integ.
IMAGE_INSTALL_append = " \
        miscfile \
      "

# debug
IMAGE_INSTALL_append = " \
        systemd-bootchart systemd-analyze \
        gdb nano \
      "
#        gptfdisk 
#        e2fsprogs 
#        optee-client 
#        systemd-bootchart 
#        systemd-analyze 
#        nano 
#        libgrpc++_unsecure protobuf 
#
#        packagegroup-agl-host-container-runtime 
#        container-host-config 
#        nano 
#        util-linux libjpeg-turbo 
