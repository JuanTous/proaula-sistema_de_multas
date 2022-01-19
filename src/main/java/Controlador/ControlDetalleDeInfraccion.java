/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleDeLaInfraccion;
import Modelo.Infraccion;
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
public class ControlDetalleDeInfraccion {

    private String ruta = new File("Detalles de infracciones.sdm").getAbsolutePath();
    private List<DetalleDeLaInfraccion> detallesInfs = new LinkedList();
    public static DetalleDeLaInfraccion constructor = new DetalleDeLaInfraccion();
    public static ControlSancion constructorSancion = new ControlSancion();

    FileOutputStream fout;
    FileInputStream fin;

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        return archivo.exists();
    }

    public void agregar(Infraccion infraccion) {
        constructor.setInfraccion(infraccion);
        constructor.setTipoDeInfraccion(infraccion.getTipoDeInfraccion());
        constructor.setEstado("ACTIVA");
        constructor.setObservaciones(infraccion.getObservaciones());
        detallesInfs.add(constructor);
        constructorSancion.agregar(constructor);
        guardarDetallesDeInfracciones();
    }

    public void llenarLista() {
        for (DetalleDeLaInfraccion d : cargarDetallesDeInfracciones()) {
            detallesInfs.add(d);
        }
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardarDetallesDeInfracciones() {
        ObjectOutputStream out = null;
        try {
            llenarLista();
            canalsalida();
            out = new ObjectOutputStream(fout);
            out.writeObject(detallesInfs);
            detallesInfs.clear();
        } catch (IOException ex) {
            Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar los archivos de detalles de la infracción",
                    "Guardar", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar los archivos de detalles de la infracción",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public LinkedList<DetalleDeLaInfraccion> cargarDetallesDeInfracciones() {
        LinkedList<DetalleDeLaInfraccion> infccns = new LinkedList();
        if (validarArchivo() == true) {
            canalentrada();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fin);
                try {
                    infccns = (LinkedList<DetalleDeLaInfraccion>) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlDetalleDeInfraccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return infccns;
    }

    public List<DetalleDeLaInfraccion> getDetallesInfs() {
        return detallesInfs;
    }

    public void setDetallesInfs(List<DetalleDeLaInfraccion> detallesInfs) {
        this.detallesInfs = detallesInfs;
    }

}
