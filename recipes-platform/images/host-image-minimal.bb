SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = " \
        packagegroup-core-boot \
        ${CORE_IMAGE_EXTRA_INSTALL} \
        kernel-devicetree \
      "
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

#        packagegroup-agl-host-container-runtime 
#        container-host-config 
#        drm-lease-manager 
#        dlt-daemon dlt-daemon-systemd 
#        nano 
