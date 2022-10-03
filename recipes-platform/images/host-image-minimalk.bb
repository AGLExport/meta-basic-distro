SUMMARY = "A small image just capable of allowing a device to boot."

require host-image-minimal.bb

# container integ.
IMAGE_INSTALL:append = " \
        kernel-image-image \
        kernel-devicetree \
      "

# debug
IMAGE_INSTALL_append = " \
        nano \
        "
