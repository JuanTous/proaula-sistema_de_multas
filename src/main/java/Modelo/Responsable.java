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
public class Responsable implements Serializable{
    
    private Conductor conductor;
    private Automovil vehiculo;

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Automovil getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Automovil vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
