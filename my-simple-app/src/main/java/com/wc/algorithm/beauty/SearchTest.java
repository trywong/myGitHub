package com.wc.algorithm.beauty;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shovel
 * @date 2018/12/6 11:39
 * @since 1.0.0
 */
public class SearchTest {
    int binarySearch(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == item) {
                return mid;
            } else if (array[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param array
     * @param item
     *
     * @return
     */
    int binarySearchByRecursion(int[] array, int low, int high, int item) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] == item) {
            return mid;
        } else if (array[mid] < item) {
            return this.binarySearchByRecursion(array, mid + 1, high, item);
        } else {
            return this.binarySearchByRecursion(array, low, high - 1, item);
        }
    }

    /**
     * 查找第一个等于给定元素值的下标
     *
     * @param array
     * @param item
     *
     * @return
     */
    int firstEquals(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == item) {
                /*int index = mid;
                // 找到重复元素的区间。往前遍历
                while (index >= 0 && array[index] == item) {
                    index--;
                }
                return index + 1;*/

                // 是不是第一个等于的值
                if (mid == 0 || array[mid - 1] != item) {
                    return mid;
                }

                high = mid - 1;
            } else if (array[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 第一个大于等于给定值的元素
     *
     * @param array
     * @param item
     *
     * @return
     */
    int firstGE(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] >= item) {
                /*// mid点的值大于等于item，往前遍历，找到第一个大于等于item的元素
                int index = mid;
                while (index >= 0 && array[index] >= item) {
                    index--;
                }

                return index + 1;*/

                // mid是数组第一个元素，或者array[mid]就是第一个大于等于item的元素
                if (mid == 0 || array[mid - 1] < item) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    /**
     * 平方根
     *
     * @param num
     *
     * @return
     */
    double squareRoot(int num) {
        return 0;
    }

    @Test
    public void binarySearchTest() {
        SearchTest test = new SearchTest();
        int index = test.binarySearch(new int[]{ 1, 2, 3, 4, 6, 7, 8, 9 }, 5);
        Assert.assertTrue(index == -1);
    }

    @Test
    public void firstEqualsTest() {
        SearchTest test = new SearchTest();
        int index = test.firstEquals(new int[]{ 2, 2, 2, 3, 3, 4, 6, 7, 8, 9 }, 2);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void firstGETest() {
        SearchTest test = new SearchTest();
        int index = test.firstGE(new int[]{ 2, 2, 2, 3, 3, 4, 6, 7, 8, 9 }, 2);
        Assert.assertEquals(index, 0);
    }
}
