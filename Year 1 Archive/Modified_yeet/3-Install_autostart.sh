#! /bin/sh
cd /home/alarm/
mkdir /home/alarm/.config/autostart
mv /home/alarm/GIT/RTKLIB_Touchscreen_GUI/Installer/RTKBASE.desktop /home/alarm/.config/autostart/RTKBASE.desktop
chmod 777 /home/alarm/.config/autostart/RTKBASE.desktop

reboot
