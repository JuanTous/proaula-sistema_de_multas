/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AgenteDeTransito;
import Modelo.Infraccion;
import Modelo.Responsable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Tous
 */
public class ControlInfraccion {

    private String ruta = new File("Infracciones.sdm").getAbsolutePath();
    private List<Infraccion> infracciones = new LinkedList();
    public static List<Infraccion> infraccionesRealizadas = new LinkedList();

    FileOutputStream fout;
    FileInputStream fin;

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        return archivo.exists();
    }

    public AgenteDeTransito asignarAgente(String agente) {
        AgenteDeTransito agent = null;
        for (AgenteDeTransito a : CRUD_entidadesPrincipales.vistaInicial.ctrlagente.cargarAgentes()) {
            if (a.getIdentificacion().equals(agente)) {
                agent = a;
            }
        }
        return agent;
    }

    public Responsable asignarResponsable(String responsable) {
        Responsable responsabl = null;
        for (Responsable r : CRUD_entidadesPrincipales.vistaInicial.ctrlresponsable.cargarResponsables()) {
            if (r.getConductor().getIdentificacion().equals(responsable)) {
                responsabl = r;
            }
        }
        return responsabl;
    }

    public Calendar fecha() {

        Calendar c = new GregorianCalendar();

        return c;
    }

    public LocalTime hora() {
        LocalTime hora = LocalTime.now();

        return hora;
    }

    public void agregar(Infraccion i) {
        infracciones.add(i);
        infraccionesRealizadas.add(i);
    }

    public void llenarLista() {
        for (Infraccion i : cargarInfracciones()) {
            infracciones.add(i);
        }
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardarInfracciones() {
        ObjectOutputStream out = null;
        int num = JOptionPane.showConfirmDialog(null, "¿Desea registrar la denuncia?",
                "Registrar denuncia", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            try {
                llenarLista();
                canalsalida();
                out = new ObjectOutputStream(fout);
                out.writeObject(infracciones);
                infracciones.clear();
                JOptionPane.showMessageDialog(null, "La denuncia ha sido registrada exitosamente.",
                        "Registrar denuncia", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public LinkedList<Infraccion> cargarInfracciones() {
        LinkedList<Infraccion> infccns = new LinkedList();
        if (validarArchivo() == true) {
            canalentrada();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fin);
                try {
                    infccns = (LinkedList<Infraccion>) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlInfraccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return infccns;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }

    public List<Infraccion> getinfraccionesRealizadas() {
        return infraccionesRealizadas;
    }

    public void setinfraccionesRealizadas(List<Infraccion> infraccionesRealizadas) {
        this.infraccionesRealizadas = infraccionesRealizadas;
    }

}
