package com.wc.algorithm.beauty;

/**
 * @author shovel
 * @date 2018/11/27 11:19
 * @since 1.0.0
 */
public class SortTest {
    public static void main(String[] args) {
        SortTest m = new SortTest();
        int[] array = { 4, 5, 2, 1, 6, 7 };
        m.insertionSort(array, array.length);

        for (int item : array) {
            System.out.println(item);
        }
    }

    /**
     * 冒泡排序
     * 相邻元素比较，如果有序，继续比较，如果无序，交换两个元素----一趟冒泡，操作n次
     * 经过n次冒泡，达到有序----n次排序
     * 时间复杂度为n^2
     * <p>
     * 从左往右冒泡
     *
     * @param array
     */
    void bubbleSortL2R(int[] array) {
        if (array.length <= 1) {
            return;
        }

        /**
         * 自己的思路：外层循环 n~0 代表无序序列结尾，从数组最后逐渐往前缩减
         * 正确思路：外层循环正常遍历0~n，内层循环用 n-i-1 代表无序序列结尾
         *
         * 一样的效果，不一样的思考方式
         */
        for (int i = array.length - 1; i >= 0; i--) {
            boolean changed = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    changed = true;
                }
            }

            for (int item : array) {
                System.out.print(item + "-");
            }
            System.out.println();

            // 最后一次冒泡，已经有序，没有任何交换数据
            if (!changed) {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 从右往左排序
     *
     * @param array
     */
    void bubbleSortR2L(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                int a = array[j];
                int b = array[j - 1];
                if (a < b) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }

            for (int item : array) {
                System.out.print(item + "-");
            }
            System.out.println();
        }
    }

    /**
     * 插入排序
     * 将无序序列不断往有序序列中插入，直到整个序列达到有序
     *
     * @param array
     */
    void insertSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int current = array[i];

            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            // j的值在跳出while循环时，做了减1操作，所以此处需要+1
            array[j + 1] = current;
        }
    }

    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                // 比较一位，移动一位!!!
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    // 找到应该插入的位置
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    void selectSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {

        }
    }
}
