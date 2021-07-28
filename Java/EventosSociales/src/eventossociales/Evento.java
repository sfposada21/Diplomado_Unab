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
public class Evento implements Imprimible, Descriptible{
    
    private Cliente cliente;
    private int salon;
    private int meseros;
    private int platos;
    private int botellas;
    private Servicio servicio;
    
    public Evento(){
        meseros=0;
        platos=0;
    }
    
    public Evento(Cliente cliente, int salon, int meseros,int platos,int botellas
            ,Servicio servicio){
        this.cliente=cliente;
        this.salon=salon;
        this.meseros=meseros;
        this.platos=platos;
        this.botellas=botellas;
        this.servicio=servicio;
    }
    
    @Override
    public String getDescripcion(){
        return cliente.getDescripcion() +" "+ getNombreSalon() +" "+ getCantidadMeseros()+
               " "+ platos+" "+ botellas +" "+ servicio.getDescripcion(salon) +
                " "+ getDescuentoTotal() +" "+ getTotal();
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public int getSalon(){
        return salon;
    }
    
    public int getPlatos(){
        return platos;
    }
    
    public int getBotellas(){
        return botellas;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    
    public String getNombreSalon(){
        String nombre="";
        if(salon==1){
            nombre="normal";
        }else if(salon==2){
            nombre="grande";
        }
        return nombre;
    }
    
    public int getCantidadMeseros(){
        int cantidad=0;
        if(salon==1){
            cantidad=2+meseros;
        }else if(salon==2){
            cantidad=4+meseros;
        }
        return cantidad;
    }
    
    public double getValorBotellas(){
        double valor;
        if (botellas>3){
            valor = botellas*100000 - (botellas*100000)*0.1;
        }else{
            valor = botellas*100000;
        }
        return valor;
    }
    
    public double getValor(){
        double valor=0;
        if(salon==1){
            valor = 1000000+(meseros*150000)+(platos*30000)+getValorBotellas()
                    +servicio.getPrecio(salon);
        }else if(salon==2){
            valor = 2000000+(meseros*100000)+(platos*20000)+getValorBotellas()
                    +servicio.getPrecio(salon);
        }
        return valor;
    }
    
    public double getDescuentoSalon(){
        double valor=0;
        if(salon==1){
            if(getValor()>3000000){
                valor += getValor()*0.1;
            }
        }else if(salon==2){
           if(getValor()>5000000){
                valor += getValor()*0.1;
            }
        }
        return valor;
    }
    
    public double getDescuentoBotellas(){
        double valor=0;
        if (botellas>3){
            valor = (botellas*100000)*0.1;
        }
        return valor;
    }
    
    public double getDescuentoTotal(){
        
        double descuento=0;
        
        descuento = getDescuentoSalon()+getDescuentoBotellas();
        
        if(cliente instanceof ClientePremium){
            
            ClientePremium temp = (ClientePremium) cliente;
            
            descuento += getDescuentoPremiun();
            
        }
        
        return descuento;
    }
    
    public double getDescuentoPremiun(){
        return (getValor()-getDescuentoSalon())*0.05;
    }
    
    public double getTotal(){
        
        double total=0;
        
        total = getValor()-getDescuentoSalon();
        
        if(cliente instanceof ClientePremium){
            total -= getDescuentoPremiun();
        }
        
        return total;
        
    }
    
    @Override
    public String getImpresion(){
        return String.format("%30s %10s %10d %10d %10d %25s %15.1f %20.1f \n", 
                cliente.getDescripcion(), getNombreSalon(), getCantidadMeseros(), 
                platos, botellas, servicio.getDescripcion(salon),
                getDescuentoTotal(), getTotal());
    }
    
    
    
}
