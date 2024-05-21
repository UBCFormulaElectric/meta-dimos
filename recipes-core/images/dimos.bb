SUMMARY = "Dimos"

DEPLOY_CONF_TYPE = "Boot2Qt ${QT_VERSION}"

# consider changing from ssh-server-dropbear to ssh-server-openssh
IMAGE_FEATURES += "\
        package-management \
        ssh-server-dropbear \
        tools-debug \
        tools-profile \
        debug-tweaks \
        hwcodecs \
        "

inherit core-image qbsp-image deploy-buildinfo
inherit consistent_timestamps

# add some extra space to the device images
IMAGE_ROOTFS_EXTRA_SPACE = "100000"

IMAGE_INSTALL += "\
    packagegroup-b2qt-embedded-base \
    packagegroup-b2qt-embedded-tools \
    ${@bb.utils.contains("DISTRO_FEATURES", "gstreamer", "packagegroup-b2qt-embedded-gstreamer", "", d)} \
    packagegroup-qt6-modules \
    packagegroup-b2qt-embedded-addons \
    "
