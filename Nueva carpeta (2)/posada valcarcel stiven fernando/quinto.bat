@echo off
title evaluacion
set /p nombre=escribe el nombre de la carpeta:
md %nombre%
cd %nombre%

set /p m=escriba el numero de archivos:

for /L	 %%y in  (1,1,%m%) DO ( 
echo archivo %%y de %m%...

echo el nombre del archivo es %%y>archivo%%y.txt
echo  %%y>>archivo%%y.txt
 )

echo listo revisa tu carpeta
pause>nul
exit       
