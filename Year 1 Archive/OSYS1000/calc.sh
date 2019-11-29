#! /bin/bash
#
#
#

if test $# -gt 0 ; then
	echo "No arguments were expected :(" >&2
	exit 1
fi

res=1

while true
do
	echo"Enter an int (stop with 'q'):"
	read n
	[ $n = "q" ] && exit 0
	
