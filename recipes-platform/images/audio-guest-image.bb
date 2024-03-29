SUMMARY = "Qt6 based cluster guest image"
LICENSE = "MIT"

IMAGE_FEATURES_append = " read-only-rootfs"

EXTRA_IMAGECMD_erofs = "--uid-offset=100000 --gid-offset=100000"

REQUIRED_DISTRO_FEATURES = "wayland"

inherit core-image
inherit features_check

### For user space
# graphics support
IMAGE_INSTALL:append = " \
    packagegroup-qt-compositor \
    "

# Qt6 support
IMAGE_INSTALL:append = " \
    packagegroup-qt6-modules \
    kms-config-audio \
    qt-env-audio \
    "
# Qt6 examples
IMAGE_INSTALL:append = " \
    qtwayland-examples qtquick3d-examples \
    "

IMAGE_LINGUAS = "ja-jp en-us"


# These features shall use development environment only.
#IMAGE_FEATURES:append = " package-management ssh-server-dropbear"


