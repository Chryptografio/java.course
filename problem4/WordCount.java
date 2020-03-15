package com.problem4;

import java.io.*;
import java.util.Scanner;

/**
 * Задача 4
 *
 * В текстовом файле слова могут быть разделены одним или несколькими пробелами и символами перевода строки.
 * Необходимо реализовать программу, считающую количество слов в файле и выводящую результат на экран.
 * Путь к файлу задается первым аргументом командной строки (args[0]).
 */
public class WordCount {
    public static void main(String[] args) {
        try {
            wordCount(args[0]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int wordCount (String path) throws IOException {
        int counter = 0;
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(path)));

            while (s.hasNext()) {
                System.out.println(s.next());
                counter++;
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return counter;
    }
}
