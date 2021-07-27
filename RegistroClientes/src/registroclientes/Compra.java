/**
 *
 * @author sposada
 */
public class Compra {
      
    Cliente cliente;    
    Producto producto;  
    int cantidad;
    int tipoLugar;
    int tipoEnvio;
 
    public Compra(){
     cantidad = 0;
     tipoLugar = 0;
     tipoEnvio = 0;
    }   
    
    public String getNombreTipoLugar(){  
        String tipo = "";
        if (tipoLugar == 1) {
            tipo = "Local";
        } 
        if (tipoLugar == 2) {
            tipo = "Nacional";
        } 
        if (tipoLugar == 3) {
            tipo = "Internacional";
        } 
    return tipo;
    }
    
    public String getNombreTipoEnvio(){    
        String forma = "";
        if (tipoEnvio == 1) {
            forma = "Express";
        } 
        if (tipoEnvio == 2) {
            forma = "Normal";
        } 
        
    return forma;
    }
    
    public String getNombreEnvio() {    
    return getNombreTipoLugar() + " - " + getNombreTipoEnvio();
    }
    
    public double getSubTotal(){    
        
        double subtotal = producto.getPrecio() * cantidad;
        
    return subtotal;
    }
    
    
    public double getValorEnvio() {    
        int rango1 = 1000000;
        int rango2 = 1500000;
        int rango3 = 2000000;
        int tipo = tipoLugar;
        int forma = tipoEnvio;
        double costeEnvio = 0;
        double descuento = 0;        
        double total = getSubTotal();
                
                //FORMA1
            if (forma == 1 && tipo == 1){
                costeEnvio += 10000;                
                if (total >= rango1){
                    descuento += 5000;
                            }}            
            if (forma == 1 && tipo == 2){
               costeEnvio += 20000;                
                if (total >= rango2){
                    descuento += 10000;
                            }}            
            if (forma == 1 && tipo == 3){
               costeEnvio += 40000;                
                if (total >= rango3){
                    descuento += 20000; 
                            }}
            
                    // FORMA NORMAL 2           
            if ( forma == 2 && tipo == 1){
                costeEnvio += 5000;                
                if (total >= rango1){
                    descuento += 5000;  
                            }}            
            if ( forma == 2 && tipo == 2){
               costeEnvio += 10000;                
                if (total >= rango2){
                    descuento += 10000;  
                            }}            
            if ( forma == 2 && tipo == 3){
               costeEnvio += 20000;                
                if (total >= rango3){
                    descuento += 20000;
                            }}                            
        return costeEnvio;
    }
    
    
    public double getDescuento2() {    
        int rango1 = 1000000;
        int rango2 = 1500000;
        int rango3 = 2000000;
        int tipo = tipoLugar;
        int forma = tipoEnvio;
        double costeEnvio = 0;
        double descuento = 0;        
        double total = getSubTotal();
                
                //FORMA1
            if (forma == 1 && tipo == 1){     
                if (total >= rango1){
                    descuento += 5000;
                            }}            
            if (forma == 1 && tipo == 2){      
                if (total >= rango2){
                    descuento += 10000;
                            }}            
            if (forma == 1 && tipo == 3){    
                if (total >= rango3){
                    descuento += 20000; 
                            }}
            
                    // FORMA NORMAL 2           
            if ( forma == 2 && tipo == 1){     
                if (total >= rango1){
                    descuento += 5000;  
                            }}            
            if ( forma == 2 && tipo == 2){       
                if (total >= rango2){
                    descuento += 10000;  
                            }}            
            if ( forma == 2 && tipo == 3){        
                if (total >= rango3){
                    descuento += 20000;
                            }}                            
        return descuento;
    }
    
    public double getDescuento1(){    
        double descuento = 0;
        if ( cantidad>=6 ) {
                descuento = getSubTotal()*0.1;
            } 
    return descuento;
    }
    
    public double getDescuento3(){
        double descuento  = 0 ;
        if (cliente instanceof ClientePremium) {
        descuento = (getTotal() * cliente.descuentoTipo());
        }
        return descuento;
    }
    
    public double getTotal(){    
        
        double total = getSubTotal() + getValorEnvio() - getDescuento1() - getDescuento2();                 
        
    return total;
    }
    
     public double getTotalFinal(){    
        
        double total = getTotal() - getDescuento3();                 
        
    return total;
    }
    
        
    
    public String getImpresion(){        
    String mensaje = String.format("%20s %40s %10s %25s %15.1f %20.1f \n", 
                cliente.getDescripcion() , producto.getDescripcion() , cantidad , getNombreEnvio() , getDescuento2()+getDescuento1()+getDescuento3(), getTotalFinal() );
            
           //     cliente, producto.getDescripcion(),cantidad, "getNombreEnvio()" , "getDescuento1()" ,  "getTotal()"  );
        
    return mensaje;
    }
        
        
}
