
package registroclientes;

public class Producto {
          
    private int id; 
    private String nombre;
    private double precio;     
    

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        
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
