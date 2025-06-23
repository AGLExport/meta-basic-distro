PACKAGECONFIG:remove = "backlight sysvinit vconsole timesyncd quotacheck randomseed"

PACKAGECONFIG[hwdb] = "-Dhwdb=true,-Dhwdb=false"
