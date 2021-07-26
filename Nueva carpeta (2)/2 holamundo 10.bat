ECHO OFF
cls
echo prueba tu suerte
set /p num=numero que quieres:
:inicio
%random%

if %num%==%random% 
goto inicio
if %num%==%random% 
goto fin
:fin

echo felicitaciones 

echo hasta la proxima
pause>nul
exit