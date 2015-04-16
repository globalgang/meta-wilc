LICENSE = "CLOSED"

inherit module

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/linux4sc/wireless-driver.git"

S = "${WORKDIR}/git/wilc1000/"

# CONFIG_WILC1000=m
# CONFIG_WILC1000_SDIO=y
# CONFIG_WILC1000_SPI is not set
# CONFIG_WILC1000_PREALLOCATE_DURING_SYSTEM_BOOT=y
# CONFIG_WILC1000_PREALLOCATE_AT_LOADING_DRIVER is not set
# CONFIG_WILC1000_DYNAMICALLY_ALLOCATE_MEMROY is not set
# CONFIG_WILC1000_HW_OOB_INTR is not set
# CONFIG_WINLC100X_ENABLE_DEBUGFS is not set

EXTRA_OEMAKE = '-C ${STAGING_KERNEL_DIR} M=${S} \
  CONFIG_WILC1000=m \
  CONFIG_WILC1000_SDIO=y \
  CONFIG_WILC1000_DYNAMICALLY_ALLOCATE_MEMROY=y \
  '

do_install() {
  install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/atmel/wilc1000
  install -m 0644 wilc1000${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/atmel/wilc1000
}

#Load Driver Module at Boot
KERNEL_MODULE_AUTOLOAD += "wilc1000"