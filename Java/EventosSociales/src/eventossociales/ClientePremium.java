/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventossociales;

/**
 *
 * @author sebca
 */
public class ClientePremium extends Cliente{
    
    private String username;
    private String password;
    private int codigo;
    
    public ClientePremium(String nombre, String documento, String username, 
            String password, int codigo){        
        
        super(nombre, documento);
        
        this.username = username;
        this.password= password;
        this.codigo = codigo;
        
    }    
    
    public int getCodigo(){
        return codigo;
    }
    
    @Override
    public String getDescripcion(){
        return getNombre()+"("+username+")";
    }
    
}
