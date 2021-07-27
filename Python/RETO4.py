print(" ----     +++++    *    ++++    -----")
print(" BIENVENIDO AL RETO 4 MISIÓN TIC 2022")
print(" ----     +++++     *     ++++    ----- ")
# Inicio de variables
total = 0
sumatoria_total = 0
listadoClientes = []
ListaProducto_C = []
ListaPrecio_C = []
ListaCantidad_C = []
RAN_1 = 1000000
RAN_2 = 1500000
RAN_3 = 2000000
Descuento = 0
Descuento_2 = 0
Coste_Envio = 0
#

def Menu_Productos():

    MENU = f"\n{'Listado de productos disponibles actualmente en la empresa es: ':>70}\n"
    MENU += f"\n{'REFERENCIA':>20}{'NOMBRE':>30}{'PRECIO':>20}\n"
    MENU += f"{'1':>20}{'Xiaomi Poco X3':>30}{'$ 750000':>20}\n"
    MENU += f"{'2':>20}{'Motorola One Fusion':>30}{'$ 560000':>20}\n"
    MENU += f"{'3':>20}{'Samsung Galaxy A21s':>30}{'$ 700000':>20}\n"
    MENU += f"{'4':>20}{'Portatil Asus M413da':>30}{'$ 2200000':>20}\n"
    MENU += f"{'5':>20}{'Portatil Asus Vivobook':>30}{'$ 3200000':>20}\n"
    MENU += f"{'6':>20}{'Hp Torre Bundle I3-10100':>30}{'$ 3000000':>20}\n"
    print(MENU)

def Nombre_Producto(opcion):
    Producto_o = "ups, hubo un error"
    if opcion == 1:
        Producto_o = "Xiaomi Poco X3"
    if opcion == 2:
        Producto_o = "Motorola One Fusion"
    if opcion == 3:
        Producto_o = "Samsung Galaxy A21s"
    if opcion == 4:
        Producto_o = "Portatil Asus M413da"
    if opcion == 5:
        Producto_o = "Portatil Asus Vivobook"
    if opcion == 6:
        Producto_o = "Hp Torre Bundle I3-10100"
    return Producto_o

def Precio_Producto( opcion ):
    Precio_p = 7421
    if opcion == 1:
        Precio_p = 750000
    if opcion == 2:
        Precio_p = 560000
    if opcion == 3:
        Precio_p = 700000
    if opcion == 4:
        Precio_p = 2200000
    if opcion == 5:
        Precio_p = 3200000
    if opcion == 6:
        Precio_p = 3000000
    return Precio_p

def Recibir_String( longi ):
    while True:
        try:
            Nombre = input("\nEscribe el nombre completo : ")
            if len(Nombre) < longi:
                break
            else:
                print(" ERROR: Nombre demasiado grande")
        except ValueError:
            print(" Ingrese letras ")
    return (Nombre)

def Recibir_Int(limite, mensaje):
    while True:
        try:
            ENTERO = int(input(f"Ingrese {mensaje} : "))
            if type(ENTERO) is int and ENTERO > limite:
                break
            else:
                print("Error: Solo se aceptan valores en un rango adecuado")
        except ValueError:
            print("Error: Solo se aceptan numeros enteros")
    return (ENTERO)

def Recibir_Opcion(limite):
    while True:
        try:
            ENTERO = int(input("Ingrese la opcion deseada : "))
            if type(ENTERO) is int and ENTERO <= limite and ENTERO > 0:
                break
            else:
                print("Error: Solo se aceptan valores en un rango adecuado")
        except ValueError:
            print("Error: Solo se aceptan numeros enteros")
    return (ENTERO)

def Envio(TIPO, FORMA, total, rango1, rango2, rango3):
    # FORMA EXPRESS 1
    Coste_Envio, descuento2 = 0, 0
    if FORMA == 1 and TIPO == 1:
        Coste_Envio = 10000
        if total >= rango1:
            descuento2 = 5000
    if FORMA == 1 and TIPO == 2:
        Coste_Envio = 20000
        if total >= rango2:
            descuento2 = 10000
    if FORMA == 1 and TIPO == 3:
        Coste_Envio = 40000
        if total >= rango3:
            descuento2 = 20000

        # FORMA NORMAL 2
    if FORMA == 2 and TIPO == 1:
        Coste_Envio = 5000
        if total >= rango1:
            descuento2 = 5000
    if FORMA == 2 and TIPO == 2:
        Coste_Envio = 10000
        if total >= rango2:
            descuento2 = 10000
    if FORMA == 2 and TIPO == 3:
        Coste_Envio = 20000
        if total >= rango3:
            descuento2 = 20000
    return (Coste_Envio, descuento2)

def VALOR_PEDIDO(PRECIO, CANTIDAD):
    valor = 0
    Descuento = 0
    for i in range(len(PRECIO)):
        valor += PRECIO[i] * CANTIDAD[i]
        if CANTIDAD[i] >= 6:
            Descuento += PRECIO[i] * CANTIDAD[i] * 0.1
    return valor, Descuento

