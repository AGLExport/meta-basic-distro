SUMMARY = "The packages of Qt5 runtime packages"
DESCRIPTION = "The set of packages required by Operating System and Common libraries Subsystem"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-qt5-runtime \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    qtbase \
    qtdeclarative \
    qtquickcontrols2 \
    qttools \
    qttranslations-qtbase \
    qttranslations-qtdeclarative \
    qttranslations-qtquickcontrols2 \
    qt3d \
    qtquick3d \
    "
