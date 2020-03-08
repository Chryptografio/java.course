package com.problem3;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(ChessBoardPosition pos1, ChessBoardPosition pos2) {
        super("конь так не ходит: " + pos1.toString() + " -> " + pos2.toString());
    }
}