def Mas_vendido(vector, can):
    diccionario_nuevo = {}
    j = 0
    Product = ""
    Cantid = 0
    for numero_i in vector:
        if numero_i in diccionario_nuevo:
            diccionario_nuevo[numero_i] += can[j]
        else:
            diccionario_nuevo[numero_i] = can[j]
        j += 1
    maxx = 0
    print(diccionario_nuevo)
    for clave in diccionario_nuevo:
        if diccionario_nuevo[clave] > maxx:
            Product = clave
            Cantid = diccionario_nuevo[clave]
            maxx = Cantid
    return Product, Cantid

def Ordenar(L_producto, L_cantidad):
    # doble for
    for cam in range(len(L_cantidad)-1):
        for posicion in range(len(L_cantidad)-1):
            if L_cantidad[posicion] < L_cantidad[posicion+1]:
                #cantidad
                L_cantidad[posicion], L_cantidad[posicion+1] = L_cantidad[posicion+1], L_cantidad[posicion]
                # nombres
                L_producto[posicion], L_producto[posicion+1] = L_producto[posicion+1], L_producto[posicion]
    return (L_producto, L_cantidad)

while True:

    Cliente = {}
    ListaProducto = []
    ListaPrecio = []
    ListaCantidad = []

    print("\n REGISTRO DE USUARIO ")
    # Nombre de cliente
    Nombre = Recibir_String(20)
    Cliente["Nombre"] = Nombre
    # Documento de cliente
    Documento = Recibir_Int(1000000, " el Documento")
    Cliente["Documento"] = Documento

    print("\n REGISTRO DE COMPRAS ")
    while True:
        # eleccion del Producto
        Menu_Productos()
        opcion = Recibir_Opcion(6)

        # nombre del producto
        Producto = Nombre_Producto(opcion)
        ListaProducto.append(Producto)

        # Precio del Producto
        Precio = Precio_Producto(opcion)
        ListaPrecio.append(Precio)

        # Cantidad
        Cantidad = Recibir_Int(0, " la Cantidad deseada")
        ListaCantidad.append(Cantidad)

        # mas vendido
        ListaCantidad_C.append(Cantidad) # el mas vendido
        ListaProducto_C.append(Producto) #el mas vendido

        print("\nDeseas realizar una nueva compra?")
        print(" 1. Agregar Producto | 2. salir")

        var = Recibir_Opcion(2)

        if var == 2:
            print("Fin de registros")
            break

    VALOR_PAGAR, Descuento = VALOR_PEDIDO(ListaPrecio, ListaCantidad)
    Cliente["Precio"] = ListaPrecio
    Cliente["Producto"], Cliente["Cantidad"] = Ordenar(ListaProducto,ListaCantidad)

    print("\n REGISTRO DE ENVIOS ")
    print("Acualmente hay 3 Tipos de envios disponibles ")
    print(" 1. LOCAL | 2 NACIONAL | 3. INTERNACIONAL ")
    # TIPO
    TIPO = Recibir_Opcion(3)

    print("Acualmente hay 2 Formas de envios disponibles ")
    print(" 1. EXPRESS  |  2 NORMAL ")
    # FORMA
    FORMA = Recibir_Opcion(2)

    Coste_Envio, Descuento_2 = Envio(TIPO,FORMA,VALOR_PAGAR,RAN_1,RAN_2,RAN_3)

    Total = VALOR_PAGAR - Descuento - Descuento_2 + Coste_Envio

    Cliente["Total"] = Total
    Cliente["Descuento"] = Descuento+Descuento_2
    Cliente["Descuento_2"] = Descuento_2

    listadoClientes.append(Cliente)

    print(" RESUMEN DE PEDIDO ")
    print(f"{Nombre} ({Documento}) :  {Total}")
    print(" ----     +++++    *    ++++    ----- ")

    print("\nHola de nuevo, Que opciones prefieres")
    print(" 1. Agregar nuevo Registro | 2. salir")

    Sel = Recibir_Opcion(2)

    if Sel == 2:
        print("Fin de registros")
        break


Mensaje = f"\n{'CLIENTE':>20}{'PRODUCTO':>30}{'CANTIDAD':>20}{'DESCUENTO':>20}{'TOTAL':>20} \n"

total = 0.0
for Cliente in listadoClientes:

    for i in range(len(Cliente['Producto'])):
        Producto = Cliente['Producto']
        Cantidad = Cliente['Cantidad']
        if i == 0:
            Mensaje += f"\n{Cliente['Nombre']:>20}{Producto[0]:>30}{Cantidad[0]:>20}" \
               f"{Cliente['Descuento']:>20.1f}{Cliente['Total']:>20.1f}\n"
        else:
            Mensaje += f"{Producto[i]:>50}{Cantidad[i]:>20}\n" \

    total += Cliente['Total']

producto, canti = Mas_vendido(ListaProducto_C,ListaCantidad_C )

Mensaje += f"\n{'TOTAL VENTAS':>20}{total:>30}\n"
Mensaje += f"{'MAS VENDIDO':>20}{canti:>30}{producto:>30}"
print(Mensaje)
