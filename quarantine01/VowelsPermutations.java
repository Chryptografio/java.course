package com.quarantine01;

/**
 * Задана строка, состоящая из символов латинского алфавита (от 'a' до 'z').
 * Необходимо реализовать функцию, переставляющую гласные в этой строке так,
 * чтобы они следовали в обратном порядке. Результат вывести на экран.
 *
 * Например, для строки "palindrome" на экран должно быть выведено "pelondrima".
 */

public class VowelsPermutations {
    private static final String VOWELS = "euoai";

    public static void main(String[] args) {
        try {
            System.out.println(permuteVowels("palindrome"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String permuteVowels (String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int j = str.length() - 1;
        char[] arr = str.toCharArray();
        while (i < j) {
            if (VOWELS.indexOf(arr[i]) == -1) {
                i++;
            } else {
                if (VOWELS.indexOf(arr[j]) != -1) {
                    permuteCharacters(arr, i, j);
                    i++;
                }
                j--;
            }
        }
        return new String(arr);
    }

    public static void permuteCharacters (char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
