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
public class TipoDeInfraccion implements Serializable{

    private String CategoriaDeLaInfraccion;
    private String ValorPenalidad;
    private String Observaciones;

    public String getCategoriaDeLaInfraccion() {
        return CategoriaDeLaInfraccion;
    }

    public void setCategoriaDeLaInfraccion(String CategoriaDeLaInfraccion) {
        this.CategoriaDeLaInfraccion = CategoriaDeLaInfraccion;
    }

    public String getValorPenalidad() {
        return ValorPenalidad;
    }

    public void setValorPenalidad(String ValorPenalidad) {
        this.ValorPenalidad = ValorPenalidad;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

}
