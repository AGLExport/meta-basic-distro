HOMEPAGE = "http://mesonbuild.com"
SUMMARY = "A high performance build system"
DESCRIPTION = "Meson is a build system designed to increase programmer \
productivity. It does this by providing a fast, simple and easy to use \
interface for modern software development tools and practices."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "https://github.com/mesonbuild/meson/releases/download/${PV}/meson-${PV}.tar.gz \
           file://meson-setup.py \
           file://meson-wrapper \
           file://0001-python-module-do-not-manipulate-the-environment-when.patch \
           file://disable-rpath-handling.patch \
           file://0001-is_debianlike-always-return-False.patch \
           file://0001-Check-for-clang-before-guessing-gcc-or-lcc.patch \
           "
SRC_URI[sha256sum] = "5e9a0d65c1a51936362b9686d1c5e9e184a6fd245d57e7269750ce50c20f5d9a"

SRC_URI_append_class-native = " \
    file://0001-Make-CPU-family-warnings-fatal.patch \
    file://0002-Support-building-allarch-recipes-again.patch \
"

UPSTREAM_CHECK_URI = "https://github.com/mesonbuild/meson/releases"
UPSTREAM_CHECK_REGEX = "meson-(?P<pver>\d+(\.\d+)+)\.tar"

inherit setuptools3

RDEPENDS_${PN} = "ninja python3-modules python3-pkg-resources"

FILES_${PN} += "${datadir}/polkit-1"
