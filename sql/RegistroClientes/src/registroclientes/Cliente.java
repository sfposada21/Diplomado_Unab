package registroclientes;
/**
 *
 * @author sposada
 */
public class Cliente {
    
    private String nombre;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Cliente( String nombre){
        this.nombre = nombre;        
    }
        
    public String getNombre(){                
        return nombre ;
    }
        
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
          
    public Cliente(){
        
    }
    public String getDescripcion(){
        return nombre;
    } 
      public double descuentoTipo(){
        double descuentoTipo = 0;       
        return descuentoTipo;
    } 
    
    
}
