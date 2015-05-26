LICENSE = "CLOSED"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qtquick1"
inherit qmake5

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://QtWILC1000Demo.tar.gz"

S = "${WORKDIR}/${PN}"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/QtWILC1000Demo/bin/.debug \
  /opt/QtWILC1000Demo/bin/.debug/QtWILC1000Demo \
  /usr/* \
"

FILES_${PN} = " \
  /opt/QtWILC1000Demo/bin/* \
  /opt/QtWILC1000Demo/resources/* \
  /opt/QtWILC1000Demo/qml/* \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
