/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Automovil;
import Controlador.ControlDueño;
import Modelo.Dueño;
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
public class ControlAutomovil {

    private String ruta = new File("Automoviles.sdm").getAbsolutePath();
    private List<Automovil> automoviles = new LinkedList();
    FileOutputStream fout;
    FileInputStream fin;

    public boolean listaVacia() {
        if (automoviles.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarYAgregar(String placa) {
        int contador = 0;
        boolean auto = false;
        for (Automovil a : automoviles) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                contador++;
            }

            if (contador != 0) {
                auto = true;
            } else {
                auto = false;
            }
        }
        return auto;
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
    public Automovil consultarAutoResponsable(String placa) {
        Automovil auto = null;
        for (Automovil a : cargarAutos()) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                auto = a;
                break;
            }
        }

        if (auto == null) {
            JOptionPane.showMessageDialog(null, "No existe algun vehiculo con esa placa.", "Consultar automovil", JOptionPane.INFORMATION_MESSAGE);
        }

        return auto;
    }

    public void agregar(Automovil a) {
        automoviles.add(a);
    }

    public Automovil consultar(String placa) {
        Automovil auto = null;
        for (Automovil a : automoviles) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                JOptionPane.showMessageDialog(null, "Se ha consultado el vehiculo de placa " + a.getPlaca()
                        + " del propietario " + a.getDueño().getNombre() + " " + a.getDueño().getApellido(),
                        "Consultar automovil", JOptionPane.INFORMATION_MESSAGE);
                auto = a;
                break;
            }
        }

        if (auto == null) {
            JOptionPane.showMessageDialog(null, "No existe algun vehiculo con esa placa.", "Consultar automovil", JOptionPane.INFORMATION_MESSAGE);
        }

        return auto;
    }

    public Automovil actualizar(String placa, String dueño, String color) {
        Automovil auto = null;
        boolean autoEncontrado = false;
        for (Automovil a : automoviles) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                ControlDueño constructor = new ControlDueño();
                Dueño nuevoDueño = constructor.actualizarDueñoAuto(a.getDueño(), dueño);
                autoEncontrado = true;
                if (nuevoDueño != null) {
                    if (a.getDueño().getIdentificacion().equals(nuevoDueño.getIdentificacion()) && a.getColor().equalsIgnoreCase(color)) {
                        JOptionPane.showMessageDialog(null, "Está ingresando datos ya existentes.", "Actualizar automovil", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        int num = JOptionPane.showConfirmDialog(null, "¿Confirma la actualizacion de los siguientes datos?\n"
                                + "PROPIETARIO: " + a.getDueño().getNombre().toUpperCase() + " " + a.getDueño().getApellido().toUpperCase() + " -----> "
                                + nuevoDueño.getNombre().toUpperCase() + " " + nuevoDueño.getApellido().toUpperCase() + "\n"
                                + "COLOR: " + a.getColor().toUpperCase() + " -----> " + color.toUpperCase(),
                                "Actualizar automovil", JOptionPane.YES_NO_OPTION);
                        if (num == 0) {
                            a.setDueño(nuevoDueño);
                            a.setColor(color);
                            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del vehiculo.", "Actualizar automovil", JOptionPane.INFORMATION_MESSAGE);
                            auto = a;
                            break;
                        }
                    }

                }
            }
        }

        if (autoEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe algun automovil con esa placa.", "Actualizar automovil", JOptionPane.INFORMATION_MESSAGE);
        }

        return auto;
    }

    public boolean eliminar(String placa) {
        boolean auto = false;
        for (Automovil a : automoviles) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                int num = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el vehiculo de marca " + a.getMarca()
                        + " con placa " + a.getPlaca() + " del propietario " + a.getDueño().getNombre() + " " + a.getDueño().getApellido() + "?",
                        "Eliminar automovil", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    JOptionPane.showMessageDialog(null, "Se ha sido eliminado el vehiculo",
                            "Eliminar automovil", JOptionPane.INFORMATION_MESSAGE);
                    automoviles.remove(a);
                    auto = true;
                    break;
                } else {
                    auto = true;
                    break;
                }
            }
        }

        return auto;
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void guardarAuto() {
        ObjectOutputStream out = null;
        int num = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos ingresados?",
                "Guardar", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            try {
                canalsalida();
                out = new ObjectOutputStream(fout);
                out.writeObject(automoviles);
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados exitosamente.",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public LinkedList<Automovil> cargarAutos() {
        canalentrada();
        ObjectInputStream ois = null;
        LinkedList<Automovil> autos = new LinkedList();
        try {
            ois = new ObjectInputStream(fin);
            try {
                autos = (LinkedList<Automovil>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlAutomovil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return autos;
    }

    public List<Automovil> getAutos() {
        return automoviles;
    }

    public void setAutos(List<Automovil> automoviles) {
        this.automoviles = automoviles;
    }

}
