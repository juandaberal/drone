/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultivo.model;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.icons.Icon;
import unal.poo.practica.Bicon;

/**
 *
 * @author Estudiante
 */
public class Panel extends Thing{
    
    private int x;
    private int y;

    public Panel(City city, int i, int i1) {
        super(city, i, i1);
        setIcon(new Bicon("solar.png"));
        this.x = i;
        this.y = i1;
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

    
    
}
