package com.problem2;

public class Circle extends Figure {
    private int xCenter, yCenter, radius;

    Circle (int xCenter, int yCenter, int radius) {
        if (xCenter < 0 || yCenter < 0 || radius < 0) {
            throw new Error("Coordinates and radius cannot be negative");
        }
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }

    public boolean includesPoint (int x, int y) {
        int distanceSquared = (xCenter - x) * (xCenter - x) + (yCenter - y) * (yCenter - y);
        if (distanceSquared <= radius * radius) {
            return true;
        }
        return false;
    }

    public void move(int dx, int dy) {
        this.xCenter += dx;
        this.yCenter += dy;
    }

    public int getxCenter() {
        return xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public int getRadius() {
        return radius;
    }
}
