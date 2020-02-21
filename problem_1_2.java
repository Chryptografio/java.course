package com.alieno;

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
 *
 * байт	Б	100	—	100	байт	B	Б	20
 * килобайт	Кбайт	103	кило-	103	кибибайт	KiB	КиБ	210
 * мегабайт	Мбайт	106	мега-	106	мебибайт	MiB	МиБ	220
 * гигабайт	Гбайт	109	гига-	109	гибибайт	GiB	ГиБ	230
 * терабайт	Тбайт	1012	тера-	1012	тебибайт	TiB	ТиБ	240
 * петабайт	Пбайт	1015	пета-	1015	пебибайт	PiB	ПиБ	250
 * эксабайт	Эбайт	1018	экса-	1018	эксбибайт	EiB	ЭиБ	260
 * зеттабайт	Збайт	1021	зетта-	1021	зебибайт	ZiB	ЗиБ	270
 * йоттабайт	Ибайт	1024	йотта-	1024	йобибайт	YiB	ЙиБ	280
 */

public class problem_1_2 {
    static final int BYTE_SIZE = 1024;
    public static void main(String[] args) {
        printBytes(23);
        printBytes(1024);
        printBytes(53692044905543d);
    }

    public static void printBytes(double bytes) {
        String[] bytesNames = new String[] {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        int bytesNamesIndex = getIndex(bytes);
        double value = bytes / Math.pow(1024, bytesNamesIndex); //bytes < 1024 ? bytes : bytes / 1024;
//        Math.pow(1024, bytesNamesIndex);
        String output = String.format("%.1f", value) + " " + bytesNames[bytesNamesIndex];
        System.out.println(output);
    }

    public static int getIndex(double bytes) {
        if (bytes < BYTE_SIZE) {
            return 0;
        } else {
            return getIndex(bytes / BYTE_SIZE) + 1;
        }
    }
}
