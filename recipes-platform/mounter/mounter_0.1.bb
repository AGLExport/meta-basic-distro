SUMMARY = "Misc file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
    file://var-nonvolatile.mount \
    file://var-volatile.mount \
    "

S = "${WORKDIR}"

inherit features_check systemd

do_install() {
    install -d ${D}/${systemd_unitdir}/system
    install -d ${D}/var/nonvolatile
    install -Dm644 ${WORKDIR}/var-nonvolatile.mount ${D}/${systemd_unitdir}/system/
    install -Dm644 ${WORKDIR}/var-volatile.mount ${D}/${systemd_unitdir}/system/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES =+ "${PN}-nonvolatile ${PN}-volatile"
SYSTEMD_PACKAGES = "${PN}-nonvolatile ${PN}-volatile"
ALLOW_EMPTY:${PN} = "1"

FILES:${PN}-nonvolatile += " \
    ${systemd_unitdir}/system/var-nonvolatile.mount \
    /var/nonvolatile \
    "
CONFFILES:${PN}-nonvolatile += " \
    ${systemd_unitdir}/system/var-nonvolatile.mount \
    "
SYSTEMD_SERVICE:${PN}-nonvolatile = "var-nonvolatile.mount"
SYSTEMD_AUTO_ENABLE:${PN}-nonvolatile = "enable"

FILES:${PN}-volatile += " \
    ${systemd_unitdir}/system/var-volatile.mount \
    "
CONFFILES:${PN}-volatile += " \
    ${systemd_unitdir}/system/var-volatile.mount \
    "
SYSTEMD_SERVICE:${PN}-volatile = "var-volatile.mount"
SYSTEMD_AUTO_ENABLE:${PN}-volatile = "enable"
