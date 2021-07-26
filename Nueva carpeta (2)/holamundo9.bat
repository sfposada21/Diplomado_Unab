@echo off
title captura variables

set/p edad= escribe tu edad:
:: asi se captura variale 
echo.
cls
echo.
set/p nombre= escribe tu nombre:
echo.
cls
echo.
echo hola %nombre%, segun lo que escribiste tienes %edad% años

echo.
pause
exit       
