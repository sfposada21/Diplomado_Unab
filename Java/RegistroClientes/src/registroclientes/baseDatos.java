
package registroclientes;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sposada
 */
public class baseDatos {
    
    private String host;
    private int puerto;
    private String nombrebaseDatos;
    private String user;
    private String pass;
    private String url;     
    private Connection conexion;

    public String getHost() {
        return host;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getNombrebaseDatos() {
        return nombrebaseDatos;
    }

    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public Connection getConexion() {
        return conexion;
    }
    
    
    
    public baseDatos (){
        this.host = "localhost";
        this.puerto = 3306;
        this.nombrebaseDatos = "reto5";
        this.user = "root";
        this.pass = "root";
        this.url = "jdbc:mysql://"+host+":"+puerto+"/"+nombrebaseDatos;         
        
        try {
            conexion = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.err.println("Error "+e.getMessage());
            conexion = null;
        }
                
        }
    
    
    
}
