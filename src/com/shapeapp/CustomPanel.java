package com.shapeapp;

import com.ca1.Shape;
import com.ca1.ShapesManager;
import com.ca1.quadrileteral.Quadrilateral;
import com.ca1.square.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CustomPanel extends JPanel {
    int xMousePosition ;
    int yMousePosition ;

    private ShapesManager shapesManager;


    public CustomPanel(ShapesManager shapesManager){
     this.shapesManager = shapesManager;
        createMouseListener();
    }

    public void createMouseListener(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                xMousePosition = e.getX();
                yMousePosition = e.getY();

                int modifiers = e.getModifiersEx();

                for(Shape current: shapesManager.getShapesArray()){
                    changeColor(current);
                    current.setFilled(!current.isFilled());

                    /**
                     * New coordinates for square are created here including position of mouse pointer
                     */
                    if((modifiers & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK){
                            if (current instanceof Square){
                                current.setxCenter(xMousePosition);
                                current.setyCenter(yMousePosition);
                                ((Square)current).moveTenUnits();
                                repaint();
                            }
                    }

                    if((modifiers & InputEvent.BUTTON3_DOWN_MASK) == InputEvent.BUTTON3_DOWN_MASK){
                        if (current instanceof Quadrilateral){
                            ((Quadrilateral) current).rotateNinetyDegrees();
                            repaint();
                        }
                    }
                }
                System.err.println("Left click {x = "+xMousePosition+" } and { y = "+ yMousePosition+" }");

            }
        }); // End addMouseListener
    }

    public void changeColor(Shape shapeToChangeColor){
        int red = (int)(Math.random()* 256);
        int green = (int)(Math.random()* 256);
        int blue = (int)(Math.random()* 256);
        shapeToChangeColor.setColor(new Color(red,green,blue));
    }
    /**
     * This method is critically important to draw any shape
     * @param g
     * It has to be Override with the same name and arguments
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }
}
