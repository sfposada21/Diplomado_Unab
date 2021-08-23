package registroclientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sposada
 */
public class ProductoDAO {        
    private Connection conexion;     
    
    public ProductoDAO(){        
        baseDatos mibasedatos = new baseDatos();
        conexion = mibasedatos.getConexion();       
    }
    
    public Producto getporId (int id ){        
        Producto miProducto;        
        String sql = "select * from productos where id=?";         
        try {
            PreparedStatement consulta = conexion.prepareStatement(sql);             
            consulta.setInt(1, id);            
            ResultSet resultados =  consulta.executeQuery();                     
            if(resultados.next()){                
                String nombre = resultados.getString("nombre");    
                double precio = resultados.getDouble("precio");  
                miProducto = new Producto(nombre, precio);   
                miProducto.setId(id);
                
            } else  {                
                miProducto = null;
            }                       
        } catch (Exception e) {             
            miProducto = null;                        
        }        
        return miProducto;        
    }
    
    public ArrayList<Producto> getTodos(){
        
        ArrayList<Producto> Listado = new ArrayList<>();        
        
         String sql = "select * from productos";     
         
         
        try {       
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultados =  consulta.executeQuery();         
            
            while (resultados.next()){                
                
                String nombre = resultados.getString("nombre");
                double precio = resultados.getDouble("precio");
                
                Producto miProducto = new Producto(nombre, precio);                
                Listado.add(miProducto);                
            }
            resultados.close();
            
        } catch (Exception e) {
            System.err.println("Error de consulta de los productos");
            Listado = null;            
        }
        
         
         
         
         return Listado;         
    }
    
}
