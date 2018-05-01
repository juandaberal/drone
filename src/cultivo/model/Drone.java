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
    private int copiaEnergia;
    

    public Drone(City city, int x, int y, Direction direccion, int nThing) {
        super(city, x, y, direccion, nThing);
        this.energia = nThing;
        setIcon(new Bicon("drone1.png"));
        this.x = x;
        this.y=y;
        copiaEnergia = energia;
        
    }
    
    public int medirDistancia(){
       return (7 - this.getStreet())  + ( 7 - this.getAvenue());
       
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        if(this.getEnergia()>0){
            this.move();
            this.energia--;
           
        }        
        System.out.println("ENERGIA = " + this.getEnergia());
               
    }
    
    public void giroUIzquierda(){
        this.turnLeft();
        movimientoDron();
        this.turnLeft();
    }
    
    public void giroUDerecha(){
        this.turnRight();
        movimientoDron();
        this.turnRight();
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

    public int getCopiaEnergia() {
        return copiaEnergia;
    }

    public void setCopiaEnergia(int copiaEnergia) {
        this.copiaEnergia = copiaEnergia;
    }
    
    

}
