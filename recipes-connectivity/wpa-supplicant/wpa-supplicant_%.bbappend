#Add P2P Flag

do_configure() {
    echo "CONFIG_P2P=y" >> wpa_supplicant/.config
}