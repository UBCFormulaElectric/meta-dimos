DESCRIPTION = "Dimos SDK toolchain"
LICENSE = "MIT"

inherit populate_b2qt_qt6_sdk
# inherit qt6-cmake # idk about this one

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-b2qt-embedded-qt6-toolchain-host nativesdk-cmake"
TOOLCHAIN_TARGET_TASK += "\
    packagegroup-b2qt-embedded-toolchain-target \
    packagegroup-qt6-modules \
    libgpiod \ 
    libgpiod-tools \
    libgpiod-dev \
    libsocketcan \
"

PACKAGE_EXCLUDE_COMPLEMENTARY += "qtwebengine-dbg"
PACKAGE_EXCLUDE += "sudo"