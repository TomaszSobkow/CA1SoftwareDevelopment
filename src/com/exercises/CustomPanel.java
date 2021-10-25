package com.exercises;

import com.ca1.ShapesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomPanel extends JPanel {

    private ShapesManager shapesManager;

    public CustomPanel(ShapesManager shapesManager){
     this.shapesManager = shapesManager;

     addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
             super.mousePressed(e);
             int xMousePosition = 0;
             int yMousePosition = 0;

             boolean rightMouseClick = false;
             boolean leftMouseClick = false;
             boolean middleMouseClick = false;

            int modifiers = e.getModifiersEx();

            if((modifiers & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK){
                xMousePosition = e.getX();
                yMousePosition = e.getY();
                leftMouseClick = true;

                System.out.println("Left Click works on position {x = "+xMousePosition+" } and { y = "+ yMousePosition+" }");
            }

             if((modifiers & InputEvent.BUTTON2_DOWN_MASK) == InputEvent.BUTTON2_DOWN_MASK){
                 xMousePosition = e.getX();
                 yMousePosition = e.getY();
                 leftMouseClick = true;

                 System.out.println("Middle Click works on position {x = "+xMousePosition+" } and { y = "+ yMousePosition+" }");
             }

             if((modifiers & InputEvent.BUTTON3_DOWN_MASK) == InputEvent.BUTTON3_DOWN_MASK){
                 xMousePosition = e.getX();
                 yMousePosition = e.getY();
                 leftMouseClick = true;

                 System.out.println("Right Click works on position {x = "+xMousePosition+" } and { y = "+ yMousePosition+" } ");
             }
         }
     }); // End of addMouseListener
    } //end of CustomPanel

    public void doing(boolean clicked){
        if (clicked){

        }
    }

    /**
     * This method is critically important to success all project
     * @param g
     * It has to be Override with the same name and arguments
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }

}
