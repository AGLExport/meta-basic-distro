SUMMARY = "Misc file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
    file://dd1m-random.sh \
    file://dd1m-random-noverity.sh \
    file://dd1K-kern-image.sh \
    "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/opt/test-data
    dd if=/dev/random of=${D}/opt/test-data/random.dat bs=1M count=16

    install -d ${D}/usr/bin
    install -m 0755 ${WORKDIR}/dd1m-random.sh ${D}/usr/bin/dd1m-random.sh
    install -m 0755 ${WORKDIR}/dd1m-random-noverity.sh ${D}/usr/bin/dd1m-random-noverity.sh
    install -m 0755 ${WORKDIR}/dd1K-kern-image.sh ${D}/usr/bin/dd1K-kern-image.sh
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += " \
    /opt/test-data/* \
    "
