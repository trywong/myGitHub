package com.wc.algorithm.leetcode;

/**
 * 有序数组的平方
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * @author wangchuan
 * @date 2020-12-06 10:59
 * @since 1.0.0
 */
public class No977_squaringSortedArray {
    /**
     * 现象：从正负分界处，往两端，平方值逐渐增大
     * 解决：利用双指针，从两端往中间，逆序放置到结果数组
     *
     *
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        // 只能跳动一个指针，选平方值大的指针跳
        for (int left = 0, right = nums.length - 1, index = nums.length - 1; left <= right;) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }

        // 以下逻辑废弃：不能双指针同时跳，反例：[-6, -4, 0, 2, 3]
        /*while (left < right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                result[--index] = rightSquare;
            } else {
                result[index] = rightSquare;
                result[--index] = leftSquare;
            }
            left++;
            right--;
            index--;
        }
        if (left == right) {
            result[index] = nums[left] * nums[left];
        }*/
        return result;
    }

    public static void main(String[] args) {
        No977_squaringSortedArray no977 = new No977_squaringSortedArray();
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] result = no977.sortedSquares(nums);
        for (int ele : result) {
            System.out.print(ele + " ");
        }
    }
}
