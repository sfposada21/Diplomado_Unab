@echo off
title evaluacion
set /a t=%1%
if %2 gtr %t% goto mayor1
if %3 gtr %t% goto mayor2

echo el numeor mayor de %* es %t%
pause
exit

:mayor1

set /a t=%2
echo el numeor mayor de %* es %t%
pause
exit

:mayor2

set /a t=%3
echo el numeor mayor de %* es %t%
pause
exit