FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-scripts-ta_bin_to_c.py-remove-blank-lines.patch \
    file://0002-core-early_ta-expose-TA-flags-in-struct-early_ta.patch \
    file://0003-core-move-for_each_early_ta-macro-to-kernel-early_ta.patch \
    file://0004-core-device-pta-enumerate-early-TAs.patch \
    file://0005-core-device-pta-add-flag-to-indicate-dependency-on-t.patch \
"
