package com.wc.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * @author wangchuan
 * @date 2020-12-06 13:46
 * @since 1.0.0
 */
public class No15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        // 1. 排序
        Arrays.sort(nums);
        // [-4, -1, -1, 0, 1, 2]

        // 2. 下标i循环，双指针L=i+1，R=n-1，L与R分别向右向左移动
        for (int i = 0; i < nums.length; i++) {
            // 如果大于0，后续元素一定更大，不再循环
            if (nums[i] > 0) {
                return result;
            }
            // 已经循环过的元素不考虑
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    List<Integer> possibleSum = new ArrayList<>();
                    possibleSum.add(nums[i]);
                    possibleSum.add(nums[L]);
                    possibleSum.add(nums[R]);
                    result.add(possibleSum);

                    // 找到一组后，继续找下一组。
                    L++;
                    R--;
                    // 此时需要排重
                    while (L < R && nums[L] == nums[L-1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R+1]) {
                        R--;
                    }
                } else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        No15_3sum no15 = new No15_3sum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = no15.threeSum(nums);
        System.out.println(lists);
    }
}
