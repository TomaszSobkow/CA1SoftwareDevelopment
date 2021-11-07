package com.ca1.quadrileteral;

import com.ca1.boundingbox.BoundingBox;
import com.ca1.point.Point;
import com.ca1.Shape;
import com.ca1.interfaces.Rotatable;
import com.ca1.rectangle.Rectangle;

import java.awt.*;
import java.util.Arrays;

public class Quadrilateral extends Shape implements Rotatable {

    private  Point[] points = new Point[5];
    Point[] newPoints = new Point[5];

    Point pointTopLeft;
    Point pointBottomRight;
    BoundingBox rectangleBoundingBox;

    public Quadrilateral(Point p1, Point rotationPoint, Point p2, Point p3, Point p4){
        super();
        /**
          This code collecting all data from the constructor to the array
         */
        points[0] = p1;
        points[1] = rotationPoint;
        points[2] = p2;
        points[3] = p3;
        points[4] = p4;
        setupBoundingBox();
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
    //
        points[0] = new Point(xPosition, yPosition);
        points[1] = new Point( ( points[0].getX()+ rectangle.getWidth() ), points[0].getY());
        points[2] = new Point( points[1].getX(),( points[1].getY()+ rectangle.getHeight()) );
        points[3] = new Point( ( points[2].getX() - rectangle.getWidth() ),points[2].getY());
        points[4] = new Point(points[0].getX(),points[0].getY());
        setupBoundingBox();
    }

    @Override
    public void rotateNinetyDegrees() {
        /**
         * Crazy calculation here !!! but it doesn't work!!!
         */
        newPoints[0] = new Point(points[0].getX(), points[0].getY());
        newPoints[1] = new Point(points[0].getX(), 2* (points[1].getX() - points[0].getX()));
        newPoints[2] = new Point((points[0].getX()+ (points[1].getX()) - points[0].getX()) /2 , newPoints[1].getY()
                        + (points[2].getY() - points[1].getY()));
        newPoints[3] = new Point( points[3].getY() - points[1].getY(), (newPoints[0].getX()+newPoints[1].getX())/2 );
        newPoints[4] = new Point((newPoints[0].getX() + newPoints[1].getX()) /2,points[4].getY() );


        points = newPoints;
        System.out.println("Rotating 90 degree");
        }


    @Override
    public void setupBoundingBox() {
        pointTopLeft = new Point(points[4].getX(), points[0].getY());
        pointBottomRight = new Point(points[2].getX(), points[3].getY());
        this.rectangleBoundingBox = new BoundingBox(pointTopLeft, pointBottomRight);
    }

    @Override
    public void drawShape(Graphics g) {

        g.setColor(this.getColor());

        /**
         These arrays have a parameters for drawPolygon() method
         */
        int[] xPosition =  new int[points.length];
        int[] yPosition =  new int[points.length];
        for(int index = 0; index < points.length; index++){
            xPosition[index] = points[index].getX();
            yPosition[index] = points[index].getY();
        }

        /**
          number of sides in a Polygon
         */
        int numberOfSides = xPosition.length;

        String className = getClass().getSimpleName();
        int xCentralPoint = points[0].getX() + 20;
        int yCentralPoint = points[2].getY() ;

            if(isFilled()){
                g.setColor(this.getColor());
                g.fillPolygon(xPosition, yPosition,numberOfSides);
            }else {
                g.setColor(this.getColor());
            }

        /**
          If ShapesManager provides the method to display the names of each shape with true parameter.
         */
        if(isNameDisplayed() && isFilled()){
            /**
              Data for proper coordinates to display the name of the class (in the middle)
             */
            g.setColor(Color.white);
            g.drawString(className, xCentralPoint, yCentralPoint);
        }

        if(isNameDisplayed()){
            g.drawString(className, xCentralPoint, yCentralPoint);
        }

        /**
          Draw a shape without name of the shape
         */
           g.drawPolygon(xPosition, yPosition,numberOfSides);

           /**
          to restore the default color to draw other shapes
         */
        g.setColor(Color.blue);

        if(isBoundingBoxDisplayed()){
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.setColor(Color.red);
            graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,
                    0, new float[]{9}, 4));
            graphics2D.drawRect(pointTopLeft.getX(),
                                pointTopLeft.getY(),
                              ( points[2].getX() - points[4].getX()), ( points[3].getY() - points[1].getY() ) );
            graphics2D.setStroke(new BasicStroke(1));
        }
    }



    @Override
    public String toString() {
        return "Quadrilateral { " +
                "Points=" + Arrays.toString(points) +
                "} \n\tBoundingBox" + rectangleBoundingBox.getTopLeft()+ rectangleBoundingBox.getBottomRight();
    }
}
