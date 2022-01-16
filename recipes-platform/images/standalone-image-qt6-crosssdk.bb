SUMMARY = "Standalne Qt image with Qt wayland compositor SDK"
LICENSE = "MIT"

require standalone-image-qt6.bb

IMAGE_FEATURES_append = " dev-pkgs"

inherit populate_sdk populate_sdk_qt6_base

TOOLCHAIN_HOST_TASK:append = " nativesdk-packagegroup-qt6-toolchain-host"
TOOLCHAIN_TARGET_TASK:append = " packagegroup-qt6-modules"
