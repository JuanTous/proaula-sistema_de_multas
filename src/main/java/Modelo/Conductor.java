/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Juan Tous
 */
public class Conductor implements Serializable{

    private String Nombre;
    private String Apellido;
    private String Identificacion;
    private String Sexo;
    private String Telefono;
    private String NroLicencia;
    private String EstadoLicencia;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getNroLicencia() {
        return NroLicencia;
    }

    public void setNroLicencia(String nroLicencia) {
        this.NroLicencia = nroLicencia;
    }

    public String getEstadoLicencia() {
        return EstadoLicencia;
    }

    public void setEstadoLicencia(String EstadoLicencia) {
        this.EstadoLicencia = EstadoLicencia;
    }

}
