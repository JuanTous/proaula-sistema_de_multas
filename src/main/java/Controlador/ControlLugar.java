/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Lugar;
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

/**
 *
 * @author Juan Tous
 */
public class ControlLugar {

    private String ruta = new File("Lugares.sdm").getAbsolutePath();
    private List<Lugar> lugares = new LinkedList();
    FileOutputStream fout;
    FileInputStream fin;

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void llenarListaDeLugares() {
        if (validarArchivo() == true) {
            for (Lugar l : cargarLugares()) {
                lugares.add(l);
            }
        }
    }

    public void agregar(Lugar l) {
        llenarListaDeLugares();
        lugares.add(l);
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardarLugar() {
        canalsalida();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fout);
            out.writeObject(lugares);
        } catch (IOException ex) {
            Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public LinkedList<Lugar> cargarLugares() {
        canalentrada();
        ObjectInputStream ois = null;
        LinkedList<Lugar> lugares = new LinkedList();
        try {
            ois = new ObjectInputStream(fin);
            try {
                lugares = (LinkedList<Lugar>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlLugar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lugares;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

}
