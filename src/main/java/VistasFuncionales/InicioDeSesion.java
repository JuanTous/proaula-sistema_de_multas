/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasFuncionales;

import CRUD_entidadesPrincipales.vistaInicial;
import Modelo.AgenteDeTransito;
import Modelo.Dueño;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Tous
 */
public class InicioDeSesion extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public InicioDeSesion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        rootPane.setDefaultButton(ingresar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ingresar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        Usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        mostrarContraseña = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        bntConsultarEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(234, 255, 234));

        jLabel1.setText("USUARIO");

        jLabel2.setText("CONTRASEÑA");

        ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/entrar.png"))); // NOI18N
        ingresar.setText("INGRESAR");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error.png"))); // NOI18N
        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        mostrarContraseña.setBackground(new java.awt.Color(234, 255, 234));
        mostrarContraseña.setText("Mostrar contraseña");
        mostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarContraseñaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/policia.png"))); // NOI18N
        jLabel3.setText("LOGIN");

        bntConsultarEstado.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        bntConsultarEstado.setForeground(new java.awt.Color(102, 102, 102));
        bntConsultarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregunta.png"))); // NOI18N
        bntConsultarEstado.setText("Si desea consultar su estado en el sistema, presione aquí.");
        bntConsultarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntConsultarEstadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ingresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                    .addComponent(Usuario)
                                    .addComponent(contraseña)))
                            .addComponent(mostrarContraseña)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bntConsultarEstado)))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mostrarContraseña)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bntConsultarEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        int num = JOptionPane.showConfirmDialog(null, "¿DESEA SALIR DE LA APLICACIÓN?",
                "CERRAR", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        AgenteDeTransito agente = vistaInicial.ctrlagente.consultarUsuario(Usuario.getText().trim(), contraseña.getText().trim());
        if (agente != null) {
            vistaInfraccion constructor = new vistaInfraccion();
            vistaInfraccion.identificacionUsuario.setText("IDENTIFICACIÓN: " + agente.getNombre().toUpperCase() + " " + agente.getApellido().toUpperCase() + " - " + agente.getIdentificacion());
            vistaInfraccion.agenteDeTransito = agente;
            constructor.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "INICIO DE SESIÓN", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ingresarActionPerformed

    private void mostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarContraseñaActionPerformed
        if (mostrarContraseña.isSelected()) {
            contraseña.setEchoChar((char) 0);
        } else {
            contraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_mostrarContraseñaActionPerformed

    private void bntConsultarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntConsultarEstadoMouseClicked
        boolean usuarioEncontrado = false;
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese su identificación", "LOGIN", JOptionPane.PLAIN_MESSAGE);

        for (Dueño d : vistaInicial.ctrldueño.cargarDueños()) {
            if (d.getIdentificacion().equals(identificacion.trim())) {
                usuarioEncontrado = true;
                JOptionPane.showMessageDialog(null, "CORDIAL BIENVENIDA " + d.getNombre().toUpperCase() + " " + d.getApellido().toUpperCase(), "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                vistaCivil constructor = new vistaCivil();
                constructor.identificacionUsuario.setText("IDENTIFICACIÓN: " + d.getNombre().toUpperCase() + " " + d.getApellido().toUpperCase() + " - " + d.getIdentificacion());
                vistaCivil.dueño = d;
                constructor.setVisible(true);
                this.dispose();
            }
        }

        if (usuarioEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No se encontró al usuario.");
        }


    }//GEN-LAST:event_bntConsultarEstadoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioDeSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel bntConsultarEstado;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox mostrarContraseña;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}