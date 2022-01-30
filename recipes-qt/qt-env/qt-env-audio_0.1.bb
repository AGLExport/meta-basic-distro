SUMMARY = "Configuration file for the Qt eglfs kms backend"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://qtcompositor \
    file://qtwayland-iviapp \
    file://qtwayland-xdg \
"

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -D -p -m0644 ${WORKDIR}/qtcompositor ${D}${sysconfdir}/default/qtcompositor
    install -D -p -m0644 ${WORKDIR}/qtwayland-iviapp ${D}${sysconfdir}/default/qtwayland-iviapp
    install -D -p -m0644 ${WORKDIR}/qtwayland-xdg ${D}${sysconfdir}/default/qtwayland-xdg
}

FILES:${PN} += " \
    ${sysconfdir}/default/qtcompositor \
    ${sysconfdir}/default/qtwayland-iviapp \
    ${sysconfdir}/default/qtwayland-xdg \
    "
CONFFILES:${PN} += " \
    ${sysconfdir}/default/qtcompositor \
    ${sysconfdir}/default/qtwayland-iviapp \
    ${sysconfdir}/default/qtwayland-xdg \
    "
