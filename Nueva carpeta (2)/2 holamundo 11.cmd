@echo off
:inicio
set /a p=%random%
set/a m=32767/25
set/a x=p/(%m%+1)
echo mostrar %x%
pause>nul
goto inicio
exit