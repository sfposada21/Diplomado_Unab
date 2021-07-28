/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventossociales;

/**
 *
 * @author sebca
 */
public class Cliente extends Persona implements Imprimible, Descriptible{
    
    
    @Override
    public String getImpresion(){
        return String.format("%20s %20s", nombre, documento);
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola soy un cliente");
    }
        
    @Override
    public String toString(){
        return "Nombre: "+nombre+", Documento: "+documento;
    }    
    
    @Override
    public String getDescripcion(){
        return nombre+" ("+documento+")";
    }
    
    
    public Cliente(){
        
    }
    
    public Cliente(String nombre, String documento){
        this.nombre=nombre;
        this.documento=documento;
    }
    
}
