/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AgenteDeTransito;
import Modelo.Conductor;
import Modelo.Dueño;
import CRUD_entidadesPrincipales.vistaInicial;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Tous
 */
public class ControlDueño {

    private String ruta = new File("Dueños.sdm").getAbsolutePath();
    private List<Dueño> dueños = new LinkedList();

    FileOutputStream fout;
    FileInputStream fin;

    public boolean listaVacia() {
        if (dueños.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarYAgregar(String id) {
        int contador = 0;
        boolean dueño = false;

        for (Dueño d : dueños) {
            if (d.getIdentificacion().equals(id)) {
                contador++;
            }

            if (contador != 0) {
                dueño = true;
            } else {
                dueño = false;
            }
        }

        for (AgenteDeTransito a : vistaInicial.ctrlagente.cargarAgentes()) {
            if (a.getIdentificacion().equals(id)) {
                contador++;
            }

            if (contador != 0) {
                dueño = true;
            } else {
                dueño = false;
            }
        }

        for (Conductor c : vistaInicial.ctrlconductor.cargarConductores()) {
            if (c.getIdentificacion().equals(id)) {
                contador++;
            }

            if (contador != 0) {
                dueño = true;
            } else {
                dueño = false;
            }
        }

        return dueño;
    }

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar(Dueño d) {
        dueños.add(d);
    }

    public Dueño consultar(String Id) {
        Dueño dueño = null;
        for (Dueño d : dueños) {
            if (d.getIdentificacion().equals(Id)) {
                JOptionPane.showMessageDialog(null, "Se ha consultado a " + d.getNombre() + " " + d.getApellido(),
                        "Consultar dueño", JOptionPane.INFORMATION_MESSAGE);
                dueño = d;
                break;
            }
        }

        if (dueño == null) {
            JOptionPane.showMessageDialog(null, "No existe alguna persona con esa identificación.", "Consultar dueño", JOptionPane.INFORMATION_MESSAGE);
        }

        return dueño;
    }

    public Dueño actualizar(String Id, String CodigoPostal, String telefono, String email) {
        Dueño dueño = null;
        boolean dueñoEncontrado = false;
        for (Dueño d : dueños) {
            if (d.getIdentificacion().equals(Id)) {
                dueñoEncontrado = true;
                if (d.getCodigoPostal().equals(CodigoPostal) && d.getTelefono().equals(telefono) && d.getEmail().equalsIgnoreCase(email)) {
                    JOptionPane.showMessageDialog(null, "Está ingresando datos ya existentes.", "Actualizar dueño", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int num = JOptionPane.showConfirmDialog(null, "¿Confirma la actualizacion de los siguientes datos?\n"
                            + "CODIGO POSTAL: " + d.getCodigoPostal() + " -----> " + CodigoPostal + "\n"
                            + "TELEFONO: " + d.getTelefono() + " -----> " + telefono + "\n"
                            + "EMAIL: " + d.getEmail().toUpperCase() + " -----> " + email.toUpperCase(),
                            "Actualizar dueño", JOptionPane.YES_NO_OPTION);
                    if (num == 0) {
                        JOptionPane.showMessageDialog(null, "Se han actualizado los datos de " + d.getNombre() + " " + d.getApellido(),
                                "Actualizar dueño", JOptionPane.INFORMATION_MESSAGE);
                        d.setCodigoPostal(CodigoPostal);
                        d.setTelefono(telefono);
                        d.setEmail(email);
                        dueño = d;
                        break;
                    }
                }
            }
        }

        if (dueñoEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe alguna persona con esa identificación.", "Actualizar dueño", JOptionPane.INFORMATION_MESSAGE);
        }

        return dueño;
    }

    public boolean eliminar(String id) {
        boolean dueño = false;
        for (Dueño p : dueños) {
            if (p.getIdentificacion().equals(id)) {
                int num = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar a " + p.getNombre() + " " + p.getApellido() + "?",
                        "Eliminar dueño", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    JOptionPane.showMessageDialog(null, "Se ha sido eliminado a " + p.getNombre(),
                            "Eliminar dueño", JOptionPane.INFORMATION_MESSAGE);
                    dueños.remove(p);
                    dueño = true;
                    break;
                } else {
                    dueño = true;
                    break;
                }
            }
        }

        return dueño;
    }

    //De la clase vistaAutomovil
    public Dueño asignarDueñoAuto(String Id) {
        Dueño dueño = null;
        boolean dueñoEncontrado = false;
        for (Dueño d : cargarDueños()) {
            if (d.getIdentificacion().equals(Id)) {
                dueñoEncontrado = true;
                int num = JOptionPane.showConfirmDialog(null, "¿Confirma que el propietario de este vehiculo es " + d.getNombre().toUpperCase() + " " + d.getApellido().toUpperCase() + "?",
                        "Agregar", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    JOptionPane.showMessageDialog(null, "El propietario de este vehiculo es " + d.getNombre().toUpperCase() + " " + d.getApellido().toUpperCase(),
                            "Asignar dueño del vehiculo", JOptionPane.INFORMATION_MESSAGE);
                    dueño = d;
                }
            }
        }
        if (dueñoEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe alguna persona con esa identificación ", "Asignar dueño del vehiculo", JOptionPane.INFORMATION_MESSAGE);
        }

        return dueño;
    }

    //De la clase vistaAutomovil
    public Dueño actualizarDueñoAuto(Dueño antiguoDueño, String Id) {
        Dueño dueño = null;
        boolean dueñoEncontrado = false;
        for (Dueño d : cargarDueños()) {
            if (d.getIdentificacion().equals(Id)) {
                dueñoEncontrado = true;
                if (d.getIdentificacion().equals(antiguoDueño.getIdentificacion())) {
                    dueño = antiguoDueño;
                } else {
                    int num = JOptionPane.showConfirmDialog(null, "¿Confirme si quiere que el vehiculo haga el siguiente cambio de propietario: "
                            + antiguoDueño.getNombre().toUpperCase() + " " + antiguoDueño.getApellido().toUpperCase() + " -----> " + d.getNombre().toUpperCase() + " " + d.getApellido().toUpperCase(),
                            "Asignar dueño del vehiculo", JOptionPane.YES_NO_OPTION);
                    if (num == 0) {
                        JOptionPane.showMessageDialog(null, "El nuevo propietario del vehiculo es " + d.getNombre().toUpperCase() + " " + d.getApellido().toUpperCase(),
                                "Asignar dueño del vehiculo", JOptionPane.INFORMATION_MESSAGE);
                        dueño = d;
                    } else {
                        dueño = antiguoDueño;
                    }
                }
            }
        }
        if (dueñoEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe alguna persona con esa identificación ", "Asignar dueño del vehiculo", JOptionPane.INFORMATION_MESSAGE);
        }

        return dueño;
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void guardarDueño() {
        ObjectOutputStream out = null;
        int num = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos ingresados?",
                "Guardar", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            try {
                canalsalida();
                out = new ObjectOutputStream(fout);
                out.writeObject(dueños);
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados exitosamente.",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public LinkedList<Dueño> cargarDueños() {
        LinkedList<Dueño> dñs = new LinkedList();
        if (validarArchivo() == true) {
            canalentrada();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fin);
                try {
                    dñs = (LinkedList<Dueño>) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlDueño.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dñs;
    }

    public List<Dueño> getDueños() {
        return dueños;
    }

    public void setDueños(List<Dueño> dueños) {
        this.dueños = dueños;
    }
}
