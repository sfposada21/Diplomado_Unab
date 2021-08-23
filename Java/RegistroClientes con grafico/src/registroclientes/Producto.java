
package registroclientes;

public class Producto {
           
    private String nombre;
    private double precio;               
    
    public String getDescripcion(){        
        return nombre+ " - $ "+ precio;
    }
    public String getnombre(){        
        return nombre;
    }
    public double getPrecio(){        
        return precio;
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
