package com.ca1;

import java.awt.*;

//The Shape abstract class it is a pattern for all classes inherits from it.

public abstract class Shape {

    private Color color;
    private boolean filled;
    private int xCenter, yCenter;

    private boolean isNameDisplayed;

    public Shape(Color color, boolean filled, int xCenter, int yCenter) {
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public Shape(Color color, int xCenter, int yCenter) {
        this(new Color(162, 124, 208),false,xCenter, yCenter);
    }

    public Shape(int xCenter, int yCenter){
        this(Color.BLACK,xCenter,yCenter);
        this.filled = false;
    }

    public Shape(){
        this(50,60);
    }

    public abstract void drawShape(Graphics g);

    @Override
    public String toString() {
        return "Shape{" +
                "color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }

    public int getxCenter() { return xCenter; }
    public void setxCenter(int xCenter) { this.xCenter = xCenter; }

    public int getyCenter() {
        return yCenter;
    }
    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public boolean isNameDisplayed() { return isNameDisplayed; }
    public void setNameDisplayed(boolean nameDisplayed) { isNameDisplayed = nameDisplayed; }
}
