@echo off
:inicio

set/a p=%random% %%1000

echo %p%

pause>nul
goto inicio
exit