/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroclientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sposada
 */
public class CompraDAO {
    
    private Connection conexion;     
    
    public CompraDAO(){        
        baseDatos mibasedatos = new baseDatos();
        conexion = mibasedatos.getConexion();       
    }
    
    
public ArrayList<Compra> getTodos(){
        
        ArrayList<Compra> Listado = new ArrayList<>();     
        String sql = "select * from compras";              
         
        try {       
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultados =  consulta.executeQuery();         
            
            while (resultados.next()){                                
                int cantidad = resultados.getInt("cantidad");
                int tipoEnvio = resultados.getInt("tipo_Envio");        
                int formaEnvio = resultados.getInt("tipo_Envio");    
                int cliente = resultados.getInt("cliente");       
                int producto = resultados.getInt("producto");       
                
                ClienteDAO DAOcliente = new ClienteDAO();
                Cliente miCliente = DAOcliente.getporId(cliente);
                
                ProductoDAO DAOproducto = new ProductoDAO();
                Producto miproducto = DAOproducto.getporId(producto);                
                
                Compra miCompra = new Compra(cantidad, tipoEnvio, formaEnvio, miproducto, miCliente);                
                Listado.add(miCompra);
                
            }
            
            resultados.close();
            
        } catch (Exception e) {
            System.err.println("Error de consulta de los productos");
        }
         return Listado;       
    }

    public boolean insertarCompra(Compra miCompra){
        
        boolean resultado;
        ClienteDAO DAO = new ClienteDAO();
        
        int idcliente = DAO.insertar(miCompra.getCliente());
        
        String sql = "insert into compras(cantidad, tipoEnvio, formaEnvio, cliente, producto)" + 
                "values (?,?,?,?,?) ";
        
        try {
            PreparedStatement consulta = conexion.prepareStatement(sql);
            
            consulta.setInt(1, miCompra.getcantidad());
            consulta.setInt(2, miCompra.gettipoLugar());
            consulta.setInt(3, miCompra.gettipoEnvio());        
            consulta.setInt(4, idcliente);
            consulta.setInt(5, miCompra.getProdu().getId());
               
           resultado = consulta.execute();
            
        } catch (Exception e) {
            resultado = false;
        }
                
        return resultado;
    } 



}