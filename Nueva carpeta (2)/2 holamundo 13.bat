@echo off
title adivinador
:inicio
echo adivina el numero
echo 1. jugar
echo 2. salir
set/p op=elija:

if %op%=1 goto jugar
if %op%=2 goto salir

:jugar
pause


set/a A=%random% %%10000
set/p n=diga un numero:
set/a %i%==%i%+1
if %n%LSS%A% goto mayor
if %n%GTR%A% goto menor
if %n%=%A% goto fin

:mayor
echo el numero es mayor
pause>nul
goto inicio

:menor
if %n%GTR%A%
echo el numero es menor
pause>nul
goto inicio

:fin
echo felicitaciones has adivinado el numero en %i% intentos
pause>nul

:salir
echo gracias por participar
pause
exit