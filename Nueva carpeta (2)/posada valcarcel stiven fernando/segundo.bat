@echo off	
title evaluacion
COLOR 02
mode con cols=50
mode con lines=50
set/a c1=0
set/a c2=2

:color
echo 0-Negro.		 8-Gris.
echo 1-Azul.		 9-Azul Claro.
echo 2-Verde.		 A-Verde  Claro.
echo 3-Aguamarina.	 B-Aguamarina Claro.
echo 4-Rojo.		 C-Rojo Claro.
echo 5-Purpura.	 D-Purpura Claro.
echo 6-Amarillo.	 E-Amarillo Claro.
echo 7-Blanco.		 F-Blanco Brillante.

:inicio

echo.
echo menu de congiguracion
echo 1. cambiar el color del fondo
echo 2. cambiar el color de la letra
echo 3. cambiar el tamaño de las columnas
echo 4. cambiar el tamaño de las filas
echo 5. ayuda de colores
echo 6. no cambiar
set /P op=selecione : 

if %op%== 1 goto n1
if %op%== 2 goto n2
if %op%== 3 goto n3 
if %op%== 4 goto n4
if %op%== 5 goto color
if %op%== 6 goto la


:n1
set /p c1=escribe un numero del 1 al 9 para el color de pantalla :
COLOR %c1%%c2%
echo.
goto n5
:n2
set /p c2=escribe un numero del 1 al 9 para el color de letra :
COLOR %c1%%c2%
echo.
goto n5
:n3
set /p c3=escribe un numero de columnas :
mode con cols=%c4% 
echo.
goto n5
:n4
set /p c4=escribe un numero de lineas :
mode con lines=%c3%
echo.

:n5
echo este es una linea para molestar
goto inicio

pause
exit    


:la
echo hasta la vista? 
pause
exit       
