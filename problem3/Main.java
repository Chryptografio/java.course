package com.problem3;

public class Main {
    public static String isValidKnightMoves (ChessBoardPosition[] sequence) {
        if (sequence.length == 0 || sequence.length == 1) {
            return "Nowhere to move";
        }
        ChessBoardPosition pos = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            try {
                pos.moveKnightTo(sequence[i]);
            } catch (IllegalMoveException exc) {
                return exc.getMessage();
            }
        }
        return "OK";
    }

    public static void main(String[] args) {
        ChessBoardPosition pos = new ChessBoardPosition("c8");
        ChessBoardPosition[] seq = new ChessBoardPosition[] {
                new ChessBoardPosition("a1"),
                new ChessBoardPosition("b3"),
                new ChessBoardPosition(2, 7)
        };
        String ans = isValidKnightMoves(seq);
        System.out.println(ans);
    }
}
