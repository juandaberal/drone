/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Thing;
import unal.poo.practica.Bicon;

/**
 *
 * @author Estudiante
 */
public class Planta extends Thing{
    
    private String[] images = {"planta1.png", "planta.png"};
    private int state;
    
    private double humedad;
    private double temperatura;
    private int cantFertilizante;
    private String color;

    public Planta(double humedad, double temperatura, int cantFertilizante, City city, int i, int i1) {
        super(city, i, i1);
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.cantFertilizante = cantFertilizante;
        this.state = 0;
        setIcon(new Bicon(this.images[this.state]));
    }
    
    public void adicionarFertilizante(int cantidad){
    
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public void cambiarColor(){
    
    }
    
     public void cambiarEstado() {
        this.state = ((this.state + 1) % 2);
        setIcon(new Bicon(this.images[this.state]));
    }

    public double getHumedad() {
        return humedad;
    }

    public double getTemperatura() {
        return temperatura;
    }


    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCantFertilizante() {
        return cantFertilizante;
    }

    public void setCantFertilizante(int cantFertilizante) {
        this.cantFertilizante = cantFertilizante;
    }



    public void setColor(String color) {
        this.color = color;
    }
    
}
