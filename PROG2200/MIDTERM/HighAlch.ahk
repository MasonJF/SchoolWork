#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.


$+e::
if (enable := !enable)
    setTimer, routine, -1
return

routine:
while enable
{
    Random, r, 1200, 3500
    sleep r
    sendInput {Numpad5}
}
return 

