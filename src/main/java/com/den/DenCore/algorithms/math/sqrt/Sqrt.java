package com.den.DenCore.algorithms.math.sqrt;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(findMinSqrt(50));
    }

    /**
     * Находит корень числа (ближайшее целое число, которое не превосходит значение корня)
     * Временная сложность алгоритма: O(log(target))
     */
    public static int findMinSqrt(int target) {

        int left = 0;
        int right = target;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (mid * mid == target) {
                return mid;
            } else if (mid * mid > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (right * right <= target) {
            return right;
        }

        return left;

    }
}
