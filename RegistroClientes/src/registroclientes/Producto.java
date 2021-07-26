/**
 *
 * @author sposada
 */
public class Producto {
           
    String nombre;
    double precio;               
    
    public String getDescripcion(){        
        return nombre+ " - $ "+ precio;
    }
    
    public Producto(){
        nombre = "Sin definir";
        precio = 0;   
    }    
    
    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;     
    }    
    
}
