@echo off
title adivinador
:inicio

echo adivina el numero
echo 1. jugar
echo 2. salir
set/a i=0
set/a A=%random% %%10000
set/p op= escoja:

if %op%==1 goto jugar
if %op%==2 goto salir



:jugar
set/p s=diga un numero:
if %s% LSS %A% goto mayor
if %s% GTR %A% goto menor
if %s% == %A% goto fin
:mayor
set/a i=%i%+1
echo el numero es mayor esta entre %s% a %n% 
set/a m=%s% 
pause>nul
goto jugar
:menor
set/a i=%i%+1
echo el numero es menor esta entre %m% a %s%
set/a n=%s%
pause>nul
goto jugar
:fin
set/a i=%i%+1
echo felicitaciones has adivinado el numero en %i% intentos
pause>nul
goto inicio

:salir

echo gracias por jugar
pause
exit     
