package com.wc.algorithm.leetcode;

/**
 * 删除排序数组中的重复项
 * leetcode #26
 *
 * 解决思路：快慢指针
 */
public class No26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int realIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[realIndex]) {
                nums[++realIndex] = nums[i];
            }
        }
        return realIndex + 1;
    }

    public static void main(String[] args) {
        No26_removeDuplicates no26 = new No26_removeDuplicates();
        int[] nums = new int[]{0,0,0,0,1,1,2,2,2,3,3};
        int lenth = no26.removeDuplicates(nums);
        for (int i = 0; i < lenth; i++) {
            System.out.println(nums[i]);
        }
    }
}