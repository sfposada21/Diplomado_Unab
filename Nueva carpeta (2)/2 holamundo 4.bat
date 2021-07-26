ECHO OFF
CLS
echo este es el D
for /D %%x in  (*) DO (ECHO %%x)
echo este es R
for /R %%x in  (*) DO (ECHO %%x)

pause>nul
exit