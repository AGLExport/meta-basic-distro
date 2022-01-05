SUMMARY = "Misc file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://config \
          "

S = "${WORKDIR}"

inherit features_check systemd

do_install() {
    install -Dm644 ${WORKDIR}/config ${D}/var/lib/lxc/cluster/config

    install -d ${D}/opt/guest/cluster
    install -d ${D}/opt/guest/audio
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += " \
    /var/lib/lxc/cluster/config \
    /opt/guest/* \
    "
CONFFILES:${PN} += " \
    /var/lib/lxc/cluster/config \
    "
#SYSTEMD_PACKAGES = "${PN}"
#SYSTEMD_SERVICE:${PN} = "weston.service"
#SYSTEMD_AUTO_ENABLE = "enable"

#RDEPENDS:${PN} = " \
#    weston \
#    weston-ini \
#    "
#RCONFLICTS:${PN} = "weston-init"
