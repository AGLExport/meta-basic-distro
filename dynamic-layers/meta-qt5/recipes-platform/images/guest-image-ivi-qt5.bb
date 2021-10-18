SUMMARY = "A very basic Wayland image with a qt5"
LICENSE = "MIT"

require recipes-platform/images/host-image-weston.bb

IMAGE_INSTALL_append = " \
        packagegroup-qt5-runtime \
      "
IMAGE_LINGUAS = " "


# qt6 examples

IMAGE_INSTALL_append = " \
        wayland-ivi-extension ilm-manager \
        mominavi momiscreen momiplay \
       "


