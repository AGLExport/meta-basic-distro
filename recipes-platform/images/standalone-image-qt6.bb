SUMMARY = "Standalne Qt image with Qt wayland compositor"
LICENSE = "MIT"

REQUIRED_DISTRO_FEATURES = "wayland"

inherit core-image
inherit features_check

### For kernel space 
IMAGE_INSTALL:append = " \
    kernel-devicetree \
    packagegroup-graphics-kernel \
    packagegroup-multimedia-kernel \
    "

### For user space
# graphics support
IMAGE_INSTALL:append = " \
    packagegroup-qt-compositor \
    "

# multimedia support
IMAGE_INSTALL:append = " \
    packagegroup-multimedia-userland \
    "

# Qt6 support
IMAGE_INSTALL:append = " \
    packagegroup-qt6-ivi \
    kms-config \
    qt-env \
    "
# Qt6 examples
IMAGE_INSTALL:append = " \
    qtbase-examples qtwayland-examples qtquick3d-examples qtmultimedia-examples \
    "

IMAGE_LINGUAS = "ja-jp en-us"


# These features shall use development environment only.
#IMAGE_FEATURES:append = " package-management ssh-server-dropbear"


