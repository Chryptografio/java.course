package com.quarantine01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * В колл-центре крупной компании сохраняются логи всех телефонных звонков за день.
 * Каждая строка файла лога состоит из времени начала и времени окончания одного телефонного разговора,
 * разделенных запятой. Время задается в формате POSIX time (количество миллисекунд с 1 января 1970 года).
 * Строки в файле отсортированы по времени начала разговора.
 *
 * Необходимо посчитать пиковое количество одновременных разговоров и вывести его на экран.
 * (Максимальное количество разговоров, которые происходили в одно и то же время.)
 *
 * Пример:
 *
 * [in]
 * 1,12
 * 4,6
 * 7,12
 * 10,32
 * 15,30
 *
 * [out]
 * 3
 */

public class ConcurrentCalls {
    public static void main(String[] args) {
        if (args.length < 0) {
            System.out.println("No file was provided.");
            return;
        }
        try {
            System.out.println(findPeak(Paths.get(args[0])));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findPeak (Path path) throws IOException {
        Scanner s = null;
        int startAt = 0;
        int max = 0;
        int n;
        long a, b;
        boolean nextIterationPossible = true;

        while (nextIterationPossible) {
            a = 0;
            b = Long.MAX_VALUE;
            try {
                s = new Scanner(new BufferedReader(new FileReader(path.toString())));

                for (int i = 0; i < startAt; i++) {
                    s.nextLine();
                }

                if (!s.hasNextLine()) {
                    nextIterationPossible = false;
                }

                n = 0;

                while (s.hasNextLine() && a <= b) {
                    String str = s.nextLine();
                    a = Long.parseLong(str.split(",")[0]);
                    if (Long.parseLong(str.split(",")[1]) < b) {
                        b = Long.parseLong(str.split(",")[1]);
                    }
                    n++;
                }

                if (n > max) max = n;

                startAt++;
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }

        return max;
    }
    
}
