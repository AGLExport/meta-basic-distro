DESCRIPTION = "A high performance, open source, general-purpose RPC framework. \
Provides gRPC libraries for multiple languages written on top of shared C core library \
(C++, Node.js, Python, Ruby, Objective-C, PHP, C#)"
HOMEPAGE = "https://github.com/grpc/grpc"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e4cf218112648d22420a84281b68b88"

DEPENDS = "c-ares protobuf protobuf-native protobuf-c protobuf-c-native openssl libnsl2 abseil-cpp re2"
DEPENDS:append:class-target = " googletest grpc-native "
DEPENDS:append:class-nativesdk = " grpc-native "

PACKAGE_BEFORE_PN = " \
    ${PN}-compiler \
    libgrpc-common \
    libgrpc++_alts \
    libgrpc++_error_details \
    libgrpcpp_channelz \
    libgrpc++_reflection \
    libgrpc++ \
    libgrpc++_unsecure \
    "

RDEPENDS:${PN}-compiler = "${PN}"
RDEPENDS:${PN}-dev:append:class-native = " ${PN}-compiler"
# Configuration above allows to cross-compile gRPC applications
# In order to compile applications on the target, use the dependency below
# Both dependencies are mutually exclusive
# RDEPENDS:${PN}-dev += "${PN}-compiler"

S = "${WORKDIR}/git"
SRCREV_grpc = "3f072f44cb8e984c09e1a5fed3d597982b54f92e"
BRANCH = "v1.46.x"
SRC_URI = "git://github.com/grpc/grpc.git;protocol=https;name=grpc;branch=${BRANCH} \
           file://0001-Revert-Changed-GRPCPP_ABSEIL_SYNC-to-GPR_ABSEIL_SYNC.patch \
           file://0001-cmake-add-separate-export-for-plugin-targets.patch \
           file://0001-cmake-Link-with-libatomic-on-rv32-rv64.patch \
           file://0001-Fix-all-build-warnings-reported-by-gcc-9.patch \
           "
# Fixes build with older compilers 4.8 especially on ubuntu 14.04
CXXFLAGS:append:class-native = " -Wl,--no-as-needed"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DgRPC_CARES_PROVIDER=package \
    -DgRPC_ZLIB_PROVIDER=package \
    -DgRPC_SSL_PROVIDER=package \
    -DgRPC_PROTOBUF_PROVIDER=package \
    -DgRPC_ABSL_PROVIDER=package \
    -DgRPC_RE2_PROVIDER=package \
    -DgRPC_INSTALL=ON \
    -DCMAKE_CROSSCOMPILING=ON \
    -DgRPC_INSTALL_LIBDIR=${baselib} \
    -DgRPC_INSTALL_CMAKEDIR=${baselib}/cmake/${BPN} \
    "

PACKAGECONFIG ??= "cpp shared"
PACKAGECONFIG[cpp] = "-DgRPC_BUILD_GRPC_CPP_PLUGIN=ON,-DgRPC_BUILD_GRPC_CPP_PLUGIN=OFF"
PACKAGECONFIG[csharp] = "-DgRPC_BUILD_GRPC_CSHARP_PLUGIN=ON -DgRPC_BUILD_CSHARP_EXT=ON,-DgRPC_BUILD_GRPC_CSHARP_PLUGIN=OFF -DgRPC_BUILD_CSHARP_EXT=OFF"
PACKAGECONFIG[node] = "-DgRPC_BUILD_GRPC_NODE_PLUGIN=ON,-DgRPC_BUILD_GRPC_NODE_PLUGIN=OFF"
PACKAGECONFIG[objective-c] = "-DgRPC_BUILD_GRPC_OBJECTIVE_C_PLUGIN=ON,-DgRPC_BUILD_GRPC_OBJECTIVE_C_PLUGIN=OFF"
PACKAGECONFIG[php] = "-DgRPC_BUILD_GRPC_PHP_PLUGIN=ON,-DgRPC_BUILD_GRPC_PHP_PLUGIN=OFF"
PACKAGECONFIG[python] = "-DgRPC_BUILD_GRPC_PYTHON_PLUGIN=ON,-DgRPC_BUILD_GRPC_PYTHON_PLUGIN=OFF"
PACKAGECONFIG[ruby] = "-DgRPC_BUILD_GRPC_RUBY_PLUGIN=ON,-DgRPC_BUILD_GRPC_RUBY_PLUGIN=OFF"
PACKAGECONFIG[protobuf-lite] = "-DgRPC_USE_PROTO_LITE=ON,-DgRPC_USE_PROTO_LITE=OFF,protobuf-lite"
PACKAGECONFIG[shared] = "-DBUILD_SHARED_LIBS=ON,-DBUILD_SHARED_LIBS=OFF,,"

do_configure:prepend() {
    sed -i -e "s#lib/pkgconfig/#${baselib}/pkgconfig/#g" ${S}/CMakeLists.txt
}

BBCLASSEXTEND = "native nativesdk"

FILES:${PN}-compiler += " \
    ${bindir} \
    ${libdir}/libgrpc_plugin_support${SOLIBS} \
    "
FILES:libgrpc-common = "\
    ${libdir}/libaddress_sorting${SOLIBS} \
    ${libdir}/libgpr${SOLIBS} \
    ${libdir}/libupb${SOLIBS} \
    "
FILES:libgrpc++_alts = "\
    ${libdir}/libgrpc++_alts${SOLIBS} \
    "
FILES:libgrpc++_error_details = "\
    ${libdir}/libgrpc++_error_details${SOLIBS} \
    "
FILES:libgrpcpp_channelz = "\
    ${libdir}/libgrpcpp_channelz${SOLIBS} \
    "
FILES:libgrpc++_reflection = "\
    ${libdir}/libgrpc++_reflection${SOLIBS} \
    "
FILES:libgrpc++ = "\
    ${libdir}/libgrpc++${SOLIBS} \
    ${libdir}/libgrpc${SOLIBS} \
    "
FILES:libgrpc++_unsecure = "\
    ${libdir}/libgrpc++_unsecure${SOLIBS} \
    ${libdir}/libgrpc_unsecure${SOLIBS} \
    "

