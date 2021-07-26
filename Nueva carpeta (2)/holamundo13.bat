@echo off
title calculadora
:inicio

echo menu
echo 1.sumar
echo 2.restar
echo 3.dividir
echo 4.multiplicar 
echo 5.salir
set/p op= escoja el numero:

if %op%==1 goto sumar
if %op%==2 goto restar
if %op%==3 goto dividir
if %op%==4 goto multiplicar
if %op%==5 goto salir


:sumar

echo sumar
set/p num1=  numero 1 :
set/p num2=  numero 2 :
set/a num3=%num1%+%num2%
echo %num1%+%num2%=%num3%
pause
goto inicio

:restar

echo restar
set/p num1=  numero 1 :
set/p num2=  numero 2 :
set/a num3=%num1%-%num2%
echo %num1%-%num2%=%num3%
pause
goto inicio

:dividir

echo dividir
set/p num1= escribe dividiendo :
set/p num2= escribe divisor :
set/a num3=%num1%/%num2%
echo %num1%/%num2%=%num3%
pause
goto inicio

:multiplicar

echo multiplicar
set/p num1= multiplicador 1 :
set/p num2= multiplicador 2 :
set/a num3=%num1%*%num2%
echo %num1%*%num2%=%num3%
pause
goto inicio

:salir

echo gracias usar calculadora cmd
pause
exit     
