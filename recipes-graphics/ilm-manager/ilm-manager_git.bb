SUMMARY = "Tiny window manager for wayland-ivi-extension"
DESCRIPTION = "Tiny window manager"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"

PV = "0.1.0+rev${SRCPV}"

DEPENDS = "jsoncpp wayland-ivi-extension"

SRCREV = "e3a33d47195e4656f7117753d27a0f2d6b21aab9"
SRC_URI = "git://github.com/AGLExport/ilm-manager.git \
           file://agl.json \
          "

inherit autotools pkgconfig

S = "${WORKDIR}/git"

#systemd service files
inherit systemd

SRC_URI_append = " file://ilm-manager.service "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "ilm-manager.service"

#EXTRA_OECONF = "--enable-userdebug"

do_install_append() {
#install scripts
	install -d ${D}/etc
	install -m 0644 ${WORKDIR}/agl.json ${D}/etc

	install -d ${D}/lib/systemd/system
	install -m 0644 ${WORKDIR}/ilm-manager.service ${D}/lib/systemd/system
}

FILES_${PN} += " ${systemd_unitdir} /etc/* "
