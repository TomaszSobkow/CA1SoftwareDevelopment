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
        g.setColor(this.getColor());
        g.drawRect(this.getxCenter(),this.getyCenter(),this.getWidth(),this.getHeight());

        /**
         * The name of rectangle shape is displayed here
         */
        if(isNameDisplayed()){
            String className = getClass().getSimpleName();

            int xCentralPoint = (getxCenter() +(getWidth()/2));
            int yCentralPoint = (getyCenter() + (getHeight()/2));
            g.drawString(className, xCentralPoint -25, yCentralPoint);
        }
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
