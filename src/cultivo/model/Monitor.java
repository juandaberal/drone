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
public class Monitor extends Drone{
    private String tipoCamara;

    public Monitor(String tipoCamara, City city, int x, int y, Direction direccion, int nThing) {
        super(city, x, y, direccion, nThing);
        this.tipoCamara = tipoCamara;
        setIcon(new Bicon("drone.png"));
    }
    
    public int realizarMonitoreo(double humedad, double temp,
                                int x, int y){
       return 0;
    }
    
    public int medirFertilizante(int cantFertilizante, int x, int y){
      return 0;
    }
    public boolean ponerFertilizante(int x, int y, int cantidad){
      return false;
    }

    @Override
    public void consumirEnergia() {
        this.energia--;
        
    }
    
}
