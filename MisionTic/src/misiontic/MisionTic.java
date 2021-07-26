/**
 * @author sposada
 */
package misiontic;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MisionTic {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombre;
        int numero;
        double decimal;
        char caracter;
        boolean boleana;        
        
        Scanner teclado = new Scanner(System.in) ; 
        
        System.out.println("Escribe su nombre ");
        nombre = teclado.nextLine();
        System.out.println("Escribe el entero con java ");
        numero = teclado.nextInt();        
        System.out.println("Escribe el decimal con java ");
        decimal = teclado.nextDouble();
        System.out.println("Escribe el boleano con java ");
        boleana = teclado.nextBoolean();
        
        
        
        System.out.println("Comenzamos con java "+nombre);
        
        JOptionPane.showMessageDialog(null, "Imprimir en una ventana con JOptionPane");
        
        
    }
    
}
