FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-Backport-for-build-Do-not-use-deprecated-API.patch \
    file://0001-Backport-for-build-Avoid-the-doctemplates-hack.patch \
    "
