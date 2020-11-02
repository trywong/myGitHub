package com.wc.algorithm.beauty;

/**
 * 从先升序再降序的数组中查找最大值
 */
public class FindMax {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 6, 8, 9, 4, 3};
        System.out.println(findMax(array));
    }

    public static int findMax(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // 如果中间元素比前一元素大且比后一元素大，则mid是最大值
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return mid;
            }

            // 比前一元素小，处在下降阶段
            if (array[mid] < array[mid - 1]) {
                high = mid - 1;
            }

            // 比后一元素小，处在上升阶段
            if (array[mid] < array[mid + 1]) {
                low = mid + 1;
            }
        }

        return 0;
    }
}
