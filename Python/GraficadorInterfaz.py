# Librerias 
from abc import abstractproperty
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import tkinter
from tkinter import messagebox, filedialog

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
                if  Colores[valor]:
                        VeCol.append(Colores[grupo.strip()])
                else:
                        VeCol.append("red")
        return  VeCol

def nuevosVectores(datosX, datosY, datosC):
        dx = []
        dy = []
        dc = []
        VecNum = []
        total = sum(datosX)
        
        contador = 1
        for valor in datosX:
                res = (((valor/total)*100)/2)+1
                VecNum.append( round( res ) )

        for i in range(len(VecNum)):
                
                for j in range(VecNum[i]):
                        dx.append(contador)
                        dy.append(datosY[i])
                        dc.append(datosC[i])
                        contador += 1 

        promedio = round( total/len(dx) )
        suma  = 0
        dx[0] = promedio/2
        for i in range(1, len(dx)):
                suma += promedio
                dx[i] = suma

        return  dx, dy, dc, VecNum, promedio

def obtenerSpan(vecNum, datosY, datosX, promedio):
        span = []
        vtotal = []
        span.append(0)
        span.append(20)
        span.append(40)
        span.append(sum(vecNum)*promedio)
        menor = 0
        entre = 0
        total1 = 0
        total2 = 0
        total3 = 0

        for elem in range(len(datosY)):
                if datosY[elem] <= 0:
                        menor += vecNum[elem]
                        total1 += datosX[elem]
                if datosY[elem] <= 40:
                        entre += vecNum[elem]
                        total2 += datosX[elem]
                if datosY[elem] >= 40 :
                        total3 += datosX[elem]
        
        vtotal.append(total1)
        vtotal.append(total2)
        vtotal.append(total3)

        span[1] = (menor)*promedio - promedio/2
        span[2] = (entre)*promedio - promedio/2
        return span, vtotal

def obtenerPOS(vecNum, datosY, promedio):
        PosX, PosY = [] , []
        sum = 0
        neg = -10
        for i in range(len(datosY)):
                if datosY[i] <= 0:
                        PosY.append(datosY[i]+neg)
                else:
                        PosY.append(neg)

                var = ((vecNum[i])/2)*promedio      
                PosX.append(sum + var)
                sum += vecNum[i]*promedio

        return PosX, PosY

def AbrirArchivo():
    archivo = filedialog.askopenfilename(title="Abrir", initialdir="c:/")
            
    # Extraer datos del excel
    datos = pd.read_excel(archivo)

    # Ordenar datos segun eje y 
    nombresCol = datos.columns
    datosOrden = datos.sort_values(nombresCol[3])

    # Enviar Datos para Asignar colores
    grupo = datosOrden[nombresCol[1]]
    VeColors = AsignarColor(grupo)

    # Asignar datos 
    nombres = datosOrden[nombresCol[1]]
    datosx = datosOrden[nombresCol[4]]
    datosy = []
    for valor in datosOrden[nombresCol[3]]:
            datosy.append(valor)
    max = np.amax(datosy)
    labels = []
    for valor in datosOrden[nombresCol[0]]:
            labels.append(valor)
    index = np.arange(1,len(labels)+1)

    # Enviar datos para aumentar barras
    Dx, Dy, Dc, vecNum, promedio= nuevosVectores(datosx, datosy, VeColors)

    # Obtener zonas de span
    span, vtotal= obtenerSpan(vecNum, datosy, datosx, promedio)

    #Obtener posiciones de los numeros
    POSX, POSY = obtenerPOS(vecNum, datosy, promedio)

    # Realizar grafica 
    plt.figure(figsize=(20,15))
    plt.bar( Dx, Dy , width = promedio , color = Dc )
    plt.title("Curva marginal de abatimiento a 2030 $/tCO2e", color="#22142b", loc= "left", fontname="Arial", fontsize=18, fontweight='bold')
    plt.axvspan(span[0],span[1], color ='green' , alpha = 0.1, label = "Costo menor a o $/tCO2e")
    plt.axvspan(span[1],span[2], color ='pink' , alpha = 0.2, label = "Costo menor a 40 $/tCO2e")
    plt.axvspan(span[2],span[3], color ='gray' , alpha = 0.2, label = "Costo mayor a 40 $/tCO2e")
    
    plt.legend(ncol=3, mode="expand") 
    plt.axhline(40, color ='gray' , label = "Precio Sombra", linestyle='--')

    plt.text(span[0]+promedio,max-30, f'{vtotal[0]} T CO2e', color="#22142b", fontname="Arial", fontweight='bold', bbox ={'facecolor': '#b6f1ad','alpha': 0.7,'edgecolor':'#b6f1ad','pad': 5 })
    plt.text(span[1]+promedio,max-30, f'{vtotal[1]} T CO2e', color="#22142b", fontname="Arial", fontweight='bold', bbox ={'facecolor': '#fec2cc','alpha': 0.7,'edgecolor':'#fec2cc','pad': 5 })
    plt.text(span[2]+promedio,max-30, f'{vtotal[2]} T CO2e', color="#22142b", fontname="Arial", fontweight='bold', bbox ={'facecolor': '#c8c8c8','alpha': 0.7,'edgecolor':'#c8c8c8','pad': 5 })
    plt.text(0, 48, f'Precio Carbono 40 $/t', bbox ={'facecolor': '#c8c8c8','alpha': 0.7,'edgecolor':'#c8c8c8','pad': 5 })

    for i in range(len(VeColors)):
            plt.text( POSX[i]-promedio/2, POSY[i], f'{i+1}', bbox ={'facecolor': VeColors[i],'alpha': 0.7,'edgecolor':'#c8c8c8', 'boxstyle':'circle' })

    plt.show()
    
    fig, ax =plt.subplots(1,1)
    data= labels
    column_labels=["Iniciativas priorizadas"]
    df=pd.DataFrame(data,columns=column_labels)
    ax.axis('tight')
    ax.axis('off')
    ax.table(cellText=df.values,
                cellLoc="center",
                colLabels=df.columns,
                rowLabels=index,
                rowColours =VeColors,  
                rowLoc= "center",
                loc="center")
    plt.show()

    
# Crear Interfaz visual
ventana = tkinter.Tk()
ventana.geometry("300x200")
etiqueta = tkinter.Label(ventana, text ="Graficador Elyon raa")
etiqueta.pack()
boton = tkinter.Button(ventana, text ="Selecioanr archivo xlsx", command = AbrirArchivo )
boton.pack( padx=80, pady=50, ipadx=30, ipady=30)
ventana.mainloop()

