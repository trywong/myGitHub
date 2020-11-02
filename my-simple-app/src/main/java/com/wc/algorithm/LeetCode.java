package com.wc.algorithm;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        System.out.println(removeDuplicatesII(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 将0移到数组末尾
     * LeetCode.moveElement()
     * @Author wangchuan
     * @Date 2018年1月24日
     * @since
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size;) {
            if (nums[i] == 0) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[size - 1] = 0;
                size--;
            } else {
                i++;
            }
        }
    }

    /**
     * 将0移到数组末尾递归实现
     * LeetCode.moveElement()
     * @Author wangchuan
     * @Date 2018年1月24日
     * @since
     * @param nums
     */
    public static void moveElement1(int start, int end, int[] nums) {
        if (start < end) {
            if (nums[start] == 0) {
                for (int j = start; j < end; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[end] = 0;
                moveElement1(0, end - 1, nums);
            } else {
                moveElement1(start + 1, end, nums);
            }
        }
    }

    /**
     * 删除指定元素，返回剩下数组的长度
     * LeetCode.getSize()
     * @Author wangchuan
     * @Date 2018年1月25日
     * @since
     * @param nums
     * @param removeEle
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        // [2, 2, 1, 5, 2, 3]
        int size = nums.length;
        for (int i = 0; i < size;) {
            if (nums[i] == val) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
            } else {
                i++;
            }
        }
        return size;
    }

    /**
     * 有序数组元素去重，返回剩下数组的长度
     * LeetCode.getSize()
     * @Author wangchuan
     * @Date 2018年1月25日
     * @since
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        // [1, 2, 2, 2, 3, 5]
        int size = nums.length;
        if (size < 2) {
            return size;
        }
        int pre = nums[0];
        for (int i = 1; i < size;) {
            if (pre == nums[i]) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
            } else {
                pre = nums[i];
                i++;
            }
        }
        return size;
    }

    /**
     * 有序数组元素去重，最多保留两个重复元素
     * LeetCode.getSize1()
     * @Author wangchuan
     * @Date 2018年1月25日
     * @since
     * @param nums
     * @return
     */
    public static int removeDuplicatesII(int[] nums) {
        // [1, 2, 2, 2, 3, 3, 5]
        int size = nums.length;
        for (int i = 2; i < size && size > 2;) {
            if (nums[i - 2] == nums[i]) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
            } else {
                i++;
            }
        }
        return size;
    }
}
