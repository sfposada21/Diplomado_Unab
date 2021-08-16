/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroclientes;

/**
 *
 * @author sebca
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
