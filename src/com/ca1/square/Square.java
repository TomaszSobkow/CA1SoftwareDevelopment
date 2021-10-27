package com.ca1.square;

import com.ca1.rectangle.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends Rectangle {

    private int side;

    public Square(Color color,  boolean filled, int xCenter, int yCenter, int side){
        super(color, filled, xCenter, yCenter );
        this.side = side;
    }

    @Override
    public void drawShape(Graphics g) {
        /*
          Graphics2D I'm using to draw this shape with ticker line
         */
        Graphics2D  graphics2D = (Graphics2D)g;
        graphics2D.setStroke(new BasicStroke(3));

        String className = getClass().getSimpleName();
        int xCentralPoint = (getxCenter() +(getSide()/2));
        int yCentralPoint = (getyCenter() + (getSide()/2));

        /*
          Adding the  name of the shape to the shape already created  if parameter is true
          setStroke() method change size of the pen to default size for other shapes.
         */
        if(isFilled()){
            graphics2D.setColor(this.getColor());
            graphics2D.fillRect(this.getxCenter(), this.getyCenter(), side, side);
        }else {
            graphics2D.setColor(this.getColor());
        }
        if(isNameDisplayed() && isFilled()){
            graphics2D.setColor(Color.white);
            graphics2D.drawString(className,xCentralPoint- 20,yCentralPoint);
            graphics2D.drawString("( MoveAble  )",xCentralPoint -30, yCentralPoint+20);
            graphics2D.setStroke(new BasicStroke(1));
        }

        if(isNameDisplayed()){

            graphics2D.drawString(className,xCentralPoint- 20,yCentralPoint);
            graphics2D.drawString("( MoveAble  )",xCentralPoint -30, yCentralPoint+20);
            graphics2D.setStroke(new BasicStroke(1));
        }
        graphics2D.setColor(this.getColor());
        graphics2D.drawRect(this.getxCenter(), this.getyCenter(), side, side);
    }

    @Override
    public String toString() {
        return "Square{ " +
                "side = " + side +
                " } ";
    }

    public int getSide() {
        return side;
    }
    public void setSide(int side) {
        this.side = side;
    }
}
