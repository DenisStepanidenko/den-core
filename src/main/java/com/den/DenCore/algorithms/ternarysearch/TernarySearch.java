package com.den.DenCore.algorithms.ternarysearch;

import lombok.experimental.UtilityClass;


/**
 * Класс, который предоставляет методы для работы с тернарным поиском
 *
 * @author Denis Stepanidenko
 */
@UtilityClass
public class TernarySearch {

    /**
     * Тернарный поиск (ищет, входит ли элемент в массив)
     *
     * <p>Временная сложность алгоритма O(log(n)), где n - количество элементов в массиве arr</p>
     *
     * @param target элемент, который мы хотим найти
     * @param arr    отсортированный массив
     * @return true, если элемент был найден, иначе false
     */
    public static boolean ternarySearch(int target, int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int m1 = left + (right - left) / 3;
            int m2 = right - (right - left) / 3;

            if (arr[m1] == target) {
                return true;
            }

            if (arr[m2] == target) {
                return true;
            }

            if (arr[m1] > target) {
                right = m1 - 1;
            } else if (arr[m2] < target) {
                left = m2 + 1;
            } else {
                left = m1 + 1;
                right = m2 - 1;
            }

        }

        return false;
    }


}
