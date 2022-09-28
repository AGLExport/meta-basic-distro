SUMMARY = "Protocol Buffers - structured data serialisation mechanism"
DESCRIPTION = "Protocol Buffers are a way of encoding structured data in an \
efficient yet extensible format. Google uses Protocol Buffers for almost \
all of its internal RPC protocols and file formats."
HOMEPAGE = "https://github.com/google/protobuf"
SECTION = "console/tools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=37b5762e07f0af8c74ce80a8bda4266b"

DEPENDS = "zlib"

SRCREV = "d0bfd5221182da1a7cc280f3337b5e41a89539cf"

SRC_URI = "git://github.com/google/protobuf.git;branch=3.11.x;protocol=https \
           file://0001-protobuf-fix-configure-error.patch \
           file://0001-Makefile.am-include-descriptor.cc-when-building-libp.patch \
           file://0001-examples-Makefile-respect-CXX-LDFLAGS-variables-fix-.patch \
           file://CVE-2021-22570.patch \
"
S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

PACKAGECONFIG ??= ""
PACKAGECONFIG[python] = ",,"

EXTRA_OECONF += "--with-protoc=echo"

TEST_SRC_DIR = "examples"
LANG_SUPPORT = "cpp ${@bb.utils.contains('PACKAGECONFIG', 'python', 'python', '', d)}"

do_install:append() {
    # Shall not install dev package files
    rm -r ${D}/${includedir}
    rm -r ${D}/${libdir}/pkgconfig
    rm ${D}/${libdir}/*.so

    # Shall not install protoc files
    rm -r ${D}/${bindir}
    rm ${D}/${libdir}/libprotoc.*
}

PACKAGES = "${PN}-dbg ${PN}-lite ${PN}"

FILES:${PN}-lite = "${libdir}/libprotobuf-lite${SOLIBS}"

MIPS_INSTRUCTION_SET = "mips"

LDFLAGS_append_arm = " -latomic"
LDFLAGS_append_mips = " -latomic"
LDFLAGS_append_powerpc = " -latomic"
LDFLAGS_append_mipsel = " -latomic"
