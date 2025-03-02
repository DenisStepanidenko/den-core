package com.den.DenCore.algorithms.binpoisk;


import lombok.experimental.UtilityClass;


/**
 * Класс, который предоставляет различные методы для работы с бинарным поиском
 *
 * @author Denis Stepanidenko
 */
@UtilityClass
public class BinPoisk {

    /**
     * Классический бинарный поиск, который определяет, находится ли элемент в отсортированном массиве
     *
     * <p>Временная сложность алгоритма O(log(n)), где n - количество элементов в массиве arr</p>
     *
     * @param target элемент, который мы хотим найти
     * @param arr    отсортированный массив
     * @return true, если элемент был найден, иначе false
     */
    public static boolean classicalBinarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }


    /**
     * Классический бинарный поиск, который определяет, находится ли элемент в отсортированном массиве
     *
     * <p>Временная сложность алгоритма O(log(n)), где n - количество элементов в массиве arr</p>
     *
     * @param target     элемент, который мы хотим найти
     * @param arr        отсортированный массив
     * @param leftIndex  левая граница поиска
     * @param rightIndex правая граница поиска
     * @return true, если элемент был найден, иначе false
     */
    public static boolean classicalBinarySearch(int target, int[] arr, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }


    /**
     * Левый бинарный поиск (находит самое первое вхождение target в массив arr)
     *
     * @param target элемент, который мы хотим найти
     * @param arr    отсортированный массив
     */
    public static int leftBinarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[left] == target) {
            return left;
        }

        if (arr[right] == target) {
            return right;
        }

        return -1;
    }

    /**
     * Правый бинарный поиск (находит самое последнее вхождение target в массив arr)
     *
     * @param target элемент, который мы хотим найти
     * @param arr    отсортированный массив
     */
    public static int rightBinarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                left = mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[right] == target) {
            return right;
        }

        if (arr[left] == target) {
            return left;
        }

        return -1;
    }
}
