SUMMARY = "Qt6 based cluster guest image"
LICENSE = "MIT"

NO_RECOMMENDATIONS = "1"

IMAGE_FEATURES_append = " read-only-rootfs"

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
    packagegroup-qt6-cluster \
    kms-config-cluster \
    qt-env-cluster \
    "
# Qt6 examples
IMAGE_INSTALL:append = " \
    qtwayland-examples qtquick3d-examples \
    "

IMAGE_LINGUAS = "ja-jp en-us"


# These features shall use development environment only.
#IMAGE_FEATURES:append = " package-management ssh-server-dropbear"


