SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_FEATURES_append = " read-only-rootfs"

IMAGE_INSTALL = " \
        packagegroup-core-boot \
        ${CORE_IMAGE_EXTRA_INSTALL} \
        kernel-devicetree \
        \
        packagegroup-container-host \
        packagegroup-graphics-kernel \
        packagegroup-multimedia-kernel \
        \
        packagegroup-standard-library-set \
        dlt-daemon dlt-daemon-systemd \
      "
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

# container integ.
IMAGE_INSTALL_append = " \
        miscfile \
      "

# debug
#IMAGE_INSTALL_append = " \
#        nano \
#      "
      
#        packagegroup-agl-host-container-runtime 
#        container-host-config 
#        nano 
