FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
            file://0003-launcher-do-not-touch-VT-tty-while-using-non-default.patch \
            file://0004-launcher-direct-handle-seat0-without-VTs.patch \
            "

