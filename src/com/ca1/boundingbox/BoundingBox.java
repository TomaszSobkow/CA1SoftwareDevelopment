package com.ca1.boundingbox;

import com.ca1.point.Point;

public class BoundingBox {

    private Point topLeft;
    private Point bottomRight;

    public BoundingBox(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + topLeft +
                ", topRight=" + bottomRight +
                '}';
    }

    public Point getTopLeft() { return topLeft; }
    public void setTopLeft(Point bottomLeft) { this.topLeft = bottomLeft; }

    public Point getBottomRight() { return bottomRight; }
    public void setBottomRight(Point topRight) { this.bottomRight = topRight; }
}
