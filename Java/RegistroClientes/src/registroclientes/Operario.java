
package registroclientes;

/**
 *
 * @author stiven
 */
public class Operario{
    
    private String username;
    private String password;
    private String nombre;
    
    
    public Operario(String nombre,  String username, String password){        
        this.nombre = nombre;
        this.username=username;
        this.password=password;
    }
        
    public boolean isValido(String username, String password){
        boolean valido=false;
        
        if(this.username.equals(username)&&this.password.equals(password)){
            valido=true;
        }
        
        return valido;
    }
        
}
