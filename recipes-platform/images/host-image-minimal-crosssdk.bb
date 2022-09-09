SUMMARY = "Standalne Qt image with Qt wayland compositor SDK"
LICENSE = "MIT"

require host-image-minimal.bb

IMAGE_FEATURES:append = " dev-pkgs"

inherit populate_sdk

TOOLCHAIN_HOST_TASK:append = " nativesdk-protobuf-compiler nativesdk-grpc-compiler "

