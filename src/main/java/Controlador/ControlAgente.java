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
public class ControlAgente {

    private String ruta = new File("Agentes de transito.sdm").getAbsolutePath();
    private List<AgenteDeTransito> agentes = new LinkedList();

    FileOutputStream fout;
    FileInputStream fin;

    public boolean listaVacia() {
        if (agentes.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarYAgregar(String identificacion) {
        int contador = 0;
        boolean agente = false;

        for (AgenteDeTransito a : agentes) {
            if (a.getIdentificacion().equals(identificacion)) {
                contador++;
            }

            if (contador != 0) {
                agente = true;
            } else {
                agente = false;
            }
        }

        for (Dueño d : vistaInicial.ctrldueño.cargarDueños()) {
            if (d.getIdentificacion().equals(identificacion)) {
                contador++;
            }

            if (contador != 0) {
                agente = true;
            } else {
                agente = false;
            }
        }

        for (Conductor c : vistaInicial.ctrlconductor.cargarConductores()) {
            if (c.getIdentificacion().equals(identificacion)) {
                contador++;
            }

            if (contador != 0) {
                agente = true;
            } else {
                agente = false;
            }
        }

        return agente;

    }

    public boolean validarArchivo() {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    //De la clase InicioDeSesion
    public AgenteDeTransito consultarUsuario(String usuario, String Contraseña) {
        AgenteDeTransito agente = null;
        for (AgenteDeTransito a : cargarAgentes()) {
            if (a.getUsuario().equalsIgnoreCase(usuario) && a.getContraseña().equals(Contraseña)) {
                JOptionPane.showMessageDialog(null, "¡CORDIAL BIENVENIDA " + a.getNombre().toUpperCase() + " " + a.getApellido().toUpperCase() + "!",
                        "INICIO DE SESIÓN", JOptionPane.INFORMATION_MESSAGE);
                agente = a;
            }
        }
        return agente;
    }

    public void agregar(AgenteDeTransito a) {
        agentes.add(a);
    }

    public AgenteDeTransito consultar(String identificacion) {
        AgenteDeTransito agente = null;
        for (AgenteDeTransito a : agentes) {
            if (a.getIdentificacion().equals(identificacion)) {
                JOptionPane.showMessageDialog(null, "Se ha consultado a " + a.getNombre() + " " + a.getApellido(),
                        "Consultar agente", JOptionPane.INFORMATION_MESSAGE);
                agente = a;
                break;
            }
        }

        if (agente == null) {
            JOptionPane.showMessageDialog(null, "No existe algun agente con esa identidicación.", "Consultar agente", JOptionPane.INFORMATION_MESSAGE);
        }

        return agente;
    }

    public AgenteDeTransito actualizar(String identificacion, String email, String codigo) {
        AgenteDeTransito agente = null;
        boolean agenteEncontrado = false;
        for (AgenteDeTransito a : agentes) {
            if (a.getIdentificacion().equals(identificacion)) {
                agenteEncontrado = true;
                if (a.getEmail().equalsIgnoreCase(email) && a.getCodigo().equalsIgnoreCase(codigo)) {
                    JOptionPane.showMessageDialog(null, "Está ingresando datos ya existentes.", "Actualizar agente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int num = JOptionPane.showConfirmDialog(null, "¿Confirma la actualizacion de los siguientes datos?\n"
                            + "EMAIL: " + a.getEmail().toUpperCase() + " -----> " + email.toUpperCase() + "\n"
                            + "CODIGO: " + a.getCodigo().toUpperCase() + " -----> " + codigo.toUpperCase(),
                            "Actualizar agente", JOptionPane.YES_NO_OPTION);
                    if (num == 0) {
                        JOptionPane.showMessageDialog(null, "Se han actualizado los datos de " + a.getNombre() + " " + a.getApellido(),
                                "Actualizar agente", JOptionPane.INFORMATION_MESSAGE);
                        a.setEmail(email);
                        a.setCodigo(codigo);
                        agente = a;
                        break;
                    }
                }
            }
        }

        if (agenteEncontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe algun agente con esa identificación.", "Actualizar dueño", JOptionPane.INFORMATION_MESSAGE);
        }

        return agente;
    }

    public boolean eliminar(String identificacion) {
        boolean agente = false;
        for (AgenteDeTransito a : agentes) {
            if (a.getIdentificacion().equals(identificacion)) {
                int num = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar a " + a.getNombre() + " " + a.getApellido() + "?",
                        "Eliminar agente", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    JOptionPane.showMessageDialog(null, "Se ha sido eliminado a " + a.getNombre(),
                            "Eliminar agente", JOptionPane.INFORMATION_MESSAGE);
                    agentes.remove(a);
                    agente = true;
                    break;
                } else {
                    agente = true;
                    break;
                }
            }
        }

        return agente;
    }

    public void canalsalida() {
        try {
            fout = new FileOutputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlDueño.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void canalentrada() {
        try {
            fin = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ControlDueño.class
                    .getName()).log(Level.SEVERE, null, e);
        }

    }

    public void guardarAgente() {
        ObjectOutputStream out = null;
        int num = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos ingresados?",
                "Guardar", JOptionPane.YES_NO_OPTION);
        if (num == 0) {
            try {
                canalsalida();
                out = new ObjectOutputStream(fout);
                out.writeObject(agentes);
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados exitosamente.",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                Logger.getLogger(ControlAgente.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();

                } catch (IOException ex) {
                    Logger.getLogger(ControlAgente.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public LinkedList<AgenteDeTransito> cargarAgentes() {
        LinkedList<AgenteDeTransito> agentes = new LinkedList();
        if (validarArchivo() == true) {
            canalentrada();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fin);
                try {
                    agentes = (LinkedList<AgenteDeTransito>) ois.readObject();

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControlAgente.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(ControlAgente.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();

                } catch (IOException ex) {
                    Logger.getLogger(ControlAgente.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return agentes;
    }

    public List<AgenteDeTransito> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgenteDeTransito> agentes) {
        this.agentes = agentes;
    }
}
