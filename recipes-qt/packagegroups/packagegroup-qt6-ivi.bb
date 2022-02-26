DESCRIPTION = "Qt6 modules for cluster"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# Core Packages
RDEPENDS:${PN} += " \
    qtbase \
    qtdeclarative \
    qtapplicationmanager \
    qtquick3d \
    qtquicktimeline \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtmultimedia', '', d)} \
    qtimageformats \
    qtlottie \
    qtscxml \
    qtremoteobjects \
    qtspeech \
    qtsvg \
    qttranslations \
    qtvirtualkeyboard \
    qtwebsockets \
"

# Languages
RDEPENDS:${PN} += " \
    qttranslations-qtbase \
    qttranslations-qtdeclarative \
"

