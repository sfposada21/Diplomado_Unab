package eventossocial;
/**
 *
 * @author sposada
 */
public class Servicio {
    
    private String nombre;
    private double precioNormal;
    private double precioGrande;
    
    public double getPrecio(int salon){
        double precio = 0;
        if (salon == 1) {
            precio = precioNormal;
        } else if (salon == 2) {
            precio = precioGrande;
        } else  {
            precio = 77.0;
        }
        return precio;
    }
    
    public String getDescripcion(int salon){        
        return nombre+ " - $ "+  getPrecio(salon);
    }
    public Servicio(){
        nombre = "Sin definir";
        precioGrande = 0;
        precioNormal = 0;       
    }    
    
    public Servicio(String nombre, double precioNormal, double precioGrande){
        this.nombre = nombre;
        this.precioGrande = precioGrande;
        this.precioNormal = precioNormal;       
    }    
    
    
}
