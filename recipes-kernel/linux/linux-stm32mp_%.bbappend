FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += " \
    file://0001-enable-can.patch \
    file://can.cfg \
"

KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/can.cfg"

KERNEL_DEVICETREE:append = " st/stm32mp157d-dk1-can.dtb"

do_register_can_dtb() {
    MK="${S}/arch/arm/boot/dts/st/Makefile"
    if ! grep -q "stm32mp157d-dk1-can.dtb" "${MK}"; then
        echo 'dtb-$(CONFIG_ARCH_STM32) += stm32mp157d-dk1-can.dtb' >> "${MK}"
    fi
}
addtask register_can_dtb after do_patch before do_configure
