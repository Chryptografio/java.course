package com.problem4;
/**
 * Задача 4*
 * Вы разрабатываете систему в микросервисной архитектуре, в которой сервисы в процессе работы записывают логи в отдельные файлы.
 * Каждая строка файла лога имеет вид:
 *
 * time message\n
 *
 * где time - время в формате POSIX time (количество миллисекунд с 1 января 1970 года), message - произвольный текст.
 *
 * Строки в логах всегда отсортированы по времени в порядке возрастания.
 * Сервисов в системе много, и вы обнаружили, что при анализе ошибок тратите слишком много времени,
 * так как приходится восстанавливать общий порядок действий в системе по большому количеству разных логов.
 *
 * Для оптимизации работы вы решили реализовать утилиту «слияния» нескольких логов в один общий.
 * Утилита в качестве аргументов командной строки принимает пути к файлам логов (произвольное количество)
 * и записывает в стандартный поток вывода результат: общую последовательность строк лога в порядке возрастания времени.
 *
 * Реализуйте эту утилиту, имея в виду, что логи бывают большими и не всегда могут поместиться в оперативной памяти целиком.
*/

import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Scanner;

public class MergingLogs {
    public static void main(String[] args) {
        try {
            //createLogFiles(10);
            mergeLogs(args);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mergeLogs(String[] logFiles) throws IOException {
        int n = logFiles.length;
        Scanner[] scanners = new Scanner[n];
        String[] logs = new String[n];

        try {

            for (int i = 0; i < n; i++) {
                scanners[i] = new Scanner(new BufferedReader(new FileReader(logFiles[i])));
                if(scanners[i].hasNextLine()) {
                    logs[i] = scanners[i].nextLine();
                }
            }

            while (hasLogs(logs)) {
                long[] times = new long[n];
                int min = 0;
                for (int i = 0; i < n; i++) {
                    if (logs[i] != null) {
                        if (logs[min] == null) min = i;
                        times[i] = Long.parseLong(logs[i].split(" ")[0]);
                        if (times[i] < times[min]) {
                            min = i;
                        }
                    }

                }

                if (logs[min] != null) {
                    System.out.println(logs[min]);
                    if (scanners[min].hasNextLine()) {
                        logs[min] = scanners[min].nextLine();
                    } else {
                        logs[min] = null;
                    }
                }

            }

        } finally {
            for (int i = 0; i < n; i++) {
                if(scanners[i] != null) {
                    scanners[i].close();
                }
            }
        }
    }

    static private boolean hasLogs(String[] logs) {
        for (int i = 0, n = logs.length; i < n; i++) {
            if (logs[i] != null) return true;
        }
        return false;
    }

    static public void createLogFiles(int n) throws IOException{
        BufferedWriter[] writers = new BufferedWriter[n];
        try {
            for (int i = 0; i < n; i++) {
                writers[i] = Files.newBufferedWriter(Paths.get("log" + i + ".txt"));
            }

            for (int j = 0; j < 1000; j++) {
                for (int i = 0; i < n; i++) {
                    long unixTime = Instant.now().getEpochSecond() + (i * 5) + j;
                    String str = "" + unixTime + " random message text blaaah" + "\n";
                    writers[i].write(str);
                }
            }

        } finally {
            for (int i = 0; i < n; i++) {
                if (writers[i] != null) {
                    writers[i].close();
                }
            }
        }
    }

}
