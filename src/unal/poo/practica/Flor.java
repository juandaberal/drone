/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;

import becker.robots.City;
import becker.robots.Thing;
import cultivo.model.Planta;
import unal.poo.practica.Bicon;

/**
 *
 * @author Fabian Giraldo
 */
public class Flor extends Planta {

    private String[] images = {"planta.png", "planta1.png"};
    private int state;

    public Flor(double humedad, double temperatura, int cantFertilizante, City city, int i, int i1) {
        super(humedad, temperatura, cantFertilizante, city, i, i1);
        this.state = 0;
        setIcon(new Bicon(this.images[this.state]));
    }

    public void cambiarEstado() {
        this.state = ((this.state + 1) % 2);
        setIcon(new Bicon(this.images[this.state]));
    }
}
