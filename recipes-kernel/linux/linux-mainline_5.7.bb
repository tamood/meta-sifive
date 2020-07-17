require recipes-kernel/linux/linux-mainline-common.inc

LINUX_VERSION ?= "5.7.x"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "linux-5.7.y"
SRCREV = "v5.7.2"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=${BRANCH} \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI_append = " \
    file://riscv-dont-mark-init-section-as-non-executable.patch \
"

SRC_URI_append_freedom-u540 = " \
    file://0022-DT-entry.patch \
"

# For freedom-u540 use out-of-tree defconfig
# The upstream defconfig might contain a large number of debug options, which
# could affect the performance.
SRC_URI_append_freedom-u540 = " file://defconfig"
