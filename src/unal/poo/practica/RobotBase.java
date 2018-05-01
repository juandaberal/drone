package unal.poo.practica;

import becker.robots.*;

import cultivo.model.Cultivo;
import cultivo.model.Drone;
import cultivo.model.Monitor;
import cultivo.model.Panel;
import cultivo.model.Sembrador;
import java.awt.Color;

import java.util.Random;
import java.util.Scanner;

/**
 * Practica de los conceptos de Programacion Estructurada
 *
 * @author Fabian Andres Giraldo
 */
public class RobotBase {
    //Declaracion de Variables -- Forma temporal - No es buena practica tener
    //variables estaticas

    public static Cultivo objetos;
    public static Robot monitor, sembrador;
    public static Random random = new Random();
//        int A = 40 + random.nextInt(47);

    public static void main(String[] args) throws InterruptedException {
        //Declarar la creacion de la ciudad
        objetos = new Cultivo(0, 0, "Field.txt");
        objetos.showThingCounts(true);
        Scanner s = new Scanner(System.in);
        System.out.println("escriba cantidad de fertilizante optimo");
        int f = s.nextInt();
        System.out.println("escriba cantidad de humedad optimo");
        int h = s.nextInt();
        System.out.println("escriba cantidad de temperatura optimo");
        int t = s.nextInt();

        int rf = random.nextInt(1) + f;
        int rh = random.nextInt(1) + h;
        int rt = random.nextInt(1) + t;

//Direction.NORTH, EAST, SOUTH, WEST
        //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
        Monitor monitor = new Monitor("dodo", objetos, 0, 6, Direction.WEST, 100/*energia*/);
        Sembrador sembrador = new Sembrador(10, objetos, 0, 0, Direction.SOUTH, 100);

        Panel panel = new Panel(objetos, 6, 6);
        //Mover una interseccion en el sentido al cual este apuntando el objeto.

        System.out.println("cantidad de semillas es de : " + sembrador.getSemillas());

        sembrador.setSemillas(1000);

        System.out.println(" xD LOL " + sembrador.medirDistancia());

        while (sembrador.getStreet() != panel.getX() || sembrador.getAvenue() != panel.getY()
                && sembrador.getEnergia() > 0) {
            rf = random.nextInt(2) + f;
            rh = random.nextInt(2) + h;
            rt = random.nextInt(2) + t;
            if (sembrador.getEnergia() > sembrador.medirDistancia()) {

                System.out.println("cord X " + sembrador.getStreet());

                if (sembrador.frontIsClear() == false) {
                    System.out.println("hay una pared");

                    objetos.sembrar(rh, rt, rf, sembrador.getStreet(), sembrador.getAvenue());

                    if ((sembrador.getAvenue() % 2) == 0) {

                        sembrador.giroUIzquierda();

                    } else {
                        sembrador.giroUDerecha();

                    }
                }
                if (sembrador.canPickThing() == false) {
                    System.out.println("no hay planta");
                    if (sembrador.getSemillas() > 0) {
                        //configurar los random
                        System.out.println("se puede sembrar");
                        objetos.sembrar(rh, rt, rf, sembrador.getStreet(), sembrador.getAvenue());
                        System.out.println("hey!" + sembrador.getStreet() + " " + sembrador.getAvenue());
                    }

                    sembrador.movimientoDron();

                }

                //sembrar          
//                    System.out.println("Energia: " + sembrador.getEnergia());
            } //proceso cuando toca recargar
            else {
                if (sembrador.getEnergia() <= sembrador.medirDistancia()) {
                    System.out.println("toca recargar");
                    int xCopia = sembrador.getStreet();
                    int yCopia = sembrador.getAvenue();
                    System.out.println(" xD LOL " + sembrador.medirDistancia());

                    if (sembrador.getStreet() % 2 != 0) {
                        System.out.println("le toca devolverse");
                        sembrador.turnBack();
                    }
                    while (sembrador.cargarEnergia() == false && sembrador.getEnergia() > 0) {
                        if (sembrador.frontIsClear() == false) {
                            System.out.println("hay una pared");
                            sembrador.turnLeft();
                        }
                        sembrador.movimientoDron();
                    }
                    sembrador.volver(xCopia, yCopia);
                } else {
                    System.out.println("No hay energía suficiente para hacer recarga");
                    break;
                }
            }

        }
// MOVIMIENTO DE MONITOR
//o ooooooo oo oo o o o o o o o o o o
//ooooooooo  o o o o oo  o o o o oo o  :) :D TnT *O* 7u7



        while (monitor.getStreet() != panel.getX() || monitor.getAvenue() != panel.getY()
                && monitor.getEnergia() > 0) {

            if (monitor.getEnergia() > monitor.medirDistancia()) {

                System.out.println("cord X " + monitor.getAvenue());

                if (monitor.frontIsClear() == false) {
                    System.out.println("hay una pared");
                    if ( objetos.medirHumedad(monitor.getStreet(), monitor.getAvenue()) != h || objetos.medirTemperatura(monitor.getStreet(), monitor.getAvenue()) != t) {
                        System.out.println("cambiarcolor");
                        objetos.cambiar(monitor.getStreet(), monitor.getAvenue());

                    }

                    if ((monitor.getStreet() % 2) == 0) {

                        monitor.giroUIzquierda();

                    } else {
                        monitor.giroUDerecha();

                    }
                }

                if ( objetos.medirHumedad(monitor.getStreet(), monitor.getAvenue()) != h || objetos.medirTemperatura(monitor.getStreet(), monitor.getAvenue()) != t) {
                    System.out.println("cambiarcolor");
                    objetos.cambiar(monitor.getStreet(), monitor.getAvenue());
                    monitor.movimientoDron();

                } else {
                    monitor.movimientoDron();
                }

                //sembrar    
                
                
                
                
//                esto es la copia de sembrador como no funciona con sembrador tampoco lo hara con monitor :V asi que esto lo fue l copy page por eso no cambie sembrador por mnitor
//                        solo es el copy paste como dije ante asi que esto ignorelo, arreglerlo con la funcion y me dice :)



//                    System.out.println("Energia: " + sembrador.getEnergia());
            } //proceso cuando toca recargar
            else {
                if (sembrador.getEnergia() <= sembrador.medirDistancia()) {
                    System.out.println("toca recargar");
                    int xCopia = sembrador.getStreet();
                    int yCopia = sembrador.getAvenue();
                    System.out.println(" xD LOL " + sembrador.medirDistancia());

                    if (sembrador.getStreet() % 2 != 0) {
                        System.out.println("le toca devolverse");
                        sembrador.turnBack();
                    }
                    while (sembrador.cargarEnergia() == false && sembrador.getEnergia() > 0) {
                        if (sembrador.frontIsClear() == false) {
                            System.out.println("hay una pared");
                            sembrador.turnLeft();
                        }
                        sembrador.movimientoDron();
                    }
                    sembrador.volver(xCopia, yCopia);
                } else {
                    System.out.println("No hay energía suficiente para hacer recarga");
                    break;
                }
            }

        }

    }

}
