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
public class Servicio implements Imprimible{
    
    /*
    - private - solo puede ser accedido y modificado en la misma clase
    # protected - puede ser accedido y modificado en la misma clase y las clases que hereden de ella
    * vacio - puede ser accedido y modificado en la misma clase y en las clases que estén en el mismo páquete
    + public - puede ser accedido y modificado desde cualquier lado
    
    */
    
    private String nombre;
    private double precioNormal;
    private double precioGrande;
    
    
    @Override
    public String getImpresion(){
        return String.format("%20s %20.1f %20.1f", nombre, precioNormal, precioGrande);
    }
    
    public double getPrecio(int salon){
        
        double precio=0;
        if(salon==1){
            precio = precioNormal;
        }else if (salon==2){
            precio = precioGrande;
        }
        return precio;        
        
    }
    
    public String getDescripcion(int salon){
        
        return nombre+" - $"+getPrecio(salon);
    }
    
    public Servicio(){
        nombre = "Sin definir";
        precioNormal=0;
        precioGrande=0;
    }
    
    public Servicio(String nombre, double precioNormal, double precioGrande){
        
        this.nombre=nombre;
        this.precioNormal=precioNormal;
        this.precioGrande=precioGrande;
    }
    
}
