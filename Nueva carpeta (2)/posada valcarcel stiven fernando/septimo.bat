@echo off
title evaluacion
setlocal enableDelayedexpansion


set /a m=%1
for /L	 %%y in  (0,1,10) DO (
set /a r= %m% * %%y 
echo %m% * %%y = !r! >>tabla.txt
)
echo.>>tabla.txt
echo.>>tabla.txt
if "%2"=="" goto fin
set /a d=%2
for /L	 %%y in  (0,1,10) DO (
set /a r= %d% * %%y 
echo %d% * %%y = !r! >>tabla.txt
)
echo.>>tabla.txt
echo.>>tabla.txt
if "%3"=="" goto fin
set /a g=%3
for /L	 %%y in  (0,1,10) DO (
set /a r= %g% * %%y 
echo %g% * %%y = !r! >>tabla.txt
)
:fin

pause>nul
exit       
