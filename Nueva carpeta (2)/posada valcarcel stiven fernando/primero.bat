@echo off
title evaluacion
:inicio
set /p m=escriba la tabla que quieras saber:

set /a m1=%m%*1
echo %m% * 1 : %m1%
set /a m2=%m%*2
echo %m% * 2 : %m2%
set /a m3=%m%*3
echo %m% * 3 : %m3%
set /a m4=%m%*4
echo %m% * 4 : %m4%
set /a m5=%m%*5
echo %m% * 5 : %m5%
set /a m6=%m%*6
echo %m% * 6 : %m6%
set /a m7=%m%*7
echo %m% * 7 : %m7%
set /a m8=%m%*8
echo %m% * 8 : %m8%
set /a m9=%m%*9
echo %m% * 9 : %m9%
set /a m10=%m%*10
echo %m% * 10 : %m10%

pause>nul

goto inicio
exit       
