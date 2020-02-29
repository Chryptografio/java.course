package com.problem2;

/**
 * Задача 2
 *
 * Вы разрабатываете небольшое приложение по аннотированию (разметке) изображений с целью последующего
 * использования этой разметки для обучения моделей computer vision. В этом приложении пользователь может
 * выделять области на изображении с помощью прямоугольников и окружностей и подписывать их произвольным текстом.
 *
 * Прямоугольники определяются координатами левого нижнего и правого верхнего углов, а окружности - координатами
 * центра и радиусом. Вся разметка для изображения представляется массивом Annotation[].
 *
 * Определите класс Annotation для представления данных разметки (подпись + фигура) и классы Figure, BoundingBox,
 * Circle для задания размеченных областей.
 *
 * Задача 2*
 *
 * От пользователей приложения пришел запрос на возможности перемещать уже размеченные области.
 * Для поддержки новой функциональности вам требуется внести несколько изменений:
 * 1) выбор аннотации по координатам точки (x, y);
 * В массиве аннотаций требуется найти первую, фигура которой содержит точку с заданными координатами.
 *
 * Annotation findByPoint(Annotation[] annotations, int x, int y) {
 *   // ...
 * }
 *
 * 2) перемещение фигуры выбранной аннотации на смещение (dx, dy);
В рамках этого изменения вы решили доработать классы фигур таким образом, чтобы они реализовывали интерфейс
 *
 * public interface Moveable {
 *   void move(int dx, int dy);
 * }
 *
 * Доработайте классы и реализуйте метод findByPoint.
 */

public class Annotation {
    private String caption;
    private Figure figure;
    Annotation (String caption, Figure figure) {
        if (caption.length() == 0) {
            throw new Error("Please provide a caption.");
        }
        if (figure == null) {
            throw new Error("Please provide a figure.");
        }
        this.caption = caption;
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean includesPoint(int x, int y) {
        return figure.includesPoint(x, y);
    }

}
