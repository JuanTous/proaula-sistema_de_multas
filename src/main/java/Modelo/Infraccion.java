/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author Juan Tous
 */
public class Infraccion implements Serializable {

    private AgenteDeTransito agenteDeTransito;
    private Responsable responsable;
    private TipoDeInfraccion tipoDeInfraccion;
    private Calendar Fecha;
    private LocalTime Hora;
    private Lugar Lugar;
    private String Observaciones;

    public AgenteDeTransito getAgenteDeTransito() {
        return agenteDeTransito;
    }

    public void setAgenteDeTransito(AgenteDeTransito agenteDeTransito) {
        this.agenteDeTransito = agenteDeTransito;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public TipoDeInfraccion getTipoDeInfraccion() {
        return tipoDeInfraccion;
    }

    public void setTipoDeInfraccion(TipoDeInfraccion tipoDeInfraccion) {
        this.tipoDeInfraccion = tipoDeInfraccion;
    }

    public Calendar getFecha() {
        return Fecha;
    }

    public void setFecha(Calendar Fecha) {
        this.Fecha = Fecha;
    }

    public LocalTime getHora() {
        return Hora;
    }

    public void setHora(LocalTime Hora) {
        this.Hora = Hora;
    }

    public Lugar getLugar() {
        return Lugar;
    }

    public void setLugar(Lugar Lugar) {
        this.Lugar = Lugar;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

}
