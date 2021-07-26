/**
 * @author sposada
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RETO1 {
    /**
     * @param args the command line arguments
     */
    public static int recibirEntero(String mensaje, int min, int max){
        
        Scanner teclado = new Scanner(System.in) ; 
        int numero = 0;
         do{                
            try {
                System.out.println("Escribe " + mensaje);
                numero = teclado.nextInt(); 
                teclado.nextLine();
                if (numero >= min && numero <= max ) {
                    break;
                }else{
                 System.out.println("El numero no puede ser inferior a "+min);   
                }             
            } catch (Exception e) {
             System.out.println("Error");  
             teclado.nextLine();
            }
            }while (true);
         
        return numero;
        
    }
    
    public static double recibirDouble(String mensaje, int min, int max){
        
        Scanner teclado = new Scanner(System.in) ; 
        double numero = 0;
         do{                
            try {
                System.out.println("Escribe " + mensaje);
                numero = teclado.nextInt(); 
                teclado.nextLine();
                if (numero >= min && numero <= max ) {
                    break;
                }else{
                 System.out.println("El numero no puede ser inferior a "+min);   
                }             
            } catch (Exception e) {
             System.out.println("Error");  
             teclado.nextLine();
            }
            }while (true);
         
        return numero;
        
    }
        
    public static String recibirString(String mensaje){
        String nombre;
        Scanner teclado = new Scanner(System.in) ; 
        
        while (true) {                
                try {
                    System.out.println("Escribe "+mensaje);
                    nombre = teclado.nextLine();
                    if (nombre.length() <= 20 ) {
                        break;
                    }else{
                     System.out.println("nombre no puede superar 20 caracteres ");   
                    }            
                } catch (Exception e) {
                }
            }
                
        
        return nombre;
    }
    
    public static double[] costoEnvio( double total, double costeEnvio, int tipo, int forma, double contador){
        int rango1 = 1000000;
        int rango2 = 1500000;
        int rango3 = 2000000;
        double descuento = 0;
        
        
        double resultado [] = new double [3];
        
                //FORMA1
            if (forma == 1 && tipo == 1){
                costeEnvio += 10000;                
                if (total >= rango1){
                    descuento += 5000;
                     contador +=1;       
                            }}            
            if (forma == 1 && tipo == 2){
               costeEnvio += 20000;                
                if (total >= rango2){
                    descuento += 10000;
                     contador +=1;       
                            }}            
            if (forma == 1 && tipo == 3){
               costeEnvio += 40000;                
                if (total >= rango3){
                    descuento += 20000;
                     contador +=1;       
                            }}
            
                    // FORMA NORMAL 2           
            if ( forma == 2 && tipo == 1){
                costeEnvio += 5000;                
                if (total >= rango1){
                    descuento += 5000;
                     contador +=1;       
                            }}            
            if ( forma == 2 && tipo == 2){
               costeEnvio += 10000;                
                if (total >= rango2){
                    descuento += 10000;
                     contador +=1;       
                            }}            
            if ( forma == 2 && tipo == 3){
               costeEnvio += 20000;                
                if (total >= rango3){
                    descuento += 20000;
                     contador +=1;       
                            }}
                
            resultado [0] = costeEnvio;
            resultado [1] = descuento;
            resultado [2] = contador;
            
        return resultado;
    }
    
    public static void main(String[] args) {
        
        
        String nombre;
        
        int numero;
        int numeroCompras;
        int contador = 0;
        int costeEnvio = 0;
        double total;
        double descuento;
        double totalFinal = 0;
        double decimal;
        Scanner teclado = new Scanner(System.in) ; 
        
        numeroCompras = recibirEntero("el numero de compras que deseas : ", 1, 10);
        
        
        
        String Listanombre[] = new String[numeroCompras];                   
        String nombreProductos[] = new String[numeroCompras];        
        double listaPrecios[] = new double[numeroCompras];                
        int listaCantidad[] = new int[numeroCompras];           
        int listaTipo[] = new int[numeroCompras];             
        int listaForma[] = new int[numeroCompras];  
        
                       
        for (int i = 0; i < numeroCompras; i++) {
                        
            nombre = recibirString(" su nombre");
            Listanombre[i] = nombre;
            
            nombre = recibirString(" nombre del producto");
            nombreProductos[i] = nombre;            
            
            decimal = recibirDouble(" el precio del producto : ", 1 , 100000000);
            listaPrecios[i] = decimal;
            
                       
            numero = recibirEntero("la cantidad del producto : ",   1, 100);
            listaCantidad[i] = numero;
            
            // ENVIO
            
            numero = recibirEntero("1.LOCAL  | 2.NACIONAL  |  3.INTERNACIONAL : ",   1, 3);
            listaTipo[i] = numero;
            
                        
            numero = recibirEntero("1.EXPRESS  | 2.NORMAL : ",   1, 2);
            listaForma[i] = numero;
            
            
        }
        System.out.println("Gracias por usar Tienda Mision Tic \n");
         
        String mensaje = String.format("%20s %20s %10s %20s %20s \n", 
                "CLIENTE", "PRODUCTO","CANTIDAD", "DESCUENTO" , "TOTAL");
         
        // String mensaje = "\n";       
        for (int i = 0; i < numeroCompras; i++) {
            
            costeEnvio = 0;
            total = 0;
            descuento = 0;
              
            if (listaCantidad[i] >=6 ) {
                total = (float)listaPrecios[i] * (float)listaCantidad[i];
                descuento = (float)listaPrecios[i] * (float)listaCantidad[i]*(float)0.1;
            } else {                
                total = (float)listaPrecios[i] * (float)listaCantidad[i];
                descuento = 0;                          
            }                 
            
            
            double [] resultados = costoEnvio( total, costeEnvio, listaTipo[i], listaForma[i], contador);
            
            costeEnvio += resultados[0];
            descuento += resultados[1];
            contador += resultados[2];
            
            
            
            total = total + costeEnvio - descuento;
                                             
            mensaje += String.format("%20s %20s %10s %20s %20.1f \n", 
                Listanombre[i], nombreProductos[i], listaCantidad[i], descuento , total);
            
            
           // mensaje += Listanombre[i]+"   " +nombreProductos[i]+"   " +listaCantidad[i]+ "   " +descuento+"   " +total + "\n";        
            
            totalFinal += total;                       
        }
        mensaje += String.format("%20s %10.1f \n", 
                   "TOTAL VENTAS", totalFinal);
        mensaje += "CLIENTES DESCUENTO"+"    "+contador +"\n";
                
        System.out.println(mensaje);                        
    }
    
}
