SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = " \
        packagegroup-core-boot \
        ${CORE_IMAGE_EXTRA_INSTALL} \
        kernel-devicetree \
        \
        packagegroup-container-host \
        packagegroup-container-bsp-host-kmodules \
        packagegroup-container-bsp-host-firmware \
      "
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

# debug
IMAGE_INSTALL_append = " \
        nano miscfile \
      "
      
#        packagegroup-agl-host-container-runtime 
#        container-host-config 
#        dlt-daemon dlt-daemon-systemd 
#        nano 
