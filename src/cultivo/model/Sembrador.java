/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;
import unal.poo.practica.Bicon;

/**
 *
 * @author Estudiante
 */
public class Sembrador extends Drone{
    private int semillas;

    public Sembrador(int semillas, City city, int x, int y, Direction direccion, int nThing) {
        super(city, x, y, direccion, nThing);
        this.semillas = semillas;
        setIcon(new Bicon("drone1.png"));
    }

    @Override
    public void consumirEnergia() {
        this.energia--;
        
    }
    
    public boolean sembrar(Planta planta){
      return false;
    }
    
    
}
