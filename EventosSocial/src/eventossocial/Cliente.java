package eventossocial;

/**
 *
 * @author sposada
 */
public class Cliente {
    
    private String nombre;
    private String documento;
    
    public String getDescripcion(){                
        return nombre + " ("+ documento +") ";
    }
        
    public Cliente(String nombre, String documento){
        this.nombre = nombre;
        this.documento = documento;        
    }
    
    public Cliente(){
        
    }
    
}
