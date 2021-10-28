package com.ca1.square;

import com.ca1.boundingbox.BoundingBox;
import com.ca1.point.Point;
import com.ca1.rectangle.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends Rectangle {

    private int side;
    BoundingBox boundingBox;



    public Square(Color color,  boolean filled, int xCenter, int yCenter, int side){
        super(color, filled, xCenter, yCenter );
        this.side = side;
        setupBoundingBox();
    }

    @Override
    public void setupBoundingBox() {
        this.boundingBox = new BoundingBox(new Point(super.getxCenter(), super.getyCenter()),
                                            new Point(this.getSide(), this.getSide()));
    }

    @Override
    public void drawShape(Graphics g) {

        String className = getClass().getSimpleName();
        int xCentralPoint = (super.getxCenter() +(this.getSide()/2));
        int yCentralPoint = (super.getyCenter() + (this.getSide()/2));

        /*
          Adding the  name of the shape to the shape already created  if parameter is true
          setStroke() method change size of the pen to default size for other shapes.
         */
        if(isFilled()){
            g.setColor(this.getColor());
            g.fillRect(this.getxCenter(), this.getyCenter(), side, side);
        }else {
            g.setColor(this.getColor());
        }
        if(isNameDisplayed() && isFilled()){
            g.setColor(Color.white);
            g.drawString(className,xCentralPoint- 20,yCentralPoint);
            g.drawString("( MoveAble  )",xCentralPoint -30, yCentralPoint+20);
        }

        if(isNameDisplayed()){
            g.drawString(className,xCentralPoint- 20,yCentralPoint);
            g.drawString("( MoveAble  )",xCentralPoint -30, yCentralPoint+20);
        }
        g.setColor(this.getColor());
        g.drawRect(this.getxCenter(), this.getyCenter(), side, side);

        if(isBoundingBoxDisplayed()){
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.setColor(Color.red);
            graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,
                    0, new float[]{9}, 4));
            graphics2D.drawRect(super.getxCenter()-1,super.getyCenter()-1,
                    this.getSide ()+2, this.getSide()+2);
            graphics2D.setStroke(new BasicStroke(1));
        }
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
