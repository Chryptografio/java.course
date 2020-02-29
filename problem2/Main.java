package com.problem2;

public class Main {
    public Annotation findByPoint(Annotation[] annotations, int x, int y) {
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
}
