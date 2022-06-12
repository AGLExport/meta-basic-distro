FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-ext:"

PACKAGECONFIG = " \
    systemd systemd-watchdog systemd-journal dlt-examples dlt-console \
    unixsocket dlt-system dlt-filetransfer \
    "

# extended options
PACKAGECONFIG[unixsocket] = "-DLT_IPC=UNIX_SOCKET,-DLT_IPC=FIFO"
PACKAGECONFIG[ipv6] = "-DWITH_DLT_USE_IPv6=ON,-DWITH_DLT_USE_IPv6=OFF"

