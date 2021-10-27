package com.ca1;

import java.awt.*;
import java.util.ArrayList;

public class ShapesManager {

    private boolean displayName;
    private boolean displayBoundingBox;

    private ArrayList<Shape> shapesArray;

    public ShapesManager() {
        shapesArray = new ArrayList<>();
    }

    public void drawShapes(Graphics g){
        for (Shape currentShape: shapesArray){
            /*
              This peace fo code assuming that the name of shapes should be displayed on it
              If the parameter is true for setDisplayName() each shape get his name
             */
            if(isDisplayName()){
                currentShape.setNameDisplayed( isDisplayName() );
                currentShape.drawShape(g);
                System.out.println(currentShape);
            }else {
                currentShape.drawShape(g);
                System.out.println(currentShape);
            }
        }
    }

    /**
     *  add all type of shapes to the array
     */
    public void addShape(Shape shape){
        shapesArray.add(shape);
    }

    public ArrayList<Shape> getShapesArray() {
        return shapesArray;
    }

    public void setDisplayName(boolean b){ this.displayName = b; }
    public boolean isDisplayName() { return displayName; }

    public boolean isDisplayBoundingBox() { return displayBoundingBox; }
    public void setDisplayBoundingBox(boolean displayBoundingBox) { this.displayBoundingBox = displayBoundingBox; }
}
