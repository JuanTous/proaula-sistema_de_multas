/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleDeLaInfraccion;
import Modelo.Sancion;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Tous
 */
public class ControlSancion {

    private String ruta = new File("Sanciones.sdm").getAbsolutePath();
    private static Sancion constructor = new Sancion();
    private List<Sancion> sanciones = new LinkedList();
    private static Calendar fechaVen = null;

    FileOutputStream fout;
    FileInputStream fin;

    int calculos(String valorPenalidad) {
        int valorDeMulta = 0;
        final int smdlv = 30284;

        switch (valorPenalidad) {

            case "4": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            case "8": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            case "15": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            case "30": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            case "45": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            case "360": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            case "1500": {
                valorDeMulta = smdlv * Integer.parseInt(valorPenalidad);
                break;
            }

            default:
                break;
        }

        return valorDeMulta;
    }

    Calendar fechaDeVencimiento(Calendar fechaInf, String valorPenalidad) {

        Calendar fechaClone = (Calendar) fechaInf.clone();
        fechaVen = fechaClone;
        switch (valorPenalidad) {

            case "4": {
                fechaVen.add(Calendar.MONTH, 1);
                break;
            }

            case "8": {
                fechaVen.add(Calendar.MONTH, 1);
                break;
            }

            case "15": {
                fechaVen.add(Calendar.MONTH, 2);
                break;
            }

            case "30": {
                fechaVen.add(Calendar.MONTH, 2);
                break;
            }

            case "45": {
                fechaVen.add(Calendar.MONTH, 3);
                break;
            }

            case "360": {
                fechaVen.add(Calendar.MONTH, 4);
                break;
            }

            case "1500": {
                fechaVen.add(Calendar.MONTH, 5);
                break;
            }

            default:
                break;
        }

        return fechaVen;
    }

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        return archivo.exists();
    }

    public void agregar(DetalleDeLaInfraccion ddi) {
        constructor.setValorMulta(calculos(ddi.getInfraccion().getTipoDeInfraccion().getValorPenalidad()));
        constructor.setFechaDeInfraccion(ddi.getInfraccion().getFecha());
        constructor.setFechaDeVencimiento(fechaDeVencimiento(ddi.getInfraccion().getFecha(), ddi.getInfraccion().getTipoDeInfraccion().getValorPenalidad()));
        constructor.setDetalleDeInfraccion(ddi);
        constructor.setEstadoDeLaSancion(ddi.getEstado());
        sanciones.add(constructor);
        guardarSanciones();
    }

    public Sancion cancelarSancion(String identificacion) {
        Sancion sancion = null;
        sanciones.clear();
        llenarLista();
        for (Sancion s : sanciones) {
            if (s.getDetalleDeInfraccion().getInfraccion().getResponsable().getVehiculo().getDueño().getIdentificacion().equals(identificacion)) {
                sancion = s;
                sanciones.remove(s);
                sancion.setEstadoDeLaSancion("CANCELADA");
                sanciones.add(sancion);
                guardar();
                break;
            }
        }
        return sancion;
    }

    public void llenarLista() {
        for (Sancion s : cargarSanciones()) {
            sanciones.add(s);
        }
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardarSanciones() {
        ObjectOutputStream out = null;
        try {
            llenarLista();
            canalsalida();
            out = new ObjectOutputStream(fout);
            out.writeObject(sanciones);
            sanciones.clear();
        } catch (IOException ex) {
            Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar los archivos de la sanción",
                    "Guardar", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar los archivos de la sanción",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public void guardar() {
        ObjectOutputStream out = null;
        try {
            canalsalida();
            out = new ObjectOutputStream(fout);
            out.writeObject(sanciones);
            sanciones.clear();
        } catch (IOException ex) {
            Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar los archivos de la sanción",
                    "Guardar", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar los archivos de la sanción",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public LinkedList<Sancion> cargarSanciones() {
        LinkedList<Sancion> infccns = new LinkedList();
        if (validarArchivo() == true) {
            canalentrada();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fin);
                try {
                    infccns = (LinkedList<Sancion>) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlSancion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return infccns;
    }

    public List<Sancion> getSanciones() {
        return sanciones;
    }

    public void setSanciones(List<Sancion> sanciones) {
        this.sanciones = sanciones;
    }
}
