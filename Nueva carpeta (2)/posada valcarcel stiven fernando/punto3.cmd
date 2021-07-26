@echo off
title Quiz
set/a t=%1%
if %2 gtr %t% (set/a t=%2)
if %3 gtr %t% (set/a t=%3)
echo El numero mayor de %* es el %t%
pause>nul
exit