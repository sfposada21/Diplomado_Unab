
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
           
          
                                
           Scanner teclado = new Scanner(System.in) ; 
           System.out.print("Escribe la cantidad de compras : ");
           int cantidad = teclado.nextInt();
           
           Compra[] listaCompras = new Compra[cantidad];
           
           for (int i = 0; i < cantidad; i++) {
               
               teclado.nextLine();
               
               
               Compra miCompra = new Compra();              
               Producto miProducto = new Producto();
               
               System.out.println("Escribe el nombre : ");
               miCompra.cliente = teclado.nextLine();
               
               for (int j = 0; j < listaProductos.length; j++) {
                   
                   Producto elProducto = listaProductos[j];
                   System.out.println((j+1)+"."+elProducto.getDescripcion());
                   
               }
    
                System.out.println(" Selecione el servicio : ");
                int opcion = teclado.nextInt();
                
                miCompra.producto = listaProductos[opcion-1];
                
                System.out.println("Escribe la cantidad del producto : ");
                int cantidadP = teclado.nextInt();               
                miCompra.cantidad = cantidadP;
                                          
              
               System.out.println("Escribe tipo de lugar : 1. Local | 2. Nacional | 3.Internacional : ");
               int tipoLugar = teclado.nextInt();    
               miCompra.tipoLugar = tipoLugar;
               
              
               System.out.println("Escribe tipo de Envio : 1.Express  | 2.Normal : : ");
               int tipoEnvio = teclado.nextInt();
               miCompra.tipoEnvio = tipoEnvio;
               
               
                listaCompras[i] = miCompra;
           }        
                      
           String mensaje = String.format("\n %20s %40s %10s %25s %15s %20s \n", 
                "CLIENTE", "PRODUCTO","CANTIDAD", "ENVIO" ,"DESCUENTO" , "TOTAL");
           
           for (int i = 0; i < cantidad ; i++) {
               Compra laCompra = listaCompras[i];
               mensaje += laCompra.getImpresion();
               
               total += laCompra.getTotal();
           }
           
           mensaje += String.format("%20s %10.1f \n", 
                   "TOTAL VENTAS", total);
           
                              
           System.out.println(mensaje);  
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
