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
public abstract class Persona {
    
    protected String nombre;
    protected String documento;
    
    public abstract void saludar();
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDocumento(){
        return documento;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setDocumento(String documento){
        this.documento=documento;
    }
    
    public String getDescripcion(){
        return nombre;
    }
    
    
    
}
