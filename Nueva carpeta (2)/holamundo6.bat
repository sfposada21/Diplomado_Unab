@echo off
title vamos para el 6
copy nuevo.txt copia.txt
move copia.txt c:\prueba\otracopia.txt
del copia.txt
cd c:\prueba\
copy otracopia.txt copia2.txt

exit       
