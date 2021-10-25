package com.ca1.rectangle;

import com.ca1.Shape;
import com.ca1.interfaces.Moveable;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class Rectangle extends Shape implements Moveable {

    private int width;
    private int height;

    public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super(color, filled, xCenter, yCenter);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Color color, boolean filled, int xCenter, int yCenter) {
        super(color, filled, xCenter, yCenter);
    }

    public Rectangle(int width, int height){
        super(Color.red,0,0);
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(Graphics g) {

        String className = getClass().getSimpleName();
        int xCentralPoint = (getxCenter() +(getWidth()/2));
        int yCentralPoint = (getyCenter() + (getHeight()/2));
        g.setColor(this.getColor());



        if(isFilled()){
            g.fillRect(this.getxCenter(),this.getyCenter(),this.getWidth(),this.getHeight());
        }else {
            g.setColor(this.getColor());
        }

        /*
          The name of rectangle shape is displayed here
         */
        if(isNameDisplayed() && isFilled()){
            g.setColor(Color.white);
            g.drawString(className,xCentralPoint- 20,yCentralPoint);
            g.drawString("( Rotatable  )",xCentralPoint -30, yCentralPoint+20);
        }

        if(isNameDisplayed()){
            g.drawString(className, xCentralPoint -20, yCentralPoint);
            g.drawString("( Rotatable  )",xCentralPoint -30, yCentralPoint+20);

        }
        g.drawRect(this.getxCenter(),this.getyCenter(),this.getWidth(),this.getHeight());
    }

    @Override
    public void moveTenUnits() {

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                " width = " + width +
                ", height = " + height +
                '}';
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}
