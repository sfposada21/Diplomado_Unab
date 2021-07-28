/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventossociales;

import eventossociales.Cliente;
import eventossociales.Evento;
import eventossociales.Servicio;
import java.util.Scanner;

/**
 *
 * @author sebca
 */
public class EventosSociales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
//        Persona miPersona = new Persona();

        Cliente pruebaCliente = new ClientePremium("Juan", "1234567898", "juan98"
                , "", 123);
        Servicio pruebaServicio = new Servicio("Ninguno", 0, 0);
        
        if(pruebaCliente instanceof Descriptible){
            System.out.println("Cliente se puede describir normal");
            pruebaCliente.getDescripcion();
        }
        
        if(pruebaServicio instanceof Imprimible){
            System.out.println("Servicio se puede imprimir normal");
        }else{
            System.out.println("Servicio No se puede describir normal");
        }
        
        
        ClientePremium[] listaClientes = new ClientePremium[3];
        listaClientes[0]= new ClientePremium("Juan", "1234567898", "juan98"
                , "", 123);
        
        listaClientes[1]= new ClientePremium("Maria", "987654321", "maria21"
                , "", 456);
        
        listaClientes[2]= new ClientePremium("Jose", "741852963", "jose63"
                , "", 789);
        
               
        
        Servicio[] listaServicios = new Servicio[4];
        
        listaServicios[0]=new Servicio("Ninguno", 0, 0);
        listaServicios[1]=new Servicio("Animador", 150000, 100000);
        listaServicios[2]=new Servicio("DJ", 100000, 50000);
        listaServicios[3]=new Servicio("Banda en vivo", 200000, 150000);
        
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escriba la cantidad de eventos...");
        int cantidad = teclado.nextInt();
        
        Evento[] listadoEventos = new Evento[cantidad];
        
        for (int i = 0; i < cantidad; i++) {
            
            System.out.println("\nEvento# "+(i+1)+"\n");
            
            
            Cliente miCliente=null;
            
            System.out.print("Desea utilizar un código de cliente? (1.Si/2.No)...");
            int opcion = teclado.nextInt();
            
            if(opcion==1){
                do{
                    System.out.print("Escriba el código del cliente...");
                    int codigo = teclado.nextInt();
                    
                    for(ClientePremium elemento : listaClientes){
                        
                        if(elemento.getCodigo()==codigo){
                            miCliente=elemento;
                            break;
                        }
                    }
                    if(miCliente!=null){
                        break;
                    }
                    System.out.println("Cliente no encontrado");
                    
                }while(true);
            }else{
            
                miCliente = new Cliente();
                
                teclado.nextLine();
             
                System.out.print("Escriba el nombre...");
                String nombre = teclado.nextLine();
                miCliente.setNombre(nombre);

                System.out.print("Escriba el documento...");
                String documento = teclado.next();
                miCliente.setDocumento(documento);
            }
            
            System.out.println(miCliente);
            
            System.out.print("Seleccione el tipo de salón (1. Normal / 2. Grande)...");
            int salon = teclado.nextInt();
            
            System.out.print("Desea meseros extra? (1. Si / 2. No)...");
            int mExtra = teclado.nextInt();
            
            int meseros=0;
            if(mExtra==1){
                System.out.print("Cuantos meseros necesita?...");
                meseros = teclado.nextInt();
            }
            
            System.out.print("Desea inlcuir el servicio de comida? (1. Si / 2. No)...");
            int comida = teclado.nextInt();
            
            int platos=0;
            if(comida==1){
                System.out.print("Cuantos platos necesita?...");
                platos = teclado.nextInt();
            }
            
            System.out.print("Cuantas botellas de vino necesita?...");
            int botellas = teclado.nextInt();
            
            for (int j = 0; j < listaServicios.length; j++) {
                Servicio miServicio = listaServicios[j];
                System.out.println((j+1)+"."+miServicio.getDescripcion(salon));
            }
            System.out.print("Seleccione el servicio...");
            int seleccionado = teclado.nextInt();
            
            Servicio miServicio = listaServicios[seleccionado-1];
            
            Evento miEvento = new Evento(miCliente, salon, meseros, platos, 
                    botellas, miServicio);
            
            listadoEventos[i] = miEvento;
        }
        
        String mensaje = String.format("\n%30s %10s %10S %10S %10S %25s %15s %20s \n", 
                "CLIENTE", "SALON", "MESEROS", "PLATOS", "BOTELLAS", "SERVICIO",
                "DESCUENTO", "TOTAL");
        
        double total=0;
        for (Evento miEvento : listadoEventos) {
            
            
            mensaje += String.format("%30s %10s %10d %10d %10d %25s %15.1f %20.1f \n",
                miEvento.getCliente().getDescripcion(), miEvento.getNombreSalon(), 
                miEvento.getCantidadMeseros(), miEvento.getPlatos(), miEvento.getBotellas(), 
                miEvento.getServicio().getDescripcion(miEvento.getSalon()),
                miEvento.getDescuentoTotal(), miEvento.getTotal());
            
            total += miEvento.getTotal();
            
        }
        
        mensaje += String.format("\n%30s %20.1f", "VALOR TOTAL EVENTOS", total);
        System.out.println(mensaje);
        
        
    }
    
}
