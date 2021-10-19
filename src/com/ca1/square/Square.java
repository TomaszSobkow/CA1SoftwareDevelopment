package com.ca1.square;

import com.ca1.rectangle.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends Rectangle implements ActionListener {

    private int side;

    public Square(Color color, int xCenter, int yCenter, boolean filled, int side){
        super(color, filled,xCenter, yCenter  );
        this.side = side;
    }

    public Square(int x, int y, int side){
        super(x,y);
        this.side = side;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void drawShape(Graphics g) {

        Graphics2D  graphics2D = (Graphics2D)g;
        graphics2D.setStroke(new BasicStroke(3));

        graphics2D.drawRect(this.getxCenter(), this.getyCenter(), side, side);

        String className = getClass().getSimpleName();
        int xCentralPoint = (getxCenter() +(getSide()/2));
        int yCentralPoint = (getyCenter() + (getSide()/2));

        if(isNameDisplayed()){
            graphics2D.drawString(className,xCentralPoint- 20,yCentralPoint);
            graphics2D.drawString("( MoveAble  )",xCentralPoint -30, yCentralPoint+20);
            graphics2D.setStroke(new BasicStroke(1));
        }
        graphics2D.setStroke(new BasicStroke(1));
    }

    public void changeTheLocation(){

    }

    public void changeColor(){
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);

        this.setColor(new Color(r,g,b));
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
