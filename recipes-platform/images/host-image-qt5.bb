SUMMARY = "A very basic Wayland image with a qt6"
LICENSE = "MIT"

require host-image-weston.bb

IMAGE_INSTALL_append = " \
        packagegroup-qt5-runtime \
      "
IMAGE_LINGUAS = " "


# qt6 examples

IMAGE_INSTALL_append = " \
        qtbase-examples qt3d-examples qtwayland-examples \
       "

