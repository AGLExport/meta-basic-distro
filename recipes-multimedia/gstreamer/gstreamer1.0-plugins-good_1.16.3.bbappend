
RENESAS_GST_PLUGINS_GOOD_URL ?= "gitsm://github.com/renesas-rcar/gst-plugins-good.git;branch=RCAR-GEN3e/1.16.3;protocol=https"
SRC_URI:remove = " ${RENESAS_GST_PLUGINS_GOOD_URL}"
SRC_URI:append = " gitsm://github.com/AGLExport/gst-plugins-good.git;branch=qmlsink6port/1.16.3;protocol=https"

SRCREV = "${AUTOREV}"

QT6WAYLANDDEPENDS  = "${@bb.utils.contains("DISTRO_FEATURES", "wayland", "qtwayland", "", d)}"
PACKAGECONFIG[qt6] = "-Dqt6=enabled,-Dqt6=disabled,qtbase qtdeclarative qtbase-native qttools-native ${QT6WAYLANDDEPENDS}"

PACKAGECONFIG:append = " qt6"

