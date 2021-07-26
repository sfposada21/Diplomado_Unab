@ECHO off

cls

if "%2" == "+" goto suma
if "%2" == "-" goto resta
if "%2" == "*" goto multiplicacion
if "%2" == "/" goto dividir

echo operacion
pause
exit

:suma
set/a res=%1+%3
goto respuesta

:resta
set/a res=%1-%3
goto respuesta

:multiplicacion
set/a res=%1*%3
goto respuesta

:dividir
set/a res=%1/%3

:respuesta
echo %1 %2 %3= %res%
pause>nul
exit

:error 
echo parametros incorrectos
pause>nul
exit

