@echo off
title captura variables
:inicio
cls
echo.
echo mola
echo.
pause
cls
echo.
set/p nombre= cual es tu nombre
echo.
echo tu nombre es %nombre%
echo.
echo pulsa una tecla pra volver al principio
echo si quieres salir pulsa x
goto inicio

exit       
