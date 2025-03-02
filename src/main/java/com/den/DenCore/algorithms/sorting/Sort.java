package com.den.DenCore.algorithms.sorting;


import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.Arrays;

/**
 * Класс для работы с различными видами сортировок
 *
 * @author Denis Stepanidenko
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Сортировка выбором.
     * <p>Временная сложность - O(len(arr)) ^ 2.</p>
     */
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * Сортировка вставками.
     * Временная сложность - O(len(arr)) ^ 2.
     */
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else break;
            }
        }

    }

    /**
     * Сортировка пузырьком.
     * Временная сложность - O(len(arr)) ^ 2.
     */
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Шаг " + i + " " + Arrays.toString(arr));
        }
    }

    /**
     * Сортировка Шелла.
     * Временная сложность - O(len(arr)) ^ 2.
     */
    public static void shellSort(int[] arr) {

        int step = arr.length / 2;

        for (int i = step; i > 0; i /= 2) {

            for (int j = i; j < arr.length; j++) {
                while (j >= i && arr[j] < arr[j - i]) {
                    int temp = arr[j];
                    arr[j] = arr[j - i];
                    arr[j - i] = temp;
                    j -= i;
                }
            }

        }
    }


}
