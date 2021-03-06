/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_entidadesPrincipales;

import Modelo.Responsable;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Tous
 */
public class vistaResponsable extends javax.swing.JFrame {

    /**
     * Creates new form vistaResponsable
     */
    public vistaResponsable() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        creartabla();
        cargarTabla();
        Atras.setVisible(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jlabel1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        Añadir = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        placa = new javax.swing.JTextField();
        conductor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelOperaciones.setBackground(new java.awt.Color(0, 0, 51));
        panelOperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setBackground(new java.awt.Color(14, 15, 34));

        jTable.setBackground(new java.awt.Color(184, 185, 194));
        jTable.setModel(tabla);
        jTable.setSelectionBackground(new java.awt.Color(55, 175, 177));
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        jlabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jlabel1.setForeground(new java.awt.Color(240, 240, 240));
        jlabel1.setText("Conductor");

        jlabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jlabel2.setForeground(new java.awt.Color(240, 240, 240));
        jlabel2.setText("Placa");

        Añadir.setBackground(new java.awt.Color(184, 185, 194));
        Añadir.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Añadir.setText("AÑADIR");
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });

        Consultar.setBackground(new java.awt.Color(184, 185, 194));
        Consultar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Consultar.setText("CONSULTAR");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        Borrar.setBackground(new java.awt.Color(184, 185, 194));
        Borrar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Borrar.setText("BORRAR");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        placa.setBackground(new java.awt.Color(184, 185, 194));
        placa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        placa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                placaKeyTyped(evt);
            }
        });

        conductor.setBackground(new java.awt.Color(184, 185, 194));
        conductor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        conductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        conductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                conductorKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Ingrese la identificacion del conductor del vehiculo");

        Atras.setBackground(new java.awt.Color(184, 185, 194));
        Atras.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Atras.setText("ATRAS");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(184, 185, 194));
        Guardar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Guardar.setText("GUARDAR");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Ingrese la placa del vehiculo");

        javax.swing.GroupLayout panelOperacionesLayout = new javax.swing.GroupLayout(panelOperaciones);
        panelOperaciones.setLayout(panelOperacionesLayout);
        panelOperacionesLayout.setHorizontalGroup(
            panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperacionesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOperacionesLayout.createSequentialGroup()
                        .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelOperacionesLayout.createSequentialGroup()
                                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlabel1)
                                    .addComponent(jlabel2))
                                .addGap(24, 24, 24)
                                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelOperacionesLayout.createSequentialGroup()
                                        .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelOperacionesLayout.createSequentialGroup()
                                        .addComponent(conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Borrar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperacionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Añadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperacionesLayout.createSequentialGroup()
                                .addComponent(Atras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Consultar)))))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        panelOperacionesLayout.setVerticalGroup(
            panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperacionesLayout.createSequentialGroup()
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOperacionesLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperacionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel2)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelOperacionesLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(panelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        btnAñadir();
    }//GEN-LAST:event_AñadirActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        btnConsultar();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        btnEliminar();
    }//GEN-LAST:event_BorrarActionPerformed

    private void conductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conductorKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo valores numericos", "Tipo de dato incompatible", JOptionPane.INFORMATION_MESSAGE);
        }

        if (conductor.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_conductorKeyTyped

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        btnAtras();
    }//GEN-LAST:event_AtrasActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        btnGuardar();
    }//GEN-LAST:event_GuardarActionPerformed

    private void placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placaKeyTyped
        if (placa.getText().length() >= 6) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_placaKeyTyped

    DefaultTableModel tabla = new DefaultTableModel();

    public void creartabla() {
        tabla.addColumn("NOMBRE E IDENTIFICACION DEL CONDUCTOR");
        tabla.addColumn("MARCA Y PLACA DEL VEHICULO");
    }

    public void llenartabla() {
        tabla.setNumRows(0);
        for (Responsable r : vistaInicial.ctrlresponsable.getResponsables()) {
            String[] fila = {r.getConductor().getNombre().toUpperCase() + " " + r.getConductor().getApellido().toUpperCase() + " - " + r.getConductor().getIdentificacion(), r.getVehiculo().getMarca().toUpperCase() + " - " + r.getVehiculo().getPlaca().toUpperCase()};
            tabla.addRow(fila);
        }
    }

    public void cargarTabla() {
        if (vistaInicial.ctrlresponsable.validarArchivo() == true) {
            tabla.setNumRows(0);
            for (Responsable r : vistaInicial.ctrlresponsable.cargarResponsables()) {
                String[] fila = {r.getConductor().getNombre().toUpperCase() + " " + r.getConductor().getApellido().toUpperCase(), r.getVehiculo().getMarca().toUpperCase()};
                tabla.addRow(fila);
                vistaInicial.ctrlresponsable.agregar(r);
            }
        }
    }

    public void mostrarConsulta() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
        }
        tabla.setNumRows(0);
        for (Responsable r : vistaInicial.ctrlresponsable.getResponsables()) {
            if (r.getConductor().getIdentificacion().equalsIgnoreCase(conductor.getText())) {
                String[] fila = {r.getConductor().getNombre().toUpperCase() + " " + r.getConductor().getApellido().toUpperCase(), r.getVehiculo().getMarca().toUpperCase()};
                tabla.addRow(fila);
                placa.setText(r.getVehiculo().getPlaca());
            }
        }
    }

    public void vaciar() {
        conductor.setText("");
        placa.setText("");
        Atras.setVisible(false);
        Añadir.setEnabled(true);
        Guardar.setEnabled(true);
    }

    public boolean validarCampoPlaca() {
        String letras = placa.getText().substring(0, 3);
        String numeros = placa.getText().substring(3, 6);
        boolean validacion = true;

        for (int i = 0; i < letras.length(); i++) {
            if (!Character.isLetter(letras.charAt(i))) {
                validacion = false;
            }
        }

        for (int i = 0; i < numeros.length(); i++) {
            if (!Character.isDigit(numeros.charAt(i))) {
                validacion = false;
            }
        }
        return validacion;
    }

    public void btnAñadir() {
        if (conductor.getText().equals("") || placa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "¡FALTAN CAMPOS POR LLENAR!\n"
                    + "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
        } else {
            if (conductor.getText().length() != 10 || placa.getText().length() != 6) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese los caracteres que se requieren en el campo CONDUCTOR o PLACA", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (validarCampoPlaca() != true) {
                    JOptionPane.showMessageDialog(null, "Patron de placa incorrecto", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (vistaInicial.ctrlresponsable.verificarYAgregar(conductor.getText(), placa.getText()) != true) {
                        JOptionPane.showMessageDialog(null, "Uno de los datos no se encontró, ingrese los datos correctos por favor.",
                                "Agregar", JOptionPane.ERROR_MESSAGE);
                        conductor.setText("");
                        placa.setText("");
                    } else {
                        Modelo.Conductor Conductor = vistaInicial.ctrlresponsable.agregarConductor(conductor.getText());
                        Modelo.Automovil automovil = vistaInicial.ctrlresponsable.agregarAuto(placa.getText());
                        if (Conductor == null || automovil == null) {
                            JOptionPane.showMessageDialog(null, "Uno de los datos no se encontró, ingrese los datos correctos por favor.", "Agregar", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Responsable constructor = new Responsable();
                            constructor.setConductor(Conductor);
                            constructor.setVehiculo(automovil);
                            vistaInicial.ctrlresponsable.agregar(constructor);
                            vaciar();
                            llenartabla();
                        }
                    }
                }
            }
        }
    }

    public void btnConsultar() {
        if (vistaInicial.ctrlresponsable.listaVacia() == true) {
            JOptionPane.showMessageDialog(null, "No hay ninguna persona registrada.", "Consultar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (conductor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la identificación del responsable a buscar", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
            } else {
                vistaInicial.ctrlresponsable.consultar(conductor.getText());
                mostrarConsulta();
                Atras.setVisible(true);
                Añadir.setEnabled(false);
                Guardar.setEnabled(false);
            }
        }
    }

    public void btnEliminar() {
        if (vistaInicial.ctrlresponsable.listaVacia() == true) {
            JOptionPane.showMessageDialog(null, "No hay ningun responsable registrado.", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (conductor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "No hay ningun responsable registrado.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean validar = vistaInicial.ctrlresponsable.eliminar(conductor.getText());
                if (validar == false) {
                    JOptionPane.showMessageDialog(null, "No existe algun responsable con esa identificación", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    llenartabla();
                    vaciar();
                }
            }
        }
    }

    public void btnGuardar() {
        vistaInicial.ctrlresponsable.guardarResponsable();
    }

    public void btnAtras() {
        llenartabla();
        vaciar();
    }

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
            java.util.logging.Logger.getLogger(vistaResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaResponsable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton Añadir;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField conductor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    public java.awt.Panel panelOperaciones;
    private javax.swing.JTextField placa;
    // End of variables declaration//GEN-END:variables
}
