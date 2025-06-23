SUMMARY = "A small image just capable of allowing a device to boot."

NO_RECOMMENDATIONS = "1"

IMAGE_FEATURES:append = " read-only-rootfs"

IMAGE_INSTALL = " \
        packagegroup-core-boot \
        ${CORE_IMAGE_EXTRA_INSTALL} \
        \
        packagegroup-standard-library-set \
        mounter-volatile \
        \
        libudev \
      "
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

# container integ.
IMAGE_INSTALL:append = " \
        miscfile \
        cryptsetup \
        test-data diskbench util-linux-taskset \
        kernel-image-image \
      "

# debug
IMAGE_INSTALL:append = " \
      "
#        systemd-bootchart systemd-analyze
#        gdb nano
#        gptfdisk 
#        e2fsprogs 
#        optee-client 
#        systemd-bootchart 
#        systemd-analyze 
#        nano 
#        packagegroup-agl-host-container-runtime 
#        container-host-config 
#        nano 
#        util-linux libjpeg-turbo 
