
package eventossocial;

import java.util.Scanner;

/**
 *
 * @author sposada
 */
public class EventosSocial {

       public static void main(String[] args) {
 
       
           Servicio[] listaServicios = new Servicio[4];
           
           // FORMA CON CONSTRUCTOR RECOMENDADA
           listaServicios[0]= new Servicio("Ninguno",0,0);               
           listaServicios[1] = new Servicio("Animador",150000,100000);           
           listaServicios[2] = new Servicio("DJ",100000,50000);  
           listaServicios[3] = new Servicio("Banda en vivo",200000,150000);  
           
           // FORMA CLASICA NO RECOMENDADA 
           //Servicio servicio4 = new Servicio();           
           //servicio4.nombre = "Banda en vivo";
           //servicio4.precioNormal= 200000;
           //servicio4.precioGrande= 150000;           
           //listaServicios[3] = servicio4;
           
            ClientePremiun[] misClientesPre = new ClientePremiun[3];
           
           // FORMA CON CONSTRUCTOR RECOMENDADA
           misClientesPre[0]= new ClientePremiun("Juan","3432423432", "juan98", "", 123);               
           misClientesPre[1] = new ClientePremiun("Maria","2241412414", "maria21", "", 456);           
           misClientesPre[2] = new ClientePremiun("Jose","43124324", "", "jose63", 789);  
           
                     
           
           Scanner teclado = new Scanner(System.in) ; 
           System.out.print("Escribe la cantidad de eventos : ");
           int cantidad = teclado.nextInt();
           
           Evento[] listaEventos = new Evento[cantidad];
           
           for (int i = 0; i < cantidad; i++) {
               
               
               
               System.out.println(" \n Evento : "+(i+1)+"\n");
               
               Cliente miCliente = new Cliente();  
               Evento miEvento = new Evento();
               
               System.out.print("Deseas usar un codigo de cliente? 1. si| 2.no : ");
               int opcionc = teclado.nextInt();
               
               if ( opcionc == 1 ) {
                   do {
                       int salir = 0;
                       System.out.print("Escribe el codigo del cliente : ");
                       int codigo = teclado.nextInt();
                       
                       for (ClientePremiun miclientepre : misClientesPre) {
                           
                           if (miclientepre.getCodigo() == codigo){
                               miCliente = miclientepre;
                               salir = 1; 
                               break;
                           }                           
                       }                       
                       if (salir == 1) {
                           break;
                       }
                       System.out.println("Cliente no encontrado ");
                       
                   } while (true);
                   
               } else {     
                   
                   teclado.nextLine();
               
               System.out.print("Escribe el nombre : ");
               String nombre = teclado.nextLine();
               miCliente.setNombre(nombre);
               
               System.out.print("Escribe el documento : ");
               String documento = teclado.nextLine();
               miCliente.setDocumento(documento);
               }
                              
               miEvento.cliente = miCliente;
               
               System.out.print("Escribe tipo de salon: 1. normal | 2. grande : ");
               int salon = teclado.nextInt();
               miEvento.setSalon(salon);
                             
               System.out.print("Quieres meseros extras: 1.sI | 2.no : ");
               int mExtra = teclado.nextInt();
               
               if (mExtra==1) {
                   System.out.print("cuantos meseros extras : ");
                   int meseros = teclado.nextInt();
                   miEvento.setMeseros(meseros);
               }
              
               System.out.print("Quieres comida 1.Si | 2.no : ");
               int comida = teclado.nextInt();
               
               if (comida==1) {
                   System.out.print("cuantos platos extras : ");
                   int platos = teclado.nextInt();
                   miEvento.setPlatos(platos);
               }
               
               System.out.print("Escribe la cantidad de botellas :");
               int botellas = teclado.nextInt();
                   miEvento.setBotellas(botellas);
               
               
               for (int j = 0; j < listaServicios.length; j++) {
                   
                   Servicio miServiio = listaServicios[j];
                   System.out.println((j+1)+"."+miServiio.getDescripcion(miEvento.getSalon()));
                          
               }
    
                System.out.println(" Selecione el servicio : ");
                int opcion = teclado.nextInt();
                
                miEvento.servicio = listaServicios[opcion-1];
                        
                listaEventos[i] = miEvento;
           }    
                       
           String mensaje = String.format("%30s %10s %10s %10s %10s %25s %20s %20s \n", "CLIENTE", "SALON",
                 "MESEROS", "PLATOS", "BOTELLAS", "SERVICIO",
                 "DESCUENTO", "TOTAL");
           double total =0;
           for (int i = 0; i < cantidad ; i++) {
               Evento miEvento = listaEventos[i];
               mensaje += miEvento.getImpresion();
                       
               
               total += miEvento.getTotal();
           }
            mensaje += String.format("%30s %20.1f \n", 
                   "TOTAL VENTAS", total);
                        
           
           
           System.out.println(mensaje);
    }
    
}
