package com.problem2;

public class BoundingBox extends Figure implements Moveable {
    int xBottomLeft, yBottomLeft, xUpperRight, yUpperRight;

    BoundingBox (int xBottomLeft, int yBottomLeft, int xUpperRight, int yUpperRight) {
        if (xBottomLeft < 0 || yBottomLeft < 0 || xUpperRight < 0 || yUpperRight < 0) {
            throw new Error("Coordinates and radius cannot be negative");
        }
        this.xBottomLeft = xBottomLeft;
        this.yBottomLeft = yBottomLeft;
        this.xUpperRight = xUpperRight;
        this.yUpperRight = yUpperRight;
    }

    public boolean includesPoint (int x, int y) {
        if (xBottomLeft < x && x < xUpperRight &&  yUpperRight < y && y < yBottomLeft) {
            return true;
        }
        return false;
    }

    public void move(int dx, int dy) {
        this.xBottomLeft += dx;
        this.yBottomLeft += dy;
        this.xUpperRight += dx;
        this.yUpperRight += dy;
    }
}
