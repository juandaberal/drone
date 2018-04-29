/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import unal.poo.practica.Bicon;

/**
 *
 * @author Estudiante
 */
public abstract class Drone extends Robot{
    protected String icono;
    protected int energia;
    private int x ;
    private int y;
    

    public Drone(City city, int x, int y, Direction direccion, int nThing) {
        super(city, x, y, direccion, nThing);
        this.energia = nThing;
        setIcon(new Bicon("drone1.png"));
        this.x = x;
        this.y=y;
        
    }
    
    public int medirDistancia(int xcarga, int ycarga){
       return xcarga - this.x  + this.y - ycarga;
       
    }
    
    public abstract void consumirEnergia();
    
    public  void cargarEnergia(int cantidad){
      if(cantidad > 0)
        this.energia +=cantidad; 
    }
    public boolean irZonaCarga(int x, int y){
      return false;
    }
}
