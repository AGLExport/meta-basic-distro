SUMMARY = "A very basic Wayland image with a qt6"
LICENSE = "MIT"

require recipes-platform/images/host-image-weston.bb

IMAGE_INSTALL_append = " \
        packagegroup-qt5-runtime \
      "
IMAGE_LINGUAS = " "


# qt6 examples

IMAGE_INSTALL_append = " \
        wayland-ivi-extension ilm-manager \
        qtbase-examples qt3d-examples qtwayland-examples \
       "


