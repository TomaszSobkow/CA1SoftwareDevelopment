package com.ca1;

import com.ca1.boundingbox.BoundingBox;
import java.awt.*;

public abstract class Shape {

    private Color color;
    private boolean filled;
    private int xCenter, yCenter;

    protected BoundingBox shapeBoundingBox;

    private boolean isNameDisplayed;
    private boolean isBoundingBoxDisplayed;

    public Shape(Color color, boolean filled, int xCenter, int yCenter) {
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public Shape(Color color, int xCenter, int yCenter) {
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;

    }

    public Shape(int xCenter, int yCenter){
        this(Color.BLACK,xCenter,yCenter);
        this.filled = false;
    }

    public Shape(){
        this(0,0);
    }

    public abstract void drawShape(Graphics g);
    public abstract void setupBoundingBox();

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

    public boolean isBoundingBoxDisplayed() { return isBoundingBoxDisplayed; }
    public void setBoundingBoxDisplayed(boolean boundingBoxDisplayed) { isBoundingBoxDisplayed = boundingBoxDisplayed; }

    public BoundingBox getShapeBoundingBox() { return shapeBoundingBox; }
    public void setShapeBoundingBox(BoundingBox shapeBoundingBox) { this.shapeBoundingBox = shapeBoundingBox; }
}
