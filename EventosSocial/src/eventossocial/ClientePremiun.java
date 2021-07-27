/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventossocial;

/**
 *
 * @author sposada
 */
public class ClientePremiun extends Cliente{
    
    
    private String username;
    private String password;
    private int codigo;
    
    
    public void setUsername(String Username){
        this.username = Username;   
            }
     public void setPassword(String password){
        this.password = password;   
            }
    public void setCodigo(int codigo){
        this.codigo = codigo;   
            }  
    
    public ClientePremiun(String nombre, String documento,String Username,
                    String password, int codigo){
        
            super.setNombre(nombre); 
            super.setDocumento(documento);
            this.username = Username;
            this.password = password;
            this.codigo = codigo;            
            }
    public int getCodigo(){
        return codigo;
    }       
            
    public String getUsername(){
        return username;
    } 
    public String getPassword(){
        return password;
    } 
    
    
    
}
