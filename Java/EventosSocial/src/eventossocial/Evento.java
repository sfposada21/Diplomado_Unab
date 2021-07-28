package eventossocial;
/**
 *
 * @author sposada
 */
public class Evento {
    
    Cliente cliente;
    Servicio servicio;    
    private int salon;
    private int meseros;
    private int platos;
    private int botellas;
 
    public void setSalon( int salon){
        this.salon = salon;
    }
     public void setBotellas(int botellas){
        this.botellas = botellas;
    }
      public void setMeseros(int meseros){
        this.meseros = meseros;
    }
       public void setPlatos(int platos){
        this.platos = platos;
    }
     public int getSalon(){        
        return salon;        
    }
               
    public Cliente getCliente(){        
        return cliente;        
    }
            
    public String getNombreSalon(){
       String nombre ="";
       if (salon == 1) {
            nombre = "normal";
        } else if (salon == 2) {
            nombre = "grande";
        } 
        return nombre;
    }
    
    public int getCantidadMeseros(){
        int cantidad = 0;
       if (salon == 1) {
            cantidad = 2 + meseros;
        } else if (salon == 2) {
            cantidad = 4 + meseros;
        } 
        return cantidad;
    }
    
    public double getValorBotellas(){
        double valor = 0;
        if (botellas > 3) {
            valor = botellas*100000*0.9;
        } else {
            valor = botellas*100000;
        }
        return valor; 
    }
    
     public double getValor(){
        double valor = 0;
        if (salon == 1) {
            valor = 1000000 + (meseros*150000)+(platos*30000)+getValorBotellas()
                    + servicio.getPrecio(salon);
        } else if(salon == 2){
           valor = 2000000 + (meseros*100000)+(platos*20000)+getValorBotellas()
                    + servicio.getPrecio(salon);
        }
        return valor; 
    }
    
     public double getDescuento(){
         double valor = (botellas*100000)- getValorBotellas();
       if (salon == 1 && getValor() > 3000000) {
           valor += getValor()*0.1;
        } else if (salon == 2 && getValor() > 5000000) {
            valor += getValor()*0.1;
        } 
        return valor;
     }
     
     
     public double getDescuentoPremium(){
         double total  = 0 ;
         total = getTotal();
         if (cliente instanceof ClientePremiun) {
         total += getTotal()*0.05;
         }
         return total;
     }
     
     
     public double getTotal(){
         double total = 0;
         total = getValor() - getDescuento()+ (botellas*100000)- getValorBotellas();
         if (cliente instanceof ClientePremiun) {
         total -= getTotal()*0.05;
         }
         
         return total;
     }
     
     
     public String getImpresion(){
            
         return String.format("%30s %10s %10d %10d %10d %25s %20.1f %20.1f \n", cliente.getDescripcion(), getNombreSalon(),
                 getCantidadMeseros(), platos, botellas, servicio.getDescripcion(salon),
                 getDescuento(), getTotal());
     }
     
     public Evento(){
         meseros = 0;
         botellas = 0;
         platos = 0;         
     }
     
     
}
