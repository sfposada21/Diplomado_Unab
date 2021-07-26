@ECHO off
echo parametro 0: %0
echo parametro 1: %1
echo parametro 2: %2
echo todos los parametros: %*
pause>nul
SHIFT
echo con shift
echo parametro 0: %0
echo parametro 1: %1
echo parametro 2: %2
echo todos los parametros: %*
pause>nul
exit