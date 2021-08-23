package registroclientes;


public class ClientePremium extends Cliente{
    
    private String documento;
    private String username;
    private String codigo;
    private int tipo;
    
    public void setDocumento(String documento){
        this.documento = documento;        
    }    
    public void setUsername(String Username){
        this.username = Username;   
            }
    public void setCodigo(String codigo){
        this.codigo = codigo;   
            }  
    public void settTipo(int tipo){
        this.tipo = tipo;   
            } 
    
    public ClientePremium(String nombre, String Username,
                    String codigo, int tipo){
        
            super.setNombre(nombre); 
            this.username = Username;
            this.tipo = tipo;
            this.codigo = codigo;            
            }
    public String getCodigo(){
        return codigo;
    }                   
    @Override
    public String getDescripcion(){
        return getNombre() + " ("+nombreTipo()+")";
    } 
    public String nombreTipo(){
        String nombreTipo = "NULL";
        if (tipo == 1) {
            nombreTipo = "GOLD";
        } else {
            nombreTipo = "PLATINO";
    }        
        return nombreTipo;
    } 
    
    @Override
     public double descuentoTipo(){
        double descuentoTipo = 0.5;
        if (tipo == 1) {
            descuentoTipo = 0.05;
        } else {
            descuentoTipo = 0.1;
    }        
        return descuentoTipo;
    } 
    
    
    
}