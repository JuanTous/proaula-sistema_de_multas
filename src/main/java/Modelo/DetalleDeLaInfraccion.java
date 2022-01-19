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
public class DetalleDeLaInfraccion implements Serializable{
    
    private Infraccion infraccion;
    private TipoDeInfraccion tipoDeInfraccion;
    private String Estado;
    private String Observaciones;

    public Infraccion getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(Infraccion infraccion) {
        this.infraccion = infraccion;
    }

    public TipoDeInfraccion getTipoDeInfraccion() {
        return tipoDeInfraccion;
    }

    public void setTipoDeInfraccion(TipoDeInfraccion tipoDeInfraccion) {
        this.tipoDeInfraccion = tipoDeInfraccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
    
}
