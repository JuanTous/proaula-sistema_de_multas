/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Automovil;
import Modelo.Conductor;
import Modelo.Responsable;
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
public class ControlResponsable {

    private String ruta = new File("Responsables.sdm").getAbsolutePath();
    private List<Responsable> responsables = new LinkedList();
    FileOutputStream fout;
    FileInputStream fin;

    public boolean listaVacia() {
        if (responsables.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarYAgregar(String conductor, String placa) {
        int contador = 0;
        boolean validar = false;
        ControlAutomovil ca = new ControlAutomovil();
        ControlConductor cc = new ControlConductor();

        for (Automovil a : ca.cargarAutos()) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                contador++;
            }

            if (contador != 0) {
                validar = true;
            }
        }

        for (Conductor c : cc.cargarConductores()) {
            if (c.getIdentificacion().equals(conductor)) {
                contador++;
            }

            if (contador != 0) {
                validar = true;
            }
        }

        return validar;
    }

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public Conductor agregarConductor(String identificacion) {
        Conductor conductor = null;
        ControlConductor cc = new ControlConductor();

        for (Conductor c : cc.cargarConductores()) {
            if (c.getIdentificacion().equals(identificacion)) {
                conductor = c;
            }
        }

        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No se encontro el conductor ingresado");
        }

        return conductor;
    }

    public Automovil agregarAuto(String placa) {
        Automovil automovil = null;
        ControlAutomovil ca = new ControlAutomovil();

        for (Automovil a : ca.cargarAutos()) {
            if (a.getPlaca().equals(placa)) {
                automovil = a;
            }
        }

        if (automovil == null) {
            JOptionPane.showMessageDialog(null, "No se encontro el automovil ingresado");
        }

        return automovil;
    }

    public void agregar(Responsable r) {
        responsables.add(r);
    }

    public Conductor consultar(String Conductor) {
        Conductor conductor = null;
        for (Conductor r : CRUD_entidadesPrincipales.vistaInicial.ctrlconductor.cargarConductores()) {
            if (r.getIdentificacion().equalsIgnoreCase(Conductor)) {
                JOptionPane.showMessageDialog(null, "Se ha consultado el vehiculo de placa " + r.getNombre() + " " + r.getApellido(),
                        "Consultar responsable", JOptionPane.INFORMATION_MESSAGE);
                conductor = r;
                break;
            }
        }

        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No existe alguna persona con esa identificación.", "Consultar responsable", JOptionPane.INFORMATION_MESSAGE);
        }

        return conductor;
    }

    public boolean eliminar(String identificacion) {
        boolean responsable = false;
        for (Responsable r : responsables) {
            if (r.getConductor().getIdentificacion().equalsIgnoreCase(identificacion)) {
                int num = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar a la persona responsable del vehiculo" + r.getVehiculo().getMarca().toUpperCase()
                        + " con placa " + r.getVehiculo().getPlaca().toUpperCase() + "?",
                        "Eliminar", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    JOptionPane.showMessageDialog(null, "El responsable ha sido eliminado.",
                            "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                    responsables.remove(r);
                    responsable = true;
                    break;
                } else {
                    responsable = true;
                    break;
                }
            }
        }

        return responsable;
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void guardarResponsable() {
        ObjectOutputStream out = null;
        int num = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos ingresados?",
                "Guardar", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            try {
                canalsalida();
                out = new ObjectOutputStream(fout);
                out.writeObject(responsables);
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados exitosamente.",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public LinkedList<Responsable> cargarResponsables() {
        canalentrada();
        ObjectInputStream ois = null;
        LinkedList<Responsable> responsables = new LinkedList();
        try {
            ois = new ObjectInputStream(fin);
            try {
                responsables = (LinkedList<Responsable>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlResponsable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return responsables;
    }

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }

}
