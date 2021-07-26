@echo off
:inicio

set/a A=%random% %%11

echo %a%
pause

goto inicio

exit       
