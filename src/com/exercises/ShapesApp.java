package com.exercises;

import com.ca1.ShapesManager;
import com.ca1.circle.Circle;
import com.ca1.point.Point;
import com.ca1.quadrileteral.Quadrilateral;
import com.ca1.rectangle.Rectangle;
import com.ca1.square.Square;

import javax.swing.*;
import java.awt.*;

public class ShapesApp {

    public static void main(String[] args) {
        ShapesManager shapesManager = new ShapesManager();
        shapesManager.setDisplayName(true);

        Rectangle rectangle = new Rectangle(200, 100);

        /**
         * Adding Shapes to the Array
         */
        shapesManager.addShape(new Quadrilateral(new Point(75,300), new Point(175,300),
                new Point(200,350),new Point(125,400),
                new Point(50,350)));

        shapesManager.addShape(new Square(Color.cyan,false, 50,100,150 ));
        shapesManager.addShape(new Rectangle(Color.blue,true,300, 100,250, 150));
        shapesManager.addShape(new Circle(new Color(220, 170, 46), 650,100,150));
        shapesManager.addShape(new Quadrilateral(rectangle));

        /**
         * Creating simple window here
         */
        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setVisible(true);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
