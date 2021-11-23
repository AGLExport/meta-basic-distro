SUMMARY = "A very basic Wayland image with a qt6"
LICENSE = "MIT"

require recipes-platform/images/guest-image-weston.bb

IMAGE_INSTALL_append = " \
        packagegroup-qt6-modules \
      "
IMAGE_LINGUAS = " "


# qt6 examples

IMAGE_INSTALL_append = " \
        wayland-ivi-extension ilm-manager \
        qtbase-examples qtwayland-examples qtquick3d-examples \
       "


