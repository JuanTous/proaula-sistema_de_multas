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
public class Expediente implements Serializable{
    
    private Infraccion infraccion;
    private String FechaDeAlegacion;
    private String Alegacion;
    private String EstadoDelExpediente;

    public Infraccion getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(Infraccion infraccion) {
        this.infraccion = infraccion;
    }

    public String getFechaDeAlegacion() {
        return FechaDeAlegacion;
    }

    public void setFechaDeAlegacion(String FechaDeAlegacion) {
        this.FechaDeAlegacion = FechaDeAlegacion;
    }

    public String getAlegacion() {
        return Alegacion;
    }

    public void setAlegacion(String Alegacion) {
        this.Alegacion = Alegacion;
    }

    public String getEstadoDelExpediente() {
        return EstadoDelExpediente;
    }

    public void setEstadoDelExpediente(String EstadoDelExpediente) {
        this.EstadoDelExpediente = EstadoDelExpediente;
    }
    
}
