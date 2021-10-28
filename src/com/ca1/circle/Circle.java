package com.ca1.circle;

import com.ca1.Shape;
import com.ca1.boundingbox.BoundingBox;
import com.ca1.point.Point;

import java.awt.*;

public class Circle extends Shape {

    private int radius;

    BoundingBox circleBoundingBox;

    public Circle(Color color, int xCenter, int yCenter, int radius) {
        super(color, xCenter, yCenter);
        this.radius = radius;
        setupBoundingBox();
    }

    public void setupBoundingBox(){
     this.circleBoundingBox = new BoundingBox(new Point(super.getxCenter(),super.getyCenter()) ,
                                              new Point(super.getxCenter()+ getRadius(), super.getyCenter()+ getRadius()));
    }

    /**
     * This method draw a circle and provides the name of the proper shape
     * It's also responsible for the title of assignment
     */
     @Override
    public void drawShape(Graphics g) {
         String className = getClass().getSimpleName();
         int xCentralPoint = (super.getxCenter() +(this.getRadius() /2 ));
         int yCentralPoint = (super.getyCenter() + (this.getRadius() /2 ));

         /*
           The oval is drawing here
          */
         g.setColor(this.getColor());
         g.drawOval(super.getxCenter(), super.getyCenter(), this.getRadius(), this.getRadius());

         if(isFilled()){
             g.fillOval(super.getxCenter(), super.getyCenter(), this.getRadius(), this.getRadius());
         }

         /*
           The name of circle shape is displayed here
          */
         if(isFilled() && isNameDisplayed()){
             g.setColor(Color.white);
             g.drawString(className,xCentralPoint,yCentralPoint);
         }

         if(isNameDisplayed()){
             g.drawString(className,xCentralPoint,yCentralPoint);
         }

         /**
          * To display BoundingBox on each Shape
          */
         if(isBoundingBoxDisplayed()){
             Graphics2D graphics2D = (Graphics2D)g;
             graphics2D.setColor(Color.red);
             graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,
                     0, new float[]{9}, 4));
             graphics2D.drawRect(super.getxCenter(),super.getyCenter(),
                     getRadius(), getRadius());
             graphics2D.setStroke(new BasicStroke(1));
         }

         /*
           The title of assignment is here
          */
         g.setColor(Color.BLACK);
         g.drawString("Ca1 Software Development\n Tomas Sobkow",50,50);
     }

    @Override
    public String toString() {
        return "Circle {" +
                " radius = " + radius +
                '}' +"BoundingBox "+ circleBoundingBox.getTopLeft()+""+circleBoundingBox.getBottomRight();
    }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
}
