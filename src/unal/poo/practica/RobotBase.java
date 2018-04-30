package unal.poo.practica;

import becker.robots.*;

import cultivo.model.Cultivo;
import cultivo.model.Drone;
import cultivo.model.Monitor;
import cultivo.model.Panel;
import cultivo.model.Sembrador;
import java.awt.Color;

import java.util.Random;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
        
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static Cultivo objetos;
        public static Robot monitor,sembrador;
        public static Random random = new Random();
//        int A = 40 + random.nextInt(47);
        
	public static void main (String[] args) throws InterruptedException{
            //Declarar la creacion de la ciudad
            objetos = new Cultivo(0, 0,"Field.txt" );
            objetos.showThingCounts(true);
           
           //int A = random.nextInt(7)+40;
//Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            monitor = new Monitor("dodo", objetos, 0, 1, Direction.EAST, 0/*energia*/);
            sembrador= new Sembrador(0, objetos, 0, 0, Direction.SOUTH, 15);
            
            Panel panel = new Panel(objetos, 6, 6);
	    //Mover una interseccion en el sentido al cual este apuntando el objeto.
            
            System.out.println("cantidad de semillas es de : ");
            //System.out.print(A);
//            Thing t = monitor.examineThings(new FlorPred()).next();
//            if(t instanceof Flor){
//               monitor.pickThing();
//            }

           
            

            
            
            while(sembrador.getStreet() != panel.getX() && sembrador.getAvenue() != panel.getY()){
                
                if(sembrador.getEnergia() > 11){
                    int i=0;
                    
                    if(sembrador.frontIsClear()==false){
                        if(i%2==0){
                        sembrador.giroUIzquierda();
                        i++;
                        }
                    }
                    else{
                        sembrador.giroUDerecha();
                        i++;
                    }
                    sembrador.movimientoDron();
                    if(sembrador.canPickThing()==false){
                        if(sembrador.getSemillas()>0){
                            //configurar los random
                            objetos.sembrar(random, ramdom, ramdom, sembrador.getStreet(), sembrador.getAvenue());
                        }
                    }
                }
                if(sembrador.getEnergia() >= sembrador.medirDistancia()){
                    int xCopia = sembrador.getStreet();
                    int yCopia = sembrador.getAvenue();
                    sembrador.irZonaCarga();
                    sembrador.volver(xCopia, yCopia);
                }
                else System.out.println("No hay energía suficiente para hacer recarga");
                break;
                               
            }
              
            
	}
        
        
        
}

