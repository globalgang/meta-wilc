# meta-wilc

-Poky Build Error Fix-

1. Network Fail
  - edit /meta-yocto/conf/distro/poky.conf
  - CONNECTIVITY_CHECK_URIS = ""
2. Library
  - build-essential
  - device-tree-compiler
  - lzma
  - lzop
  - u-boot-tools
  - libncurses5-dev:amd64 
  - diffstat
  - gawk
  - chrpath
  - libsdl1.2-dev
  - pandoc
  - texinfo
3. local.conf
  - IMAGE_INSTALL_append += " \
  - hostapd \
  - linux-firmware-atmel-wilc1000 \ 
  - wilc1000 \
  - wilc1000-demo-init"
