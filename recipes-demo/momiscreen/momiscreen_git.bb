SUMMARY     = "Momiyama home screen example"
DESCRIPTION = "The momiscreen is a home screen example. \
               The momiscreen is not require agl-appfw."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PV = "0.2.0"

inherit qmake5 systemd

DEPENDS = "qtbase qtquickcontrols2 qtgraphicaleffects qtsvg "
RDEPENDS_${PN} = "qtsvg "

SRC_URI = "git://github.com/AGLExport/momiscreen.git;branch=main \
           file://momiscreen.service \
           file://momiscreen \
          "
SRCREV = "bc3ef09ffad15b97941f28b165dc2019f5950105"

S = "${WORKDIR}/git"

QT_INSTALL_PREFIX = "/usr"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "momiscreen.service"

do_install_append() {
	install -d ${D}/lib/systemd/system
	install -m 0644 ${WORKDIR}/momiscreen.service ${D}/lib/systemd/system

	install -m 0755 -d ${D}${sysconfdir}/default/
	install -m 0755 ${WORKDIR}/momiscreen ${D}${sysconfdir}/default/
}

FILES_${PN} += " ${systemd_unitdir} ${sysconfdir}/*/* "
