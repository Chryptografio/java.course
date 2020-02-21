package com.alieno;

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

        v = new int[] {1, 2, 3, 4, 5};
        runTestCase(v);
        v = new int[] {1, 2, 5, 4, 3};
        runTestCase(v);
        v = new int[] {5, 2, 3, 4, 1};
        runTestCase(v);
        v = new int[] {5, 2, 3, 1, 4};
        runTestCase(v);
        v = new int[] {3, 2, 5, 4, 1};
        runTestCase(v);
        v = new int[] {3, 2, 1, 5, 4};
        runTestCase(v);
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

/*    private static void changeArr(int[] arr) {
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

        arr[minIndex] = arr[0];
        arr[maxIndex] = arr[arr.length - 1];

        arr[0] = minValue;
        arr[arr.length - 1] = maxValue;


        if (maxIndex == 0) {
            doPermutation(arr, 0, arr.length - 1);
            if (!(minIndex == arr.length - 1)) {
                doPermutation(arr, 0, minIndex);
            }
        } else {
            doPermutation(arr, 0, minIndex);
            doPermutation(arr, arr.length - 1, maxIndex);
        }
    }*/

/*    private static void doPermutation(int[] arr, int index1, int index2) {
        int firstValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = firstValue;

    }*/

    private static void displayArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println("]");
    }

    private static void runTestCase (int[] arr) {
        System.out.print("Before: arr = ");
        displayArray(arr);
        changeArray(arr);
        System.out.print("After:  arr = ");
        displayArray(arr);
    }
}

