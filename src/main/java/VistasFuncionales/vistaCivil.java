/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasFuncionales;

import Controlador.ControlExpediente;
import Controlador.controlCivil;
import Modelo.Dueño;
import Modelo.Sancion;
import static VistasFuncionales.vistaInfraccion.formatoFecha;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Tous
 */
public class vistaCivil extends javax.swing.JFrame {

    /**
     * Creates new form vistaCivil
     */
    public vistaCivil() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        creartabla();
        jButtonActualizar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelOperaciones = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        consultarInfracciones = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        identificacionUsuario = new javax.swing.JLabel();
        alegar = new javax.swing.JButton();
        pagar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDM");

        panelOperaciones.setBackground(new java.awt.Color(102, 0, 51));
        panelOperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CONSULTAR INFRACCIÓN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(190, 190, 190))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        consultarInfracciones.setBackground(new java.awt.Color(184, 185, 194));
        consultarInfracciones.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        consultarInfracciones.setText("CONSULTAR PENDIENTES");
        consultarInfracciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarInfraccionesActionPerformed(evt);
            }
        });

        cerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        cerrarSesion.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        cerrarSesion.setText("Cerrar sesión");
        cerrarSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cerrarSesion.setBorderPainted(false);
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consultarInfracciones)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarInfracciones, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cerrarSesion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MIS INFRACCIONES");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jScrollPane1.setBackground(new java.awt.Color(14, 15, 34));

        jTable.setBackground(new java.awt.Color(184, 185, 194));
        jTable.setModel(tabla);
        jTable.setSelectionBackground(new java.awt.Color(55, 175, 177));
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        identificacionUsuario.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        identificacionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        identificacionUsuario.setText("IDENTIFICACION");
        identificacionUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(identificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(identificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        alegar.setBackground(new java.awt.Color(184, 185, 194));
        alegar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        alegar.setText("PRESENTAR UNA ALEGACIÓN");
        alegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alegarActionPerformed(evt);
            }
        });

        pagar.setBackground(new java.awt.Color(184, 185, 194));
        pagar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        pagar.setText("CANCELAR PENDIENTES");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        jButtonActualizar.setBackground(new java.awt.Color(184, 185, 194));
        jButtonActualizar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jButtonActualizar.setText("REFRESCAR TABLA");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOperacionesLayout = new javax.swing.GroupLayout(panelOperaciones);
        panelOperaciones.setLayout(panelOperacionesLayout);
        panelOperacionesLayout.setHorizontalGroup(
            panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelOperacionesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelOperacionesLayout.createSequentialGroup()
                        .addComponent(jButtonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alegar)
                        .addGap(18, 18, 18)
                        .addComponent(pagar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelOperacionesLayout.setVerticalGroup(
            panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperacionesLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alegar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarInfraccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarInfraccionesActionPerformed
        jButtonActualizar.setVisible(false);
        cargarTabla();
    }//GEN-LAST:event_consultarInfraccionesActionPerformed

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        int num = JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA CERRAR SESIÓN?",
                "CERRAR SESIÓN", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            InicioDeSesion constructor = new InicioDeSesion();
            constructor.setVisible(true);
            sanciones.clear();
            dueño = null;
            sancionSeleccionada = null;
            seleccion = false;
            this.dispose();
        }
    }//GEN-LAST:event_cerrarSesionActionPerformed

    private void alegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alegarActionPerformed
        jButtonActualizar.setVisible(false);
        if (seleccion != true) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado alguna infracción.");
        } else {
            vistaAlegacion constructor = new vistaAlegacion();
            constructor.identificacionUsuario.setText("IDENTIFICACIÓN: " + dueño.getNombre().toUpperCase() + " " + dueño.getApellido().toUpperCase() + " - " + dueño.getIdentificacion());
            constructor.jlabelagente.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getAgenteDeTransito().getNombre().toUpperCase() + " " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getAgenteDeTransito().getApellido().toUpperCase());
            constructor.jlabelpersona.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getResponsable().getConductor().getNombre().toUpperCase() + " " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getResponsable().getConductor().getApellido().toUpperCase());
            constructor.jlabelfecha.setText(vistaInfraccion.formatoFecha.format(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getFecha().getTime()));
            constructor.jlabelhora.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getHora().toString());
            constructor.jlabellugar.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getLugar().getDepartamento().toUpperCase() + " - " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getLugar().getMunicipio().toUpperCase() + " - BARRIO " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getLugar().getBarrio().toUpperCase());
            vistaAlegacion.sancion = sancionSeleccionada;
            constructor.setVisible(true);
        }
    }//GEN-LAST:event_alegarActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        seleccion = true;
        int cont = jTable.rowAtPoint(evt.getPoint());
        sancionSeleccionada = ctrlCivil.getSanciones().get(cont);
    }//GEN-LAST:event_jTableMouseClicked

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        jButtonActualizar.setVisible(false);
        if (seleccion != true) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado alguna infracción.");
        } else {
            vistaCancelar constructor = new vistaCancelar();
            constructor.identificacionUsuario.setText("IDENTIFICACIÓN: " + dueño.getNombre().toUpperCase() + " " + dueño.getApellido().toUpperCase() + " - " + dueño.getIdentificacion());
            constructor.jlabelagente.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getAgenteDeTransito().getNombre().toUpperCase() + " " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getAgenteDeTransito().getApellido().toUpperCase());
            constructor.jlabelpersona.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getResponsable().getConductor().getNombre().toUpperCase() + " " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getResponsable().getConductor().getApellido().toUpperCase());
            constructor.jlabelfecha.setText(vistaInfraccion.formatoFecha.format(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getFecha().getTime()));
            constructor.jlabelhora.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getHora().toString());
            constructor.jlabellugar.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getLugar().getDepartamento().toUpperCase() + " - " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getLugar().getMunicipio().toUpperCase() + " - BARRIO " + sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getLugar().getBarrio().toUpperCase());
            constructor.multa.setText("$ " + sancionSeleccionada.getValorMulta());
            constructor.fechaVencimiento.setText(vistaInfraccion.formatoFecha.format(sancionSeleccionada.getFechaDeVencimiento().getTime()));
            constructor.tipoInfraccion.setText(sancionSeleccionada.getDetalleDeInfraccion().getInfraccion().getTipoDeInfraccion().getCategoriaDeLaInfraccion());
            vistaCancelar.sancion = sancionSeleccionada;
            constructor.setVisible(true);
        }
    }//GEN-LAST:event_pagarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        jButtonActualizar.setVisible(false);
        cargarTabla();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    DefaultTableModel tabla = new DefaultTableModel();

    public void creartabla() {
        tabla.addColumn("AGENTE DE TRANSITO");
        tabla.addColumn("RESPONSABLE");
        tabla.addColumn("LUGAR DE LA INFRACCION");
        tabla.addColumn("FECHA DE LA INFRACCION");
        tabla.addColumn("HORA DE LA INFRACCION");
    }

    public void cargarTabla() {

        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
        }

        tabla.setNumRows(0);
        for (Sancion s : ctrlCivil.consultarSanciones(dueño.getIdentificacion())) {
            String[] fila = {s.getDetalleDeInfraccion().getInfraccion().getAgenteDeTransito().getNombre().toUpperCase() + " "
                + s.getDetalleDeInfraccion().getInfraccion().getAgenteDeTransito().getApellido().toUpperCase(),
                s.getDetalleDeInfraccion().getInfraccion().getResponsable().getConductor().getNombre().toUpperCase() + " "
                + s.getDetalleDeInfraccion().getInfraccion().getResponsable().getConductor().getApellido().toUpperCase(),
                s.getDetalleDeInfraccion().getInfraccion().getLugar().getDepartamento().toUpperCase() + " - "
                + s.getDetalleDeInfraccion().getInfraccion().getLugar().getMunicipio().toUpperCase(),
                formatoFecha.format(s.getFechaDeInfraccion().getTime()).toUpperCase(), s.getDetalleDeInfraccion().getInfraccion().getHora().toString()};
            tabla.addRow(fila);
            sanciones.add(s);
        }
        if (sanciones.size() != 0) {
                    JOptionPane.showMessageDialog(null, "Infracciones cometidas: " + sanciones.size(), "Consultar pendientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    protected static Dueño dueño;
    public static List<Sancion> sanciones = new LinkedList();
    public static ControlExpediente ctrlExpediente = new ControlExpediente();
    public static controlCivil ctrlCivil = new controlCivil();
    private static Sancion sancionSeleccionada = null;
    public static boolean seleccion = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaCivil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaCivil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaCivil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaCivil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaCivil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alegar;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JButton consultarInfracciones;
    public static javax.swing.JLabel identificacionUsuario;
    public static javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable;
    private javax.swing.JButton pagar;
    public java.awt.Panel panelOperaciones;
    // End of variables declaration//GEN-END:variables
}
