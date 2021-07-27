print(" ----     +++++    *    ++++    -----")
print(" BIENVENIDO AL RETO 4 MISIÓN TIC 2022")
print(" ----     +++++     *     ++++    ----- ")
# Inicio de variables
import json
total = 0.0
listadoClientes = []
RAN_1 = 1000000
RAN_2 = 1500000
RAN_3 = 2000000
Descuento = 0
Descuento_2 = 0
Coste_Envio = 0

# Cargar documento productos txt
with open ("productos.txt", encoding = "utf-8") as leer:
    jsonProdutos = leer.read()
    if jsonProdutos == "":
        productos = []
    else:
        productos = json.loads(jsonProdutos)

# Cargar documento compras
with open ("compras.txt", encoding = "utf-8") as leer:
    jsonCompras = leer.read()
    if jsonCompras == "":
        listadoClientes = []
    else:
        listadoClientes = json.loads(jsonCompras)
        #print(listadoClientes)

lista_nombre = productos[0]
lista_valor = productos[1]

def Menu():
    MENU = f"\n{'Opciones ':>20}\n"
    MENU += f"{'1':>10}{'':>10}{'Agregar un nuevo producto'}\n"
    MENU += f"{'2':>10}{'':>10}{'Registrar una nueva compra'}\n"
    MENU += f"{'3':>10}{'':>10}{'Ver resumen de compras'}\n"
    MENU += f"{'4':>10}{'':>10}{'Salir'}\n"
    print(MENU)

def Menu_Productos(lista_nombre, lista_valor):

    MENU = f"\n{'Listado de productos disponibles actualmente en la empresa es: ':>70}\n"
    MENU += f"\n{'REFERENCIA':>20}{'NOMBRE':>30}{'PRECIO':>20}\n"

    for i in range(len(lista_nombre)):
        MENU += f"{i+1:>20}{lista_nombre[i]:>30}{'$ '+str(lista_valor[i]):>20}\n"

    print(MENU)

def Nombre_Precio_Producto(opcion):

    return lista_nombre[opcion-1], lista_valor[opcion-1]

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

def Recibir_Int(min, max, mensaje):
    while True:
        try:
            ENTERO = int(input(f"Ingrese {mensaje} : "))
            if type(ENTERO) is int and ENTERO >= min and ENTERO <= max:
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
    Menu()
    opcion_menu = Recibir_Int(1, 4, "la opcion deseada")
    if opcion_menu == 1:
        print("\n REGISTRO DE PRODUCTO ")

        newNombre = Recibir_String(30)
        newValor = Recibir_Int(1000, 10000000, "el precio del nuevo producto")

        lista_nombre.append(newNombre)
        lista_valor.append(newValor)

    if opcion_menu == 2:

        Cliente = {}
        ListaProducto = []
        ListaPrecio = []
        ListaCantidad = []

        print("\n REGISTRO DE USUARIO ")
        # Nombre de cliente
        Nombre = Recibir_String(20)
        Cliente["Nombre"] = Nombre
        # Documento de cliente
        Documento = Recibir_Int(1000000, 10000000000, " el Documento")
        Cliente["Documento"] = Documento

        print("\n REGISTRO DE COMPRAS ")
        while True:
            # eleccion del Producto
            Menu_Productos(lista_nombre, lista_valor)
            large = len(lista_nombre)
            opcion = Recibir_Int(1,large, "la opcion deseada")

            # nombre del producto y Precio del Producto
            Producto, Precio = Nombre_Precio_Producto(opcion)

            ListaProducto.append(Producto)
            ListaPrecio.append(Precio)

            # Cantidad
            Cantidad = Recibir_Int(0, 10000, " la Cantidad deseada")
            ListaCantidad.append(Cantidad)

            print("\nDeseas realizar una nueva compra?")
            print(" 1. Agregar Producto | 2. salir")

            var = Recibir_Int(1, 2, "la opcion deseada")

            if var == 2:
                print("Fin de registros")
                break

        VALOR_PAGAR, Descuento = VALOR_PEDIDO(ListaPrecio, ListaCantidad)

        Cliente["Precio"] = ListaPrecio
        Cliente["Producto"] = ListaProducto
        Cliente["Cantidad"] = ListaCantidad

        Cliente["Producto"], Cliente["Cantidad"] = Ordenar(ListaProducto,ListaCantidad)

        print("\n REGISTRO DE ENVIOS ")
        print("Acualmente hay 3 Tipos de envios disponibles ")
        print(" 1. LOCAL | 2 NACIONAL | 3. INTERNACIONAL ")
        # TIPO
        TIPO = Recibir_Int(1, 3, "la opcion deseada")

        print("Acualmente hay 2 Formas de envios disponibles ")
        print(" 1. EXPRESS  |  2 NORMAL ")
        # FORMA
        FORMA = Recibir_Int(1, 2, "la opcion deseada")

        Coste_Envio, Descuento_2 = Envio(TIPO,FORMA,VALOR_PAGAR,RAN_1,RAN_2,RAN_3)

        Total = VALOR_PAGAR - Descuento - Descuento_2 + Coste_Envio

        Cliente["Total"] = Total
        Cliente["Descuento"] = Descuento+Descuento_2

        listadoClientes.append(Cliente)

        print(" RESUMEN DE PEDIDO ")
        print(f"{Nombre} ({Documento}) :  {Total}")
        print(" ----     +++++    *    ++++    ----- ")

        # Guardar en  productos txt
        parajson = listadoClientes
        jsonClientes = json.dumps(parajson)
        with open ("compras.txt", "w", encoding = "utf-8") as nuevo:
            nuevo.write(jsonClientes)


    if opcion_menu == 3:

        total = 0.0
        Mensaje = f"\n{'CLIENTE':>20}{'PRODUCTO':>30}{'CANTIDAD':>20}{'DESCUENTO':>20}{'TOTAL':>20} \n"

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

        Mensaje += f"\n{'TOTAL VENTAS':>20}{total:>30}\n"
        print(Mensaje)
        break

    if opcion_menu == 4:
        break

# Guardar en  productos txt
parajson = [lista_nombre,lista_valor]
combinacon = json.dumps(parajson)
with open ("productos.txt", "w", encoding = "utf-8") as nuevo:
    nuevo.write(combinacon)