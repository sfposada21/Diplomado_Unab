print(" ----     +++++    *    ++++    -----")
print(" BIENVENIDO AL RETO 3 MISIÓN TIC 2022")
print(" ----     +++++    *    ++++    ----- ")


cantidad_compras = 0
sumatoria_total = 0
Sel = 1
ListaNombres = []
ListaDocumento = []
ListaProducto = []
ListaPrecio = []
ListaCantidad = []
ListaDescuento = []
ListaDescuento_2 = []
ListaTotal = []

while True:

    if Sel == 1:

        print("\n REGISTRO DE USUARIO ")
        # Nombre de cliente
        while True:
            try:
                Nombre = input("\nEscribe el nombre completo : ")
                if len(Nombre) < 20:
                    ListaNombres.append(Nombre)
                    break
                else:
                    print(" ERROR: Nombre demasiado grande")
            except ValueError:
                print(" Ingrese letras ")
        # Documento de cliente
        while True:
            try:
                Documento = int(input("Ingrese el Documento CC : "))
                if type(Documento) is int and Documento > 1000000:
                    ListaDocumento.append(Documento)
                    break
                else:
                    print("Error: Solo se aceptan valores mayores a 1000000")
            except ValueError:
                print("Error: Solo se aceptan numeros enteros")

        print("\n REGISTRO DE COMPRAS ")
        # Nombre del Producto
        while True:
            try:
                Producto = input("\nEscribe el nombre del producto : ")
                if len(Producto) < 20:
                    ListaProducto.append(Producto)
                    break
                else:
                    print("Error: Nombre demasiado grande")
            except ValueError:
                print("Error: Ingrese letras ")
        # Precio del Producto
        while True:
            try:
                Precio = float(input("Ingrese el precio de la unidad : "))
                if type(Precio) is float and Precio > 1:
                    ListaPrecio.append(Precio)
                    break
                else:
                    print("Error: Solo se aceptan precios mayores a 1")
            except ValueError:
                print("Error: Solo se aceptan numeros")
        # Cantidad
        while True:
            try:
                Unidades = int(input("Ingrese la cantidad deseada : "))
                if type(Unidades) is int and Unidades > 0:
                    ListaCantidad.append(Unidades)
                    break
                else:
                    print("Error: Solo se aceptan valores mayores a 1")
            except ValueError:
                print("Error: Solo se aceptan numeros")

        print("\n REGISTRO DE ENVIOS ")
        print("Acualmente hay 3 Tipos de envios disponibles ")
        print(" 1. LOCAL | 2 NACIONAL | 3. INTERNACIONAL ")
        # TIPO
        while True:
            try:
                TIPO = int(input("Ingrese el numero del tipo : "))
                if type(TIPO) is int and (TIPO == 1 or TIPO == 2 or TIPO == 3):
                    break
                else:
                    print("Error: solo valores entre 1 y 3")
            except ValueError:
                print("Error, Escritura invalida")
        print("Acualmente hay 2 Formas de envios disponibles ")
        print(" 1. EXPRESS  |  2 NORMAL ")
        # FORMA
        while True:
            try:
                FORMA = int(input("Ingrese numero de la forma : "))
                if type(FORMA) is int and (FORMA == 1 or FORMA == 2):
                    break
                else:
                    print("Error: Solo valores entre 1 y 2 ")
            except ValueError:
                print("Error, Escritura invalida")

        VALOR_PAGAR = Unidades * Precio
        Descuento = 0
        Descuento_2 = 0
        Coste_Envio = 0

        if Unidades > 5:
            Descuento = VALOR_PAGAR*0.1
        else:
            Descuento = 0

        if FORMA == 2:
            if TIPO == 1:
                Coste_Envio = 5000
                if VALOR_PAGAR >= int(1000000):
                    Descuento_2 = 5000
                else:
                    Descuento_2 = 0
            elif TIPO == 2:
                Coste_Envio = 10000
                if VALOR_PAGAR >= int(1500000):
                    Descuento_2 = 10000
                else:
                    Descuento_2 = 0
            elif TIPO == 3:
                Coste_Envio = 20000
                if VALOR_PAGAR >= int(2000000):
                    Descuento_2 = 20000
                else:
                    Descuento_2 = 0
        elif FORMA == 1:
            if TIPO == 1:
                Coste_Envio = 10000
                if VALOR_PAGAR >= int(1000000):
                    Descuento_2 = 5000
                else:
                    Descuento_2 = 0
            elif TIPO == 2:
                Coste_Envio = 20000
                if VALOR_PAGAR >= int(1500000):
                    Descuento_2 = 10000
                else:
                    Descuento_2 = 0
            elif TIPO == 3:
                Coste_Envio = 40000
                if VALOR_PAGAR >= int(2000000):
                    Descuento_2 = 20000
                else:
                    Descuento_2 = 0

        Total = VALOR_PAGAR - Descuento - Descuento_2 + Coste_Envio

        ListaTotal.append(Total)
        ListaDescuento.append(Descuento)
        ListaDescuento_2.append(Descuento_2)

        print(" RESUMEN DE PEDIDO ")
        print(f"{Nombre} ({Documento}) : {Unidades} {Producto} {Total}")
        print(" ----     +++++    *    ++++    ----- ")
        cantidad_compras = cantidad_compras+1
        sumatoria_total += Total


        print("\nHola de nuevo, Que opciones prefieres")
        print(" 1. Agregar nuevo Registro | 2. salir")

        while True:
            try:
                Sel = int(input(" Seleciona : "))
                if type(Sel) is int and (Sel == 1 or Sel == 2):
                    break
                else:
                    print("Error: Solo valores entre 1 y 2 ")
            except ValueError:
                print("Error, Escritura invalida")
    if Sel == 2:
        print("Fin de registros")
        break

Mensaje = f"\n{'CLIENTE':>20}{'PRODUCTO':>20}{'CANTIDAD':>20}{'DESCUENTO':>20}{'TOTAL':>20} \n"

contador = 0
Total_VENTAS = 0

for i in range(len(ListaNombres)):
    Mensaje += f"{ListaNombres[i]:>20}{ListaProducto[i]:>20}{ListaCantidad[i]:>20}" \
               f"{ListaDescuento[i]+ListaDescuento_2[i]:>20.1f}{ListaTotal[i]:>20.1f}\n"

    if ListaDescuento_2[i] >= 1:
        contador += 1
    Total_VENTAS += ListaTotal[i]

Mensaje += f"\n{'TOTAL VENTAS':>20} {Total_VENTAS:>20} \n"
Mensaje += f"{'CLIENTES DESCUENTO':>20} {contador:>20}"
print(Mensaje)

