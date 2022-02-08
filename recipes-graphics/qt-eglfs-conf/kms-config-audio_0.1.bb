SUMMARY = "Configuration file for the Qt eglfs kms backend"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://kms.conf \
"

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -D -p -m0644 ${WORKDIR}/kms.conf ${D}${sysconfdir}/kms.conf
}

FILES:${PN} += " \
    ${sysconfdir}/kms.conf \
    "
CONFFILES:${PN} += " \
    ${sysconfdir}/kms.conf \
    "
