package com.wc.algorithm;

import java.util.Arrays;

public class MySort {
    /**
     * 快速排序
     * @Description
     *              一、找一个基准值，小于基准值的放到左边，大于基准值的放到右边
     *              1. 选第一个值作为基准值
     *              2. 从右向左，直到选择一个比基准值小的值，放到第一个位置，留出一个空位
     *              3. 从左向右，直到选择一个比基准值大的值，放到右边的空位
     *              ……
     *              n. 将基准值赋值给左右相遇的位置
     *              二、左右两边序列递归进行
     * @param array
     * @param low
     * @param high
     * @return
     * @History 2016年9月7日 下午3:26:51 by wangchuan
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = patition1(array, low, high);
            if (low < middle - 1) {
                quickSort(array, low, middle - 1);
            }
            if (high > middle + 1) {
                quickSort(array, middle + 1, high);
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 分治
     * @Description 将一个序列，按照基准值分为左右两个序列，返回基准值的序列
     * @param array
     * @param low
     * @param high
     * @return
     * @History 2016年9月7日 下午3:40:34 by wangchuan
     */
    private static int patition(int[] array, int low, int high) {
        // 基准值
        int flagVal = array[low];
        System.out.println("基准值：" + flagVal);
        System.out.println("low：" + low + ", high=" + high);
        while (low < high) {
            // 右边比基准值大，继续往前遍历
            while (low < high && array[high] >= flagVal) {
                high--;
            }
            if (low < high) {
                // 将大于的值放到左边，空出一个位置
                array[low] = array[high];
                low++;
            }

            // 左边比基准值小，继续往后遍历
            while (low < high && array[low] <= flagVal) {
                low++;
            }
            if (low < high) {
                // 将小于的值放到右边的空位
                array[high] = array[low];
                high--;
            }
        }
        array[low] = flagVal;
        return low;
    }

    /**
     * 直接插入排序
     * @Description 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，现在要把第n 个数插到前面的有序数中，
     *              使得这 n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     * @param array
     * @History 2016年9月8日 下午2:16:20 by wangchuan
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 当前元素
            int currentEle = array[i];
            // 遍历排好序的序列，将当前元素插入到合适的位置
            int j = i - 1;
            while (j >= 0 && currentEle < array[j]) {
                // 数组后移
                array[j + 1] = array[j];
                j--;
            }
            // 元素插入到有序序列。while循环结束时，j的值是与当前值相等或小于当前值的元素的序列号，所以应该将当前元素放到该元素之后
            array[j + 1] = currentEle;

            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 折半插入排序
     * @Description 在选择插入有序序列时，采用二分查找方式
     * @param array
     * @History 2016年9月12日 下午2:00:03 by wangchuan
     */
    public static void halfInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 当前元素
            int currentEle = array[i];
            int low = 0;
            int high = i - 1;
            int m = 0;
            while (low <= high) {
                m = (high + low) / 2;
                if (currentEle < array[m]) {
                    high = m - 1;
                } else if (currentEle > array[m]) {
                    low = m + 1;
                }
            }
            for (int j = i - 1; j >= m; j--) {
                array[j + 1] = array[j];
            }
            array[m + 1] = currentEle;
        }
    }

    /**
     * 希尔排序
     * @Description 以固定间隔的元素进行比较，逐渐缩小间隔直至为1。交换比较的两个元素
     * @param array
     * @History 2016年9月12日 下午3:36:16 by wangchuan
     */
    public static void shellSort(int[] array) {
        int len = array.length;
        int interval = len / 2;
        // 设置间隔
        while (interval >= 1) {
            // 按距离为 gap的增量对元素进行插入排序
            for (int i = interval; i < len; i++) {
                int j = i - interval;
                int currentEle = array[i];
                while (j >= 0 && currentEle < array[j]) {
                    array[j + interval] = array[j];
                    j -= interval;
                }
                array[j + interval] = currentEle;
                System.out.println(Arrays.toString(array));
            }
            interval /= 2;
        }
    }

    /**
     * 选择排序
     * @Title MySort.selectSort()
     * @Description 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素
     *              （倒数第二个数）和第n个元素（最后一个数）比较为止。
     * @param array
     * @History 2016年9月19日 上午10:55:38 by wangchuan
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int flagVal = array[i];
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min > i) {
                array[i] = array[min];
                array[min] = flagVal;
                System.out.println("--");
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 5, 1, 6, 4, 0, 7, 3, 2, 8, 9 };
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
    }

    public static int patition1(int[] array, int low, int high) {
        int position = low;
        int pivot = array[high];
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                swap(array, position, i);
                position++;
            }
        }
        swap(array, position, high);
        System.out.println(Arrays.toString(array));
        return position;
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
