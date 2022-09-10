FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-Fix-meson-error-in-0.61.x.patch \
    "

PACKAGECONFIG:remove = "backlight sysvinit vconsole timesyncd quotacheck randomseed"

PACKAGECONFIG[hwdb] = "-Dhwdb=true,-Dhwdb=false"
