package com.den.DenCore.algorithms.exponentialsearch;


import com.den.DenCore.algorithms.binpoisk.BinPoisk;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

/**
 * Класс, который предоставляет методы для работы с экспоненциальным поиском
 *
 * @author Denis Stepanidenko
 */
@UtilityClass
public class ExponentialSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[i] = x;
        }

        int target = scanner.nextInt();
        int[] ans = exponentialSearchFindBorders(target, arr);
        System.out.println(ans[0] + " " + ans[1]);

    }

    /**
     * Возвращает границы в которых может находиться число target в массиве arr с помощью экспоненциального поиска
     *
     * <p>Временная сложность алгоритма: O(log(m))</p>
     */
    public static int[] exponentialSearchFindBorders(int target, int[] arr) {

        int border = 1;
        int[] ans = new int[2];

        while (border < arr.length) {

            if (arr[border] < target) {
                border = border * 2;
            } else if (arr[border] == target) {
                ans[0] = border;
                ans[1] = border;
                return ans;
            } else {
                ans[0] = border / 2;
                ans[1] = border;
                return ans;
            }

        }

        ans[0] = border / 2;
        ans[1] = arr.length - 1;

        return ans;

    }

    /**
     * Экспоненциальный поиск числа в массиве
     * Временная сложность алгоритма - O(log(m)), где m - индекс искомого элемента в массиве arr
     */
    public static boolean exponentialSearch(int target, int[] arr) {

        int border = 1;

        // сначала найдём границы поиска
        while (border < arr.length) {

            if (arr[border] < target) {
                border = border * 2;
            } else {
                break;
            }
        }

        if (border >= arr.length) {

            // запускаем бинарный поиск на отрезке [border/2; arr.length - 1]
            return BinPoisk.classicalBinarySearch(target, arr, border / 2, arr.length - 1);

        } else {

            if (arr[border] == target) {
                return true;
            }

            // запускаем бинарный поиск на отрезке [border/2; border]
            return BinPoisk.classicalBinarySearch(target, arr, border / 2, border);
        }

    }


}
