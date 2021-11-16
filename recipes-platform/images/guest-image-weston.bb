SUMMARY = "A very basic Wayland image with a terminal"
LICENSE = "MIT"

REQUIRED_DISTRO_FEATURES = "wayland"

inherit core-image features_check

CORE_IMAGE_BASE_INSTALL += "weston weston-init-ivi-shell wayland-wsegl "

IMAGE_LINGUAS = " "


