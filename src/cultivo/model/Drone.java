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
import static unal.poo.practica.RobotBase.sembrador;

/**
 *
 * @author Estudiante
 */
public class Drone extends Robot{
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
    
    public int medirDistancia(){
       return (6 - this.getStreet())  + ( 6 - this.getAvenue());
       
    }
    
       
    public void turnRight(){
            for (int i = 0; i < 3; i++) 
                this.turnLeft();
    }
    
    public void turnBack(){
            for (int i = 0; i < 2; i++) 
                this.turnLeft();
    }
    
    public void movimientoDron(){
        this.move();
        this.energia--;
    }
    
    public void giroUIzquierda(){
        this.turnLeft();
        movimientoDron();
        this.turnLeft();
    }
    
    public void giroUDerecha(){
        this.turnLeft();
        movimientoDron();
        this.turnLeft();
    }
    
    public  boolean cargarEnergia(){
      //configurar para panel solar
        return false;
    }
    
    public void irZonaCarga(){
        if(this.getStreet()%2 != 0){
            this.turnBack();
        }
        while(this.cargarEnergia()==false){
            if(this.frontIsClear()==false){
                this.turnLeft();
            }
            this.movimientoDron();
        }
    }
    
    public void volver(int x, int y){
      if(x!=6){
          this.turnLeft();
      }
      else{
          this.turnBack();
          for(int i=0; i<6-x; i++){
              this.movimientoDron();
          }
          this.turnRight();
      }
      
      for(int i=0; i<y; i++){
          this.movimientoDron();
      }
      this.turnRight();
      
    }


}
