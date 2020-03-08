package com.problem3;

/**
 * Задача 3
 *
 * Определить класс, описывающий позицию на шахматной доске 8x8. Данные класса: компоненты x и y,
 * отсчитываемые от левого нижнего угла (x = 0, y = 0 - левая нижняя клетка). Все методы,
 * позволяющие установить координаты, в том числе и конструкторы, должны проверять корректность
 * аргументов и генерировать IllegalArgumentException в случае ошибочных значений.
 *
 * Переопределить метод toString(), выводящий координаты позиции в формате <номер колонки в
 * виде буквы от 'a' до 'h'><номер строки, начиная с 1>. Например, позиция с координатами (1, 1)
 * имеет строковое представление "b2".
 *
 * Задача 3*
 *
 * В виде массива строк задана некоторая последовательность позиций на шахматной доске 8x8.
 * Например, "b1", "a3", "c4", "d6". Реализовать метод, проверяющий, что последовательность
 * может быть пройдена фигурой конь в соответствии с правилами хода этой фигуры (буквой "Г").
 * На вход метод должен принимать массив объектов класса, определенных в предыдущей задаче.
 *
 * Определить новый класс обрабатываемого исключения, которое генерируется методом проверки в случае ошибки.
 *
 * public class IllegalMoveException extends Exception {
 *     // ...
 * }
 *
 * Класс должен содержать информацию о неправильном ходе: из какой в какую позиции ход запрещен.
 *
 * При вызове метода проверки это исключение должно обрабатываться, а неправильный ход выводиться на экран.
 *
 * Пример:
 *
 * [in]  "g8", "e7", "e6"
 * [out] "конь так не ходит: e7 -> e6"
 *
 * [in]  "g8", "e7", "c8"
 * [out] "OK"
 */

public class ChessBoardPosition {
    private int x,y;
    final String X_COORDS = "abcdefgh";
    final String Y_COORDS = "12345678";

    public ChessBoardPosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    public ChessBoardPosition(String str) {
        if (str == null || str.length() != 2) {
            throw new IllegalArgumentException();
        }
        if (X_COORDS.indexOf(str.charAt(0)) == -1 || Y_COORDS.indexOf(str.charAt(1)) == -1) {
            throw new IllegalArgumentException();
        }
        this.x = X_COORDS.indexOf(str.charAt(0));
        this.y = Y_COORDS.indexOf(str.charAt(1));
    }

    @Override
    public String toString() {
        return "" + X_COORDS.charAt(this.x) + Y_COORDS.charAt(this.y);
    }

    public void moveKnightTo (ChessBoardPosition pos) throws IllegalMoveException {
        if (pos == null) {
            throw new IllegalArgumentException();
        }
        if((Math.abs(this.x - pos.x) == 2 && Math.abs(this.y - pos.y) == 1) || (Math.abs(this.x - pos.x) == 1 && Math.abs(this.y - pos.y) == 2)) {
            this.x = pos.x;
            this.y = pos.y;
            return;
        }
        throw new IllegalMoveException(this, pos);
    }
}
