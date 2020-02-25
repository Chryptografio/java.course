package com.problems;

/**
 * Задача 1*
 * Написать метод, форматирующий и выводящий на экран заданный размер в байтах в человекочитаемом виде.
 *
 * Человекочитаемый вид:
 * {целая часть <= 1024}.{дробная часть макс. 1 знак} {единица измерения}
 *
 * Например:
 *
 * printBytes(23) -> "23.0 B"
 * printBytes(1024) -> "1.0 KB"
 * printBytes(53692044905543) -> "48.8 TB"
 *
 * Для вывода только одного знака дробной части вещественного числа можно воспользоваться методом String.format:
 * String.format("%.1f", 1.23456)
 */

public class problem_1_2 {
    static final int BYTE_SIZE = 1024;
    static final String[] BYTE_NAMES = new String[] {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
    
    public static void main(String[] args) {
        printBytes(23);
        printBytes(1024);
        printBytes(53692044905543l);
    }

    public static void printBytes(long bytes) {
        // int bytesNamesIndex = getIndex(bytes); if recursion is used
        int bytesNamesIndex = (int) Math.floor(Math.log(bytes) / Math.log(BYTE_SIZE));
        double value = bytes / Math.pow(BYTE_SIZE, bytesNamesIndex); 
        String output = String.format("%.1f", value) + " " + BYTE_NAMES[bytesNamesIndex];
        System.out.println(output);
    }
    
    /*
    public static int getIndex(long bytes) {
        if (bytes < BYTE_SIZE) {
            return 0;
        } else {
            return getIndex(bytes / BYTE_SIZE) + 1;
        }
    }
    */
}
