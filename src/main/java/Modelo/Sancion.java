/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Juan Tous
 */
public class Sancion implements Serializable {

    private int ValorMulta;
    private Calendar FechaDeInfraccion;
    private Calendar FechaDeVencimiento;
    private String EstadoDeLaSancion;
    private DetalleDeLaInfraccion detalleDeInfraccion;

    public int getValorMulta() {
        return ValorMulta;
    }

    public void setValorMulta(int ValorMulta) {
        this.ValorMulta = ValorMulta;
    }

    public Calendar getFechaDeInfraccion() {
        return FechaDeInfraccion;
    }

    public void setFechaDeInfraccion(Calendar FechaDeInfraccion) {
        this.FechaDeInfraccion = FechaDeInfraccion;
    }

    public Calendar getFechaDeVencimiento() {
        return FechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Calendar FechaDeVencimiento) {
        this.FechaDeVencimiento = FechaDeVencimiento;
    }

    public String getEstadoDeLaSancion() {
        return EstadoDeLaSancion;
    }

    public void setEstadoDeLaSancion(String EstadoDeLaSancion) {
        this.EstadoDeLaSancion = EstadoDeLaSancion;
    }

    public DetalleDeLaInfraccion getDetalleDeInfraccion() {
        return detalleDeInfraccion;
    }

    public void setDetalleDeInfraccion(DetalleDeLaInfraccion detalleDeInfraccion) {
        this.detalleDeInfraccion = detalleDeInfraccion;
    }


}
