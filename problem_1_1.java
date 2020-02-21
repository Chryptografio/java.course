package com.problems;

/**
 * Задача 1
 *         Задан массив целых чисел. Необходимо переставить наименьшее из этих чисел в начало массива, а наибольшее - в конец.
 *
 *         Массивы в Java определяются с помощью указания их размера в квадратных скобках:
 *         int[] v = new int[77];
 *
 *         Размер можно не указывать, но тогда нужно определить сами элементы в фигурных скобках:
 *         int[] v = new int[] {6, 28, 1};
 *
 *         Обращаться к элементам можно по индексу:
 *         System.out.println(v[0]); // выводим первый по счету элемент
 *         v[1] = 16; // изменяем значение элемента с индексом 1
 *
 *         Размер массива:
 *         v.length;
 */


public class problem_1_1 {
    public static void main(String[] args) {
        int[] v = new int[] {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, -1};
        System.out.print("Before: v = ");
        displayArray(v);
        changeArray(v);
        System.out.print("After: v =  ");
        displayArray(v);
    }

    private static void changeArray(int[] arr) {
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int minValue = arr[minIndex];
        int maxValue = arr[maxIndex];

        for (int i = Math.max(minIndex, maxIndex); i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        for (int i = Math.min(minIndex, maxIndex); i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = minValue;
        arr[arr.length - 1] = maxValue;
    }

    private static void displayArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println("]");
    }

}
