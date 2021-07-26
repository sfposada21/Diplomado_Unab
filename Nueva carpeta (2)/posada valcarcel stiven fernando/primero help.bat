@ECHO OFF
setlocal enableDelayedexpansion
title evaluacion

set /p m=escriba la tabla que quieras saber:

for /L	 %%y in  (0,1,10) DO (
set /a r= %m% * %%y 
echo %m% * %%y = !r!
)

pause>nul
exit