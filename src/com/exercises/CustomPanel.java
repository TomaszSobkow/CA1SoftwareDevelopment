package com.exercises;

import com.ca1.Shape;
import com.ca1.ShapesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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


                boolean rightMouseClick = false;
                boolean leftMouseClick = false;
                boolean middleMouseClick = false;

                int modifiers = e.getModifiersEx();
               // System.out.println("Left Click works on position {x = "+xMousePosition+" } and { y = "+ yMousePosition+" }");

                for(Shape current: shapesManager.getShapesArray()){
                    changeColor(current);
                    current.setFilled(!current.isFilled());
                }

                if((modifiers & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK){
                    xMousePosition = e.getX();
                    yMousePosition = e.getY();
                    repaint();

                    System.out.println("Left Click works on position!!!!!!!!!! {x = "+xMousePosition+" } and { y = "+ yMousePosition+" }");
                }
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
