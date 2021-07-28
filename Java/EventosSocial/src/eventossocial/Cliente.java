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
        
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
       public void setDocumento(String documento){
        this.documento = documento;        
    }
    
    public Cliente(){
        
    }
    
}
