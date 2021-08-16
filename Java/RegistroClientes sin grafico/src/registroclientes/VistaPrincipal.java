/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroclientes;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stiven
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private Producto[] listaProductos;
    private int salon;
    private ClientePremium[] listaClientes;
    private Cliente miCliente;
    private String mensaje;
    private double total;
    private DefaultTableModel miModelo;
    private ArrayList<Compra> listadoCompras;

    /**
     * Creates new form VistaPrincipal
     */
     public VistaPrincipal() {
        initComponents();
        
        listadoCompras = new ArrayList<>();
        
           listaProductos[0]= new Producto("Xiaomi Poco X3", 750000);               
           listaProductos[1] = new Producto("Motorola One Fusion", 560000);           
           listaProductos[2] = new Producto("Samsung Galaxy A21s",700000);  
           listaProductos[3] = new Producto("Portatil Asus M413da",2200000); 

        listaClientes = new ClientePremium[4];
         listaClientes[0]= new ClientePremium("Juan","juan65", "C0001", 1);               
        listaClientes[1] = new ClientePremium("Maria","maria58", "C0002", 2);             
        listaClientes[2] = new ClientePremium("Jose","jose36", "C0003", 2);   
        listaClientes[3] = new ClientePremium("Diana","diana21", "C0004", 1); 

        salon = 0;

        cargarServicios();
        cargarEventos();
        
        mensaje = String.format("\n%30s %20s %10S %10S %20S %25s \n", 
                "CLIENTE", "PRODUCTO", "CANTIDAD", "ENVIO", 
            "DESCUENTO", "TOTAL");
        
        miCliente=null;
        
        total=0;

    }

    private void cargarServicios() {

        jCBServicios.removeAllItems();

        if (salon == 0) {
            jCBServicios.addItem("Debe seleccionar un salón");
        } else {

            jCBServicios.addItem("Seleccione un servicio");

            for (Producto miServicio : listaProductos) {
                jCBServicios.addItem(miServicio.getDescripcion(salon));
            }
        }

    }
    
    private void cargarEventos(){
        
        String[] columnas = {"CLIENTE", "PRODUCTO", "CANTIDAD", "ENVIO", 
            "DESCUENTO", "TOTAL"};
        
        miModelo = new DefaultTableModel(columnas, 0);
        
        double total = 0;
        
        for (Compra miEvento : listadoCompras) {
            miModelo.addRow(miEvento.getFila());
            total += miEvento.getTotal();
        }
        
        jLbTotal.setText("$"+String.format("%.1f", total));
        jTbDatos.setModel(miModelo);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGSalon = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jTFNombreCliente = new javax.swing.JTextField();
        jSpBotellas = new javax.swing.JSpinner();
        jCBServicios = new javax.swing.JComboBox<>();
        jBtAgregarEvento = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBtValidarCodigo = new javax.swing.JButton();
        jRBNormal = new javax.swing.JRadioButton();
        jRBExpress = new javax.swing.JRadioButton();
        jTFDocumentoCliente = new javax.swing.JTextField();
        jLbTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbDatos = new javax.swing.JTable();
        jBtEliminarEvento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Compras");

        jCBServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBtAgregarEvento.setText("Agregar Compra");
        jBtAgregarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAgregarEventoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Listado de Enventos");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre Cliente");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Código Premium");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Botellas");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Servicio");

        jBtValidarCodigo.setText("Validar");
        jBtValidarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtValidarCodigoActionPerformed(evt);
            }
        });

        bGSalon.add(jRBNormal);
        jRBNormal.setText("Normal");
        jRBNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNormalActionPerformed(evt);
            }
        });

        bGSalon.add(jRBExpress);
        jRBExpress.setText("Express");
        jRBExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBExpressActionPerformed(evt);
            }
        });

        jLbTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLbTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLbTotal.setText("0.0");

        jTbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTbDatos);

        jBtEliminarEvento.setText("Eliminar");
        jBtEliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEliminarEventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTFDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtValidarCodigo))
                            .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jCBServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jSpBotellas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtEliminarEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtAgregarEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(207, 207, 207))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBNormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBExpress)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBtValidarCodigo)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpBotellas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRBNormal)
                            .addComponent(jRBExpress)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jBtAgregarEvento)
                        .addGap(18, 18, 18)
                        .addComponent(jBtEliminarEvento)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbTotal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAgregarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAgregarEventoActionPerformed
        // TODO add your handling code here:

        
        int cantidad = (int) jSpBotellas.getValue();
              
        
        if(miCliente==null){
            
            String nombre = jTFNombreCliente.getText();
            String documento = jTFDocumentoCliente.getText();
            
            miCliente = new Cliente(nombre, documento);
        }
        

        int opc = jCBServicios.getSelectedIndex();
        
        boolean servicioValido=false;
        Producto miServicio=null;
        if (opc != 0) {
            
            servicioValido=true;
            miServicio = listaProductos[opc - 1];

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un servicio");
        }
        
        if(servicioValido){
            Compra miEvento = new Compra(miCliente, salon, cantidad, miServicio);
            
            listadoCompras.add(miEvento);
            
            cargarEventos();
            
        }
        
        
        
    }//GEN-LAST:event_jBtAgregarEventoActionPerformed

    private void jRBNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNormalActionPerformed
        // TODO add your handling code here:
        salon = 1;

        cargarServicios();

    }//GEN-LAST:event_jRBNormalActionPerformed

    private void jRBExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBExpressActionPerformed
        // TODO add your handling code here:
        salon = 2;

        cargarServicios();
    }//GEN-LAST:event_jRBExpressActionPerformed

    private void jBtValidarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtValidarCodigoActionPerformed
        // TODO add your handling code here:

        int codigo = Integer.parseInt(jTFCodigo.getText());
        
        miCliente=null;
        
        for (ClientePremium elemento : listaClientes) {

            if (elemento.getCodigo() == codigo) {                
                miCliente = elemento;
                
                jTFNombreCliente.setText(elemento.getNombre());
                jTFNombreCliente.setEditable(false);
                
                jTFDocumentoCliente.setText(elemento.getDocumento());
                jTFDocumentoCliente.setEditable(false);
                
                break;
            }
        }
        
        if(miCliente==null){
            jTFNombreCliente.setText("");
            jTFNombreCliente.setEditable(true);
            
            jTFDocumentoCliente.setText("");
            jTFDocumentoCliente.setEditable(true);
            
            JOptionPane.showMessageDialog(this, "Código inválido");
        }


    }//GEN-LAST:event_jBtValidarCodigoActionPerformed

    private void jBtEliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEliminarEventoActionPerformed
        // TODO add your handling code here:
        
        int seleccion = jTbDatos.getSelectedRow();
        
        if(seleccion!=-1){
            
            listaProductos.remove(seleccion);
            cargarEventos();
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }
        
    }//GEN-LAST:event_jBtEliminarEventoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGSalon;
    private javax.swing.JButton jBtAgregarEvento;
    private javax.swing.JButton jBtEliminarEvento;
    private javax.swing.JButton jBtValidarCodigo;
    private javax.swing.JComboBox<String> jCBServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLbTotal;
    private javax.swing.JRadioButton jRBExpress;
    private javax.swing.JRadioButton jRBNormal;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpBotellas;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFDocumentoCliente;
    private javax.swing.JTextField jTFNombreCliente;
    private javax.swing.JTable jTbDatos;
    // End of variables declaration//GEN-END:variables
}