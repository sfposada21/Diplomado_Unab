
cadena = "carlos"

cantidad = len(cadena)
fact = 1  
for i in range(1, cantidad+1):
    fact = fact * i



permutaciones = []
palabra = []
for i in range(cantidad):
    palabra.append(cadena[i])    
    permutaciones.append(palabra)

print(permutaciones)