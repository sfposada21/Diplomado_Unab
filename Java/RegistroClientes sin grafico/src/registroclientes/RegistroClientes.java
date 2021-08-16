
import java.util.Scanner;

/**
 * @author sposada
 */
public class RegistroClientes {

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       double total = 0;
       
       Producto[] listaProductos = new Producto[4];           
           // FORMA CON CONSTRUCTOR RECOMENDADA
           listaProductos[0]= new Producto("Xiaomi Poco X3", 750000);               
           listaProductos[1] = new Producto("Motorola One Fusion", 560000);           
           listaProductos[2] = new Producto("Samsung Galaxy A21s",700000);  
           listaProductos[3] = new Producto("Portatil Asus M413da",2200000); 
           
        ClientePremium[] misClientesPre = new ClientePremium[4];           
        // FORMA CON CONSTRUCTOR RECOMENDADA
            misClientesPre[0]= new ClientePremium("Juan","juan65", "C0001", 1);               
            misClientesPre[1] = new ClientePremium("Maria","maria58", "C0002", 2);             
            misClientesPre[2] = new ClientePremium("Jose","jose36", "C0003", 2);   
            misClientesPre[3] = new ClientePremium("Diana","diana21", "C0004", 1);   

           Scanner teclado = new Scanner(System.in) ; 
           System.out.print("Escribe la cantidad de compras : ");
           int cantidad = teclado.nextInt();
           
           Compra[] listaCompras = new Compra[cantidad];
           
           for (int i = 0; i < cantidad; i++) {
               
               System.out.println(" \n Compra : "+(i+1)+"\n");
                              
               Compra miCompra = new Compra();           
               Cliente miCliente = new Cliente();  
               
               
               System.out.print("Deseas usar un codigo de cliente? 1. si| 2.no : ");
               int opcionc = teclado.nextInt();
               
               if ( opcionc == 1 ) {
                   
               teclado.nextLine();
               
                   do {
                       int salir = 0;
                       System.out.print("\n Escribe el codigo del cliente : ");
                       String codigo = teclado.nextLine();    
                       
                       for (ClientePremium miclientepre : misClientesPre) {     
                           
                           if ( (miclientepre.getCodigo()).equalsIgnoreCase(codigo)){
                               miCliente = miclientepre;
                               salir = 1; 
                               break;
                           }                           
                       }                       
                       if (salir == 1) {
                           break;
                       }
                       System.out.println("\n Cliente no encontrado ");
                   } while (true);                   
               } else {             
                
               teclado.nextLine();                                     
               System.out.print("\n Escribe el nombre : ");
               String nombre = teclado.nextLine();
               miCliente.setNombre(nombre);
               }              
                              
               miCompra.cliente = miCliente;
               
               for (int j = 0; j < listaProductos.length; j++) {
                   
                   Producto elProducto = listaProductos[j];
                   System.out.println((j+1)+"."+elProducto.getDescripcion());
                   
               }
    
                System.out.print("\n  Selecione el Producto : ");
                int opcion = teclado.nextInt();
                
                miCompra.producto = listaProductos[opcion-1];
                
                System.out.print("\n Escribe la cantidad del producto : ");
                int cantidadP = teclado.nextInt();               
                miCompra.cantidad = cantidadP;
                                          
              
               System.out.print("\n Escribe tipo de lugar : 1. Local | 2. Nacional | 3.Internacional : ");
               int tipoLugar = teclado.nextInt();    
               miCompra.tipoLugar = tipoLugar;
               
              
               System.out.print("\n Escribe tipo de Envio : 1.Express  | 2.Normal : : ");
               int tipoEnvio = teclado.nextInt();
               miCompra.tipoEnvio = tipoEnvio;
               
               
                listaCompras[i] = miCompra;
           }        
                      
           String mensaje = String.format("\n %20s %40s %10s %25s %15s %20s \n", 
                "CLIENTE", "PRODUCTO","CANTIDAD", "ENVIO" ,"DESCUENTO" , "TOTAL");
           
           for (int i = 0; i < cantidad ; i++) {
               Compra laCompra = listaCompras[i];
               mensaje += laCompra.getImpresion();
               
               total += laCompra.getTotalFinal();
           }
           
           mensaje += String.format("%20s %20.1f \n", 
                   "TOTAL COMPRAS", total);
           
                              
           System.out.println(mensaje);  
        
    }
    
                
}
