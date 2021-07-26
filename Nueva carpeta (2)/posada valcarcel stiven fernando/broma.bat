@echo off
title evaluacion
set /p nombre=escribe el nombre de la carpeta:
md %nombre%
cd %nombre%

set /p m=escriba el numero de carpetas:

for /L	 %%y in  (1,1,%m%) DO ( 
echo archivo %%y de %m%...
md %nombre%
cd %nombre%

 )
 
echo pevertido en la mira > Hentai.txt
echo por que no haces cosas productivas >> Hentai.txt

echo listo revisa tu carpeta
pause>nul
exit       
