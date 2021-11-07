package com.ca1.rectangle;

import com.ca1.Shape;
import com.ca1.boundingbox.BoundingBox;;
import com.ca1.point.Point;

import java.awt.*;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super(color, filled, xCenter, yCenter);
        this.width = width;
        this.height = height;
        setupBoundingBox();
    }

    public Rectangle(Color color, boolean filled, int xCenter, int yCenter) {
        super(color, filled, xCenter, yCenter);
    }
    public Rectangle(int width, int height){
        super(Color.red,0,0);
        this.width = width;
        this.height = height;
        setupBoundingBox();
    }

    @Override
    public void setupBoundingBox() {
        super.shapeBoundingBox = new BoundingBox(new Point(super.getxCenter(),super.getyCenter()),
                                           new Point(getWidth(), getHeight()));
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

        /**
          The name of rectangle shape is displayed here
         */
        if(isNameDisplayed() && isFilled()){
            g.setColor(Color.white);
            g.drawString(className,xCentralPoint- 20,yCentralPoint);
           //g.drawString("( Rotatable  )",xCentralPoint -30, yCentralPoint+20);
        }

        if(isNameDisplayed()){
            g.drawString(className, xCentralPoint -20, yCentralPoint);
           // g.drawString("( Rotatable  )",xCentralPoint -30, yCentralPoint+20);

        }
        g.drawRect(this.getxCenter(),this.getyCenter(),this.getWidth(),this.getHeight());
        if(isBoundingBoxDisplayed()){
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.setColor(Color.red);
            graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,
                    0, new float[]{9}, 4));
            graphics2D.drawRect(super.getxCenter(),super.getyCenter(),
                    getWidth(), getHeight());
            graphics2D.setStroke(new BasicStroke(1));
        }
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                " width = " + width +
                ", height = " + height +
                '}' +"\n\t BoundingBox " + shapeBoundingBox.getTopLeft() + shapeBoundingBox.getBottomRight();
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}
