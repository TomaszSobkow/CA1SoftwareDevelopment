package com.exercises;

import com.ca1.ShapesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomPanel extends JComponent {

    private ShapesManager shapesManager;

    JButton button;


    public CustomPanel(ShapesManager shapesManager){
     this.shapesManager = shapesManager;
     this.button = new JButton("Change color");
     add(button);

     addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
             super.mousePressed(e);
         }
     });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);



    }

    //    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        g.setColor(Color.blue);
//        g.fillRect(getWidth() /2 -50,(getHeight()/2 -100),100,200);
//        g.setColor(Color.red);
//
//
////        int circleRadius = 25;
////        g.drawOval(this.getWidth()/2 - circleRadius,
////                   this.getHeight()/2 - circleRadius,
////                circleRadius * 4,
////                circleRadius * 3);
//        g.setColor(Color.red);
//
//        g.fillOval((getWidth() / 2 -50 ) ,
//                (getHeight() / 2 -100) ,
//                100,200);
//
//        g.setColor(Color.gray);
//        g.drawOval(0,0,getWidth(),getHeight() );
//
//        g.setColor(Color.BLACK);
//        g.drawOval(getWidth()/2 -25 , getHeight()/2 -25 ,50,50);
//    }
}
