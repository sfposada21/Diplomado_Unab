ECHO OFF
CLS

title TROLL
:inicio

echo menu
echo 1.apagar
echo 2.reiniciar
echo 3.este no hace nada
echo 4.salir
set/p op= escoja el numero:

if %op%==1 goto apagar
if %op%==2 goto reiniciar
if %op%==3 goto es
if %op%==4 goto salir


:apagar
set/p p= cuanto tiempo lo va apagar:
shutdown -s -t %p% -c "si no lesite el menu se esta apagando"
echo ESTADO : apagando
pause>nul
cls
goto inicio

:reiniciar
set/p p= cuanto tiempo lo va apagar:
shutdown -r -t %p% -c "si no lesite el menu se va a reiniciar"
echo ESTADO : reiniciandose
pause>nul
cls
goto inicio

:es
echo mentiras este si hace algo oprima una tecla
pause>nul
shutdown -a
echo te has salvado has cancelado a tiempo
pause>nul
cls
goto inicio

:salir
echo hasta la proxima
pause>nul
exit