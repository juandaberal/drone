/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Robot;
import becker.robots.Thing;


import java.util.ArrayList;



/**
 *
 * @author Estudiante
 */
public class Cultivo extends City {
    private int ancho;
    private int alto;
    private ArrayList<Thing> objetos;
    private Drone[] drones ; 
    private Planta[][] planta = new Planta [7][7];
    
    
    public Cultivo(int ancho, int alto, String fieldtxt) {
        super (fieldtxt);
        this.alto=alto;
        this.ancho = ancho;
        this.objetos = new ArrayList<>();
        this.drones = new Drone[2];
        
        
    }

//    public Cultivo(String fieldtxt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public boolean realizarMonitoreo(double humedad, double temp){
       return false;
    }
    public int medirFertilizante(int x, int y){
    return planta[x][y].getCantFertilizante();
    
    }
    public double medirTemperatura(int x, int y){
    return planta[x][y].getTemperatura();
    
    }
    public double medirHumedad(int x, int y){
    return planta[x][y].getHumedad();
    
    }
    public boolean ponerFertilizante(int x, int y, int cantidad){
      return false;
    }
    public boolean sembrar(double humedad, double temperatura,
                           int fertilizante, int x, int y){
       this.planta[x][y] = new Planta(humedad, temperatura, fertilizante, this, x, y);
       
       
       return false;
    }
    
    public void cambiar (int x, int y){
    
        this.planta[x][y].cambiarEstado();
       }
    
    public boolean addPanel(Panel panel){
      
        return this.addPanel(panel);
    }
    
    public boolean addSembrador(Sembrador sembrador){
       
       return this.addSembrador(sembrador);
    }
    
    public boolean addMonitor(Monitor monitor){
       
       return this.addMonitor(monitor);
    }
    
    public boolean addPlanta (Planta planta){
        return this.addPlanta(planta);
    }

    public ArrayList<Thing> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<Thing> objetos) {
        this.objetos = objetos;
    }

    public Drone[] getDrones() {
        return drones;
    }

    public void setDrones(Drone[] drones) {
        this.drones = drones;
    }


    

    

     
    
    
}
