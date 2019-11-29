#! /bin/bash

#Took previous assignment my_echo and modified to to work as a zenity application!


arg=$(zenity --entry --title="Int Checker" --text="Enter your Arguments: ")

for i in $arg; do #for loop for taking multiple Arguments
  if [ $i -eq $i 2>/dev/null ] #Checks if the argument is an integer
    then
      zenity --info --text="$i is an integer!"
    else
      zenity --info --text="$i is not and integer!"
    fi
done
