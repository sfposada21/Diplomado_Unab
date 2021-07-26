
package misiontic;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Registar {
    
    public static void main(String[] args) {
        
        String nombre;
        int edad;
        double altura;
        boolean extranjero;
        int op;
        
        String lectura;
        String mensaje;
        
                                      
        lectura = JOptionPane.showInputDialog("escribe su nombre ");                
        nombre = lectura;
        
        lectura = JOptionPane.showInputDialog("escribe su edad ");                
        edad = Integer.parseInt(lectura);
                        
        lectura = JOptionPane.showInputDialog("escribe su Altura (metros) ");                
        altura = Double.parseDouble(lectura);
        
        lectura = JOptionPane.showInputDialog("Extranjero true or false");                
        extranjero = Boolean.parseBoolean(lectura);
        mensaje = "HOLA "+nombre+ " tienes "+edad+" y mides "+altura ;
        
        JOptionPane.showMessageDialog(null,mensaje);
        
    }
    
}
