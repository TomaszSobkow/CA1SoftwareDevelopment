package com.ca1.quadrileteral;

import com.ca1.point.Point;
import com.ca1.Shape;
import com.ca1.interfaces.Rotatable;
import com.ca1.rectangle.Rectangle;

import java.awt.*;
import java.util.Arrays;

public class Quadrilateral extends Shape implements Rotatable {

    private  Point[] points =new Point[5];

    public Quadrilateral(Point centerPoint, Point[] points) {
        super();

    }

    public Quadrilateral(Point p1, Point rotationPoint, Point p2, Point p3, Point p4){
        super();
        //this.points =new Point[5];
       
        /*
          This code collecting all data from the constructor to an array
         */
        points[0] = p1;
        points[1] = rotationPoint;
        points[2] = p2;
        points[3] = p3;
        points[4] = p4;
    }

    public Quadrilateral(Rectangle rectangle){
        int xPosition ;
        int yPosition ;
        if(rectangle.getyCenter() == 0 || rectangle.getxCenter() == 0){
            xPosition = 300;
            yPosition = 300;
        }else {
            xPosition = rectangle.getxCenter();
            yPosition = rectangle.getyCenter();
        }

        points[0] = new Point(xPosition, yPosition);
        points[1] = new Point(points[0].getX()+ rectangle.getWidth(), points[0].getY());
        points[2] = new Point(points[1].getX(),points[1].getY()+ rectangle.getHeight());
        points[3] = new Point(points[2].getX() - rectangle.getWidth(),points[2].getY());
        points[4] = new Point(points[0].getX(),points[0].getY());
    }

    public Quadrilateral(){
        super();
    }

    @Override
    public void drawShape(Graphics g) {

        Graphics2D graphics2D = (Graphics2D)g;
       // g.setColor(new Color(128, 128, 18));
        g.setColor(this.getColor());

        /*
         These arrays have a parameters for drawPolygon() method
         */
        int[] xPosition =  new int[5];
        int[] yPosition =  new int[5];
        for(int index = 0; index < points.length; index++){
            xPosition[index] = points[index].getX();
            yPosition[index] = points[index].getY();
        }
        /*
          number of sides in my Polygon
         */
        int numberOfSides = xPosition.length;
        String className = getClass().getSimpleName();
        int xCentralPoint = points[0].getX() + 20;
        int yCentralPoint = points[2].getY() ;

            if(isFilled()){
                g.setColor(this.getColor());
                graphics2D.fillPolygon(xPosition, yPosition,numberOfSides);
            }else {
                g.setColor(this.getColor());
            }

        /*
          If ShapesManager provides the method to display the names of each shape with true parameter.
         */
        if(isNameDisplayed() && isFilled()){
            /*
              Data for proper coordinates to display the name of the class
             */
            graphics2D.setColor(Color.white);
            graphics2D.setStroke(new BasicStroke(3));
            graphics2D.drawString(className, xCentralPoint, yCentralPoint);
            graphics2D.setStroke(new BasicStroke(1));
        }

        if(isNameDisplayed()){
            g.drawString(className, xCentralPoint, yCentralPoint);
        }

        /*
          Draw a shape without name of the shape
         */
           graphics2D.setStroke(new BasicStroke(3));
           graphics2D.drawPolygon(xPosition, yPosition,numberOfSides);
           graphics2D.setStroke(new BasicStroke(1));

           /*
          to restore the color to draw other shapes
         */
        g.setColor(Color.blue);
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
