FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += " \
    file://enable-can.txt \
    file://can.cfg \
"

KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/can.cfg"

do_enable_can_dts() {
    DTS="${S}/arch/arm/boot/dts/st/stm32mp157d-dk1.dts"
    if ! grep -q "m_can2_pins_dk1" "${DTS}"; then
        printf '\n' >> "${DTS}"
        cat ${WORKDIR}/enable-can.txt >> "${DTS}"
    fi
}
addtask enable_can_dts after do_patch before do_configure
