package unal.poo.practica;

import becker.robots.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import cultivo.model.Cultivo;

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
           
           int A = random.nextInt(7)+40;
//Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            monitor = new Drone1(0, objetos, 0, 1, Direction.EAST, 0);
            sembrador= new Drone0 ("dodo", objetos, 0, 0, Direction.EAST, 0);
            Flor flor = new Flor(1, 1, 1, objetos, 1, 1);
            Solar solar = new Solar(objetos, 0, 6);
	    //Mover una interseccion en el sentido al cual este apuntando el objeto.
            monitor.move ();
            System.out.println("cnatidad de semillas es de : ");
            System.out.print(A);
//            Thing t = monitor.examineThings(new FlorPred()).next();
//            if(t instanceof Flor){
//               monitor.pickThing();
//            }
            
            sembrador.putThing(flor);
            sembrador.move();
            sembrador.putThing(flor);
            sembrador.move();
            
            sembrador.putThing(flor);
            sembrador.move();
            sembrador.putThing(flor);
            sembrador.move();
            sembrador.putThing(flor);
            sembrador.move();
            monitor.move();
            monitor.move();
            monitor.move();
            turnRight();
            monitor.move();
            monitor.move();
            monitor.move();
            monitor.move();
            monitor.move();
            monitor.move();
            
            
//            solar.cambiarEstado();
//            Thread.sleep(500);
//            solar.cambiarEstado();
           
            
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                monitor.move();
        }
        
        public static void turnRight(){
            for (int i = 0; i < 3; i++) 
                monitor.turnLeft();
        }
        public static void turnBack(){
            for (int i = 0; i < 2; i++) 
                monitor.turnLeft();
        }
}

