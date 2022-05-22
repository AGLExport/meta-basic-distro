PACKAGECONFIG:remove = "backlight sysvinit vconsole"

PACKAGECONFIG[hwdb] = "-Dhwdb=true,-Dhwdb=false"
