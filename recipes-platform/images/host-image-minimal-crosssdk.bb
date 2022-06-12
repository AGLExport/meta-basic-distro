SUMMARY = "Standalne Qt image with Qt wayland compositor SDK"
LICENSE = "MIT"

require host-image-minimal.bb

IMAGE_FEATURES_append = " dev-pkgs"

inherit populate_sdk
