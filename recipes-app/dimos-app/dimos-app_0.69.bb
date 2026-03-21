SUMMARY = "dimos"
DESCRIPTION = "dashboard"
AUTHOR = "UBC-FE"
HOMEPAGE = "None"
BUGTRACKER = "None"
SECTION = "graphics"

LICENSE = "CLOSED"

SRCREV = "6c46747c27d5d5da55d47017a760d510408eee23"
SRC_URI = "gitsm://github.com/UBCFormulaElectric/Consolidated-Firmware.git;lfs=1;branch=master;protocol=https;destsuffix=git"

S = "${WORKDIR}/git"

PUBSPEC_APPNAME = "dimos"
FLUTTER_APPLICATION_INSTALL_SUFFIX = "dimos"
PUBSPEC_IGNORE_LOCKFILE = "1"
FLUTTER_APPLICATION_PATH = "software/dimos"

do_compile[network] = "1"

inherit flutter-app
