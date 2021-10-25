package com.ca1.circle;

import com.ca1.Shape;

import java.awt.*;

public class Circle extends Shape {

    private int radius;

    public Circle(Color color, int xCenter, int yCenter, int radius) {
        super(color, xCenter, yCenter);
        this.radius = radius;

    }

    /**
     * This method draw a circle and provides the name of the proper shape
     * It's also responsible for the title of assignment
     */
     @Override
    public void drawShape(Graphics g) {
         String className = getClass().getSimpleName();
         int xCentralPoint = ( getxCenter() +(getRadius() /2 ));
         int yCentralPoint = ( getyCenter() + (getRadius() /2 ));

         /*
           The oval is drawing here
          */
         g.setColor(this.getColor());
         g.drawOval(getxCenter(), getyCenter(), getRadius(), getRadius());

         if(isFilled()){
             g.fillOval(getxCenter(), getyCenter(), getRadius(), getRadius());
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

         /*
           The title of assignment is here
          */
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        g.drawString("Ca1 Software Development\n Tomas Sobkow",50,50);
    }

    @Override
    public String toString() {
        return "Circle{" +
                " radius = " + radius +
                '}';
    }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
}
