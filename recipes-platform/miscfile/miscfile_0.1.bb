SUMMARY = "Misc file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
    file://config-cluster \
    file://config-audio \
    file://agl-cluster.json \
    file://agl-demo-ivi.json \
    "

S = "${WORKDIR}"

inherit features_check systemd

do_install() {
    install -Dm644 ${WORKDIR}/config-cluster ${D}/var/lib/lxc/cluster/config
    install -Dm644 ${WORKDIR}/config-audio ${D}/var/lib/lxc/audio/config

    install -d ${D}/opt/guest/cluster
    install -d ${D}/opt/guest/audio

    install -d ${D}/opt/container/conf/
    install -Dm644 ${WORKDIR}/agl-cluster.json ${D}/opt/container/conf/
    install -Dm644 ${WORKDIR}/agl-demo-ivi.json ${D}/opt/container/conf/

    install -d ${D}/opt/container/guests/agl-cluster/rootfs
    install -d ${D}/opt/container/guests/agl-cluster/nv
    install -d ${D}/opt/container/guests/agl-demo-ivi/rootfs
    install -d ${D}/opt/container/guests/agl-demo-ivi/nv

}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += " \
    /var/lib/lxc/cluster/config \
    /var/lib/lxc/audio/config \
    /opt/guest/* \
    /opt/container/*/* \
    /opt/container/*/*/* \
    "
CONFFILES:${PN} += " \
    /var/lib/lxc/cluster/config \
    /var/lib/lxc/audio/config \
    "
#SYSTEMD_PACKAGES = "${PN}"
#SYSTEMD_SERVICE:${PN} = "weston.service"
#SYSTEMD_AUTO_ENABLE = "enable"

#RDEPENDS:${PN} = " \
#    weston \
#    weston-ini \
#    "
#RCONFLICTS:${PN} = "weston-init"
