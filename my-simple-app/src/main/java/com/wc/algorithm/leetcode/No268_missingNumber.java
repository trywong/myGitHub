package com.wc.algorithm.leetcode;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 进阶：
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 *
 * @author wangchuan
 * @date 2020-12-07 10:05
 * @since 1.0.0
 */
public class No268_missingNumber {
    public int missingNumber(int[] nums) {
        // 方法一：异或     参考题解  最优解
        /*
        int missingNum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNum ^= i ^ nums[i];
        }
        return missingNum;
        */

        // 方法二：Hash
        /*Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;*/

        // 方法三：数学公式sum=n*(n+1)/2，求和sum1和sum2，sum1与sum2相减
        int sum = nums.length*(nums.length+1)/2;
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        return sum - sum1;
    }

    public static void main(String[] args) {
        No268_missingNumber no268 = new No268_missingNumber();
        int missingNumber = no268.missingNumber(new int[]{3, 1, 4, 0});
        System.out.println(missingNumber);
    }
}
