/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Sancion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Tous
 */
public class controlCivil {

    private List<Sancion> sanciones = new LinkedList();
    private ControlSancion ctrlSancion = new ControlSancion();

    FileOutputStream fout;
    FileInputStream fin;

    public LinkedList<Sancion> consultarSanciones(String identificacion) {
        LinkedList<Sancion> sncns = new LinkedList();
        for (Sancion s : ctrlSancion.cargarSanciones()) {
            if (s.getDetalleDeInfraccion().getInfraccion().getResponsable().getVehiculo().getDueño().getIdentificacion().equals(identificacion)) {
                if (s.getEstadoDeLaSancion().equals("ACTIVA")) {
                    sncns.add(s);
                    sanciones.add(s);
                }
            }
        }

        if (sncns.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tiene infracciones pendientes.");
        }

        return sncns;
    }

    public List<Sancion> getSanciones() {
        return sanciones;
    }

    public void setSanciones(List<Sancion> sanciones) {
        this.sanciones = sanciones;
    }

}
