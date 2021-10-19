package com.ca1.quadrileteral;

import com.ca1.point.Point;
import com.ca1.Shape;
import com.ca1.interfaces.Rotatable;
import com.ca1.rectangle.Rectangle;

import java.awt.*;
import java.util.Arrays;

public class Quadrilateral extends Shape implements Rotatable {

    private Point[] points;

    public Quadrilateral(Point centerPoint, Point[] points) {
        super();
        this.points = points;
    }

    public Quadrilateral(Point centralPoint, Point p1, Point p2, Point p3, Point p4){
        //p1= new Point();

    }

    public Quadrilateral(Rectangle rectangle){    }
    public Quadrilateral(){
        super();
    }

    @Override
    public void drawShape(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(new Color(128, 128, 18));
      // graphics2D.drawPolygon();

//        int numberOfSides = 5;
//        int[] xPosition = new int[numberOfSides];
//        int[] yPosition = new int[numberOfSides];
//
//        for(int side =0; side < numberOfSides; side++){
//            xPosition[side] = (int)(Math.random() * 2000) +3;
//            yPosition[side] = (int)(Math.random() * 2000)+ 5;
//        }

       g.setColor(Color.blue);
       //g.drawPolygon(this);
    }

    @Override
    public void rotateNinetyDegrees() {

    }

    @Override
    public String toString() {
        return "Quadrilateral{" +
                "points=" + Arrays.toString(points) +
                "} " + super.toString();
    }
}
