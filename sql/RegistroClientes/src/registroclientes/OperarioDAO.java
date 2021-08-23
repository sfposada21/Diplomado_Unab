package registroclientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sposada
 */
public class OperarioDAO {
        
    private Connection conexion; 
    
    public OperarioDAO(){
        
        baseDatos mibasedatos = new baseDatos();
        conexion = mibasedatos.getConexion();        
    }
    
    public Operario validar(String username, String password){
        
        Operario mioperario;
        
        String sql = "select * from operarios where username=? and password = ?";
         
        try {
            PreparedStatement consulta = conexion.prepareStatement(sql); 
            consulta.setString(1, username);
            consulta.setString(2, password);
            
            ResultSet resultados =  consulta.executeQuery();
            
            
            if(resultados.next()){
                
                String nombre = resultados.getString("nombre");
                
                String user = resultados.getString("username");
                
                String pass = resultados.getString("password");
                
                mioperario = new Operario(nombre, user, pass);
                
            } else
            {
                
                mioperario = null;
            }
            
            
        } catch (Exception e) {
             
            mioperario = null;
                        
        }
        
        return mioperario;
        
    }
    
    
}


