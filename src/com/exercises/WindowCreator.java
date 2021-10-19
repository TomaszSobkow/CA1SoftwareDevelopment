package com.exercises;

import com.ca1.ShapesManager;
import com.ca1.circle.Circle;
import com.ca1.quadrileteral.Quadrilateral;
import com.ca1.rectangle.Rectangle;
import com.ca1.square.Square;

import javax.swing.*;
import java.awt.*;


public class WindowCreator {

    public static void main(String[] args) {
        ShapesManager shapesManager = new ShapesManager();
        shapesManager.setDisplayName(true);

        shapesManager.addShape(new Square(50,100,150 ));
        shapesManager.addShape(new Rectangle(250,100, 200,150));
        shapesManager.addShape(new Circle(new Color(190, 178, 98),false, 500,100,150));
       // shapesManager.addShape(new Quadrilateral());

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setVisible(true);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
