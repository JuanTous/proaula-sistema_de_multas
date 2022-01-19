/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Expediente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Tous
 */
public class ControlExpediente {

    private String ruta = new File("Expedientes.sdm").getAbsolutePath();
    private List<Expediente> expedientes = new LinkedList();

    FileOutputStream fout;
    FileInputStream fin;

    public void agregar(Expediente expediente) {
        expedientes.add(expediente);
    }

    public String fecha() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

        return formatoFecha.format(fecha);
    }

    public void llenarLista() {
        for (Expediente e : cargarExpedientes()) {
            expedientes.add(e);
        }
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (Exception e) {
            System.out.print(e);

        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void guardarExpedientes() {
        ObjectOutputStream out = null;
        canalsalida();
        llenarLista();
        try {
            out = new ObjectOutputStream(fout);
            out.writeObject(expedientes);
            expedientes.clear();
        } catch (IOException ex) {
            Logger.getLogger(ControlExpediente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlExpediente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public LinkedList<Expediente> cargarExpedientes() {
        canalentrada();
        ObjectInputStream ois = null;
        LinkedList<Expediente> expdns = new LinkedList();
        try {
            ois = new ObjectInputStream(fin);
            try {
                expdns = (LinkedList<Expediente>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlExpediente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlExpediente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlExpediente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expdns;
    }

}
