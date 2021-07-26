@echo off
title captura variables

set/p num1= escribe numero 1 :
:: asi se captura variale 

set/p num2= escribe numero 2 :

set/a num3=%num1%+%num2%
:: calculo matematico

echo %num1%+%num2%=%num3%

echo.
pause
exit       
