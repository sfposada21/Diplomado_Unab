@echo off	
title evaluacion

set /p m=escriba los numeros para sacar:

for /L	 %%y in  (1,1,%m%) DO (

set /p r=escriba el numero:
set /a t=t+r
)

set /a p=%t%/%m%
echo el promedio es %p%
pause>nul 
exit       
