import pandas as pd
import matplotlib.pyplot as plt

# Codigo de colores
Colores = { "Eficiencia Energetica" : "#00b0f0", 
        "Energias Renovables" : "#ffd966",
        "Fugitivas/Teas/Venteo" : "#1f4e78",
        "Sustitución de combustibles" : "#66ff66",
        "Captura carbono" : "#548235",
        "Hidrógeno" : "#00ffff",}

# Funciones
def AsignarColor (datosGrupos):
        VeCol = []
        for grupo in datosGrupos:
                valor = grupo.strip()
                print(valor)
                if  Colores[valor]:
                        VeCol.append(Colores[grupo.strip()])
                else:
                        VeCol.append("red")
        return  VeCol

# Extraer datos del excel
workbook = "Ejemplo.xlsx"
datos = pd.read_excel(workbook)

# Ordenar datos segun eje y 
nombresCol = datos.columns
datosOrden = datos.sort_values(nombresCol[3])

#Enviar Datos para Asignar colores
grupo = datosOrden[nombresCol[1]]
VeColors = AsignarColor(grupo)

#nombres = datosOrden[nombresCol[1]]
#x = datosOrden[nombresCol[4]]
#y = datosOrden[nombresCol[3]]
#ax = plt.bar( x, y , color = VeColors )

chat = datosOrden[[nombresCol[1] ,nombresCol[3] ,nombresCol[4] ]]
chat.plot.bar(x=nombresCol[1], y = nombresCol[3], width = 1, color = VeColors )
#ax = chat.plot.ayvspan(2, 10, facecolor='g', alpha=0.5)
plt.axvspan(-1,4, color ='pink' , alpha =0.1)
plt.axvspan(4,8, color ='blue' , alpha =0.1)
plt.axvspan(8,13, color ='yellow' , alpha =0.1)

plt.show()