
package registroclientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sposada
 */
public class ClienteDAO {
    
    
    private Connection conexion; 
    
    public ClienteDAO(){
        
        baseDatos mibasedatos = new baseDatos();
        conexion = mibasedatos.getConexion();        
    }
    
    public Cliente getporId (int id ){
        
        Cliente micliente;
        
        String sql = "select * from clientes where id=?";
         
        try {
            PreparedStatement consulta = conexion.prepareStatement(sql); 
            
            consulta.setInt(1, id);
            
            ResultSet resultados =  consulta.executeQuery();         
            
            if(resultados.next()){                
                String nombre = resultados.getString("nombre");               
                
                micliente = new Cliente(nombre);       
                micliente.setId(id);
            } else
            {                
                micliente = null;
            }                       
        } catch (Exception e) {             
            micliente = null;                        
        }        
        return micliente;        
    }
    
    public int insertar(Cliente miCliente){
        
        int resultado = -1;
        
        String sql = "insert into clientes (nombre, documento) values (?, ?) ";
        
        try {
            PreparedStatement consulta = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); 
            
            consulta.setString(1, miCliente.getNombre() );  
            consulta.setString(2, "1042542424" );  
            
                        
            ResultSet llaveID = consulta.getGeneratedKeys();
            
            if(llaveID.next()){
                resultado = llaveID.getInt(1);
            }
            
            
        } catch (Exception e) {
            resultado = -1;
        }
        
        return resultado;
        
    }
    
}
