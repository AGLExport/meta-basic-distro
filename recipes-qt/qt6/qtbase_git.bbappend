FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

#DEPENDS:append = " drm-lease-manager"
#DEPENDS:remove:class-native = " drm-lease-manager"
#DEPENDS:remove:class-nativesdk = " drm-lease-manager"

#SRC_URI:append = " file://0001-Add-drm-lease-client-support-to-eglfs-kms-backend.patch"

PACKAGECONFIG_GRAPHICS = " gles2"
QT_QPA_DEFAULT_PLATFORM = "wayland"

PACKAGECONFIG:append = " eglfs kms gbm examples "
PACKAGECONFIG:remove:class-native = " eglfs kms gbm examples"
PACKAGECONFIG:remove:class-nativesdk = " eglfs kms gbm examples"
