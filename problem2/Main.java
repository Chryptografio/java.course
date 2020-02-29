package com.problem2;

public class Main {
    public static Annotation findByPoint(Annotation[] annotations, int x, int y) {
        if (annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i].includesPoint(x, y)) {
                return annotations[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Annotation[] annotations = new Annotation[] {
                new Annotation("hello", new Circle(30, 30, 10)),
                new Annotation("there", new BoundingBox(1, 10, 10, 1))
        };
        annotations[0].getFigure().move(10, 10);
        System.out.println(annotations[1].toString());
        System.out.println(((Circle)annotations[0].getFigure()).getxCenter());
        Annotation annotation = findByPoint(annotations, 2, 2);
        System.out.println(annotation.toString());
    }
}
