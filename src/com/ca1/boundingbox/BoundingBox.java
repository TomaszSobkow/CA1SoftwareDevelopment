package com.ca1.boundingbox;

import com.ca1.point.Point;

public class BoundingBox {

    private Point bottomLeft;
    private Point topRight;

    public BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                '}';
    }

    public Point getBottomLeft() { return bottomLeft; }
    public void setBottomLeft(Point bottomLeft) { this.bottomLeft = bottomLeft; }

    public Point getTopRight() { return topRight; }
    public void setTopRight(Point topRight) { this.topRight = topRight; }
}
