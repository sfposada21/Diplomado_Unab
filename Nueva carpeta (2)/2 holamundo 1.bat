ECHO OFF

CLS

for /L %%i in (0,2,50) DO (ECHO %%i)
:: /l indica que el for se basara en conteo de numeros
:: el &&i nombre de la variable que almacenalos datos
:: in (0,1,50) indica que unicia en 0 aumenta en 1 y va del 0 al 50
::echo %%i se ejecutra en cada repetecion del commando

pause>nul
exit