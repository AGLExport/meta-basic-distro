SUMMARY = "Cross SDK for qt6 with wayland/weston"
LICENSE = "MIT"

require host-image-qt5.bb

IMAGE_FEATURES_append = " dev-pkgs"

inherit populate_sdk populate_sdk_qt5

