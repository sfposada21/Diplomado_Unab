
package registroclientes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author stiven
 */
public class VistaLogin extends JFrame {
    
    private Operario[] listaOperarios;

    /**
     * Creates new form VistaLogin
     */
    public VistaLogin() {
        initComponents();
        
        jLabel1.setText("Hola Mundo");
        
        listaOperarios = new Operario[3];
        listaOperarios[0] = new Operario("Juan", "juan", "123");
        listaOperarios[1] = new Operario("Maria", "maria", "456");
        listaOperarios[1] = new Operario("stiven", "stiven", "000");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNombreUsuario = new javax.swing.JTextField();
        jPFPassword = new javax.swing.JPasswordField();
        jBTIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inicio de Sesión");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nombre de Usuario:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contraseña");

        jPFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPFPasswordActionPerformed(evt);
            }
        });

        jBTIngresar.setText("Ingresar");
        jBTIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPFPassword)
                            .addComponent(jTFNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jBTIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jBTIngresar)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPFPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPFPasswordActionPerformed

    private void jBTIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTIngresarActionPerformed
        // TODO add your handling code here:
        
                
        String con = new String(jPFPassword.getPassword());
        String usu = jTFNombreUsuario.getText();
        
        boolean encontrado=false;
        
        OperarioDAO dao = new OperarioDAO();
        
        if ( dao.validar( usu, con) != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido "+usu);  
            
            VistaMenu vista = new VistaMenu();
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            this.dispose();
        } 
        else {            
            JOptionPane.showMessageDialog(this, "datos errados " );  
        }
        
        
        
    }//GEN-LAST:event_jBTIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JTextField jTFNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
