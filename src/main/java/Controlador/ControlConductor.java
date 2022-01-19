/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AgenteDeTransito;
import Modelo.Conductor;
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
public class ControlConductor {

    private String ruta = new File("Conductores.sdm").getAbsolutePath();
    private List<Conductor> conductores = new LinkedList();
    FileOutputStream fout;
    FileInputStream fin;

    public boolean listaVacia() {
        if (conductores.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarYAgregar(String identificacion) {
        int contador = 0;
        boolean conductor = false;

        for (Conductor c : conductores) {
            if (c.getIdentificacion().equals(identificacion)) {
                contador++;
            }

            if (contador != 0) {
                conductor = true;
            } else {
                conductor = false;
            }
        }

        for (AgenteDeTransito a : vistaInicial.ctrlagente.cargarAgentes()) {
            if (a.getIdentificacion().equals(identificacion)) {
                contador++;
            }

            if (contador != 0) {
                conductor = true;
            } else {
                conductor = false;
            }
        }

        return conductor;
    }

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para la clase responsable
    public Conductor consultarConductorResponsable(String Id) {
        Conductor conductor = null;
        for (Conductor c : cargarConductores()) {
            if (c.getIdentificacion().equals(Id)) {
                conductor = c;
                break;
            }
        }

        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No existe algun conductor con esa identificación.", "Consultar conductor", JOptionPane.INFORMATION_MESSAGE);
        }

        return conductor;
    }

    public void agregar(Conductor c) {
        conductores.add(c);
    }

    public Conductor consultar(String identificacion) {
        Conductor conductor = null;
        for (Conductor c : conductores) {
            if (c.getIdentificacion().equals(identificacion)) {
                JOptionPane.showMessageDialog(null, "Se ha consultado a " + c.getNombre() + " " + c.getApellido(),
                        "Consultar conductor", JOptionPane.INFORMATION_MESSAGE);
                conductor = c;
                break;
            }
        }

        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No existe algun conductor con esa identificación.", "Consultar conductor", JOptionPane.INFORMATION_MESSAGE);
        }

        return conductor;
    }

    public Conductor actualizar(String identificacion, String telefono, String nroLicencia, String estadoLicencia) {
        Conductor conductor = null;
        boolean conductorEncontrado = false;
        for (Conductor c : conductores) {
            if (c.getIdentificacion().equals(identificacion)) {
                conductorEncontrado = true;
                if (c.getTelefono().equals(telefono) && c.getNroLicencia().equals(nroLicencia) && c.getEstadoLicencia().equalsIgnoreCase(estadoLicencia)) {
                    JOptionPane.showMessageDialog(null, "Está ingresando datos ya existentes.", "Actualizar conductor", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int num = JOptionPane.showConfirmDialog(null, "¿Confirma la actualizacion de los siguientes datos?\n"
                            + "TELEFONO: " + c.getTelefono() + " -----> " + telefono + "\n"
                            + "NRO DE LICENCIA: " + c.getNroLicencia().toUpperCase() + " -----> " + nroLicencia.toUpperCase() + "\n"
                            + "ESTADO DE LICENCIA: " + c.getEstadoLicencia().toUpperCase() + " -----> " + estadoLicencia.toUpperCase(),
                            "Actualizar conductor", JOptionPane.YES_NO_OPTION);
                    if (num == 0) {
                        JOptionPane.showMessageDialog(null, "Se han actualizado los datos de " + c.getNombre() + " " + c.getApellido(),
                                "Actualizar conductor", JOptionPane.INFORMATION_MESSAGE);
                        c.setTelefono(telefono);
                        c.setNroLicencia(nroLicencia);
                        c.setEstadoLicencia(estadoLicencia);
                        conductor = c;
                        break;
                    }
                }
            }
        }

        if (conductorEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe algun conductor con esa identificación.", "Actualizar conductor", JOptionPane.INFORMATION_MESSAGE);
        }

        return conductor;
    }

    public boolean eliminar(String identificacion) {
        boolean conductor = false;
        for (Conductor c : conductores) {
            if (c.getIdentificacion().equals(identificacion)) {
                int num = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar a " + c.getNombre() + " " + c.getApellido() + "?",
                        "Eliminar conductor", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    JOptionPane.showMessageDialog(null, "Se ha sido eliminado a " + c.getNombre(),
                            "Eliminar conductor", JOptionPane.INFORMATION_MESSAGE);
                    conductores.remove(c);
                    conductor = true;
                    break;
                } else {
                    conductor = true;
                    break;
                }
            }
        }

        return conductor;
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardarConductor() {
        ObjectOutputStream out = null;
        int num = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos ingresados?",
                "Guardar", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            try {
                canalsalida();
                out = new ObjectOutputStream(fout);
                out.writeObject(conductores);
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados exitosamente.",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public LinkedList<Conductor> cargarConductores() {
        LinkedList<Conductor> conductores = new LinkedList();
        if (validarArchivo() == true) {
            canalentrada();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fin);
                try {
                    conductores = (LinkedList<Conductor>) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlConductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return conductores;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

}
