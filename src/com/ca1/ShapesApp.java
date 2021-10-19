package com.ca1;

import com.ca1.circle.Circle;
import com.ca1.quadrileteral.Quadrilateral;
import com.ca1.rectangle.Rectangle;
import com.ca1.square.Square;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class ShapesApp {
    public static void main(String[] args) {

        ShapesManager shapesManager = new ShapesManager();
        shapesManager.setDisplayName(true);
        //shapesManager.addShape(new Square());

        Rectangle rectangle = new Rectangle(Color.red,true,50,120,100,150);
        shapesManager.addShape(rectangle);
        


        Rectangle rectangle1 = new Rectangle(Color.CYAN, 50,120,40,30);
        Quadrilateral quad = new Quadrilateral(rectangle);
        shapesManager.addShape(quad);



    }
}
