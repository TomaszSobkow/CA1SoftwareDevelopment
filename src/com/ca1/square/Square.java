package com.ca1.square;

import com.ca1.boundingbox.BoundingBox;
import com.ca1.interfaces.Moveable;
import com.ca1.point.Point;
import com.ca1.rectangle.Rectangle;
import com.shapeapp.CustomPanel;

import java.awt.*;

public class Square extends Rectangle implements Moveable {

    private int side;
    private CustomPanel customPanel;

    public Square(Color color,  boolean filled, int xCenter, int yCenter, int side){
        super(color, filled, xCenter, yCenter );
        this.side = side;
        setupBoundingBox();
    }

    /**
     * Moving square up to 10 pixels plus tracking the position of mouse pointer
     */
    @Override
    public void moveTenUnits() {
        int moveInPixels = 10;
        this.setColor( super.getColor());
        this.setFilled( super.isFilled());
        this.setxCenter( super.getxCenter());
        this.setyCenter( super.getyCenter());
        this.side = getSide();
    }

    @Override
    public void setupBoundingBox() {
        super.shapeBoundingBox = new BoundingBox(new Point(super.getxCenter(), super.getyCenter()),
                                            new Point(this.getSide(), this.getSide()));
    }

    @Override
    public void drawShape(Graphics g) {

        String className = getClass().getSimpleName();
        int xCentralPoint = (super.getxCenter() +(this.getSide()/2));
        int yCentralPoint = (super.getyCenter() + (this.getSide()/2));

        /**
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
            graphics2D.drawRect(super.getxCenter(),super.getyCenter(),
                    this.getSide (), this.getSide());
            graphics2D.setStroke(new BasicStroke(1));
        }
    }

    @Override
    public String toString() {
        return "Square { " +
                "side = " + side +
                " }\n\t  BoundingBox "+ super.shapeBoundingBox.getTopLeft()+""+ super.shapeBoundingBox.getBottomRight();
    }

    public int getSide() {
        return side;
    }
    public void setSide(int side) {
        this.side = side;
    }
}
