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
public class Automovil implements Serializable{

    private Dueño dueño;
    private String Marca;
    private String Placa;
    private String ModeloVehiculo;
    private String Color;

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getModeloVehiculo() {
        return ModeloVehiculo;
    }

    public void setModeloVehiculo(String ModeloVehiculo) {
        this.ModeloVehiculo = ModeloVehiculo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

}
