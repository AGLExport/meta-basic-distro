FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-ext:"

SRC_URI:append = " \
    file://dlt.conf \
    file://dlt-system.conf \
    "

PACKAGECONFIG = " \
    systemd systemd-watchdog systemd-journal dlt-examples dlt-console \
    unixsocket dlt-system dlt-filetransfer \
    "

# extended options
PACKAGECONFIG[unixsocket] = "-DDLT_IPC=UNIX_SOCKET,-DDLT_IPC=FIFO"
PACKAGECONFIG[ipv6] = "-DWITH_DLT_USE_IPv6=ON,-DWITH_DLT_USE_IPv6=OFF"

do_install:append() {
    install -d ${D}/${sysconfdir}
    install -m644 ${WORKDIR}/dlt.conf ${D}/${sysconfdir}
    install -m644 ${WORKDIR}/dlt-system.conf ${D}/${sysconfdir}
}
