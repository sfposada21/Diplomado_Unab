# Prueba del barrio con 8 casas

# Asignacion de Variables
Casas = [ 1,0,1,0,0,1,0,1 ]
newBarrio = [ 0,0,0,0,0,0,0,0 ]
nday = 2

for i in range(nday):
    
    for casa in range(8):
        # Extremos
        if casa == 0 and Casas[1]==0:
            newBarrio[0]=0
        elif casa == 0 and Casas[0]==1:
            newBarrio[0]=1
        if casa == 7 and Casas[6]==0:
            newBarrio[7]=0
        elif casa == 7 and Casas[6]==1:
            newBarrio[7]=1
        # Cuerpo
        if casa >= 1 and casa <=6:  # recorre la casa 2 a 7
            #print(Barrio[casa])            
            if Casas[casa-1] == Casas[casa+1]:
                newBarrio[casa] = 0
            elif Casas[casa-1]!= Casas[casa+1]:
                newBarrio[casa] = 1           

    Casas = newBarrio
    newBarrio = [ 0,0,0,0,0,0,0,0 ]

print("siguiente dia")
print(Casas)