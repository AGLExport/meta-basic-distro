SUMMARY = "A very basic Wayland image with a terminal"
LICENSE = "MIT"

REQUIRED_DISTRO_FEATURES = "wayland"

inherit core-image features_check
require host-image-renesas-base.inc
require host-image-weston.inc

CORE_IMAGE_BASE_INSTALL += "weston weston-init-ivi-shell "
#IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

IMAGE_INSTALL_append = " \
        kernel-devicetree \
      "
IMAGE_LINGUAS = " "


