package com.wc;

/**
 * @author wangchuan
 * @date 2019-01-20 10:02
 * @since 1.0.0
 */
public class TestCase {
    public static void main(String[] args) {
        TestCase testCase = new TestCase();
        int maxProfit = testCase.maxProfit(new int[]{ 3,2,6,5,0,3 });
        System.out.println(maxProfit);
    }

    /**
     * 思路：顺序遍历，最小值时买入，最高点时卖出。累加差值
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }

        if (prices.length == 1) {
            return 0;
        }

        int maxProfile = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (i == prices.length - 1) {
                // 最后呈上升
                if (prices[i] > prices[i - 1]) {
                    maxProfile += prices[i] - min;
                }
                break;
            }

            // 当前元素比前元素大，且比后元素大，为最高点
            if (prices[i] > min && prices[i] > prices[i + 1]) {
                maxProfile += prices[i] - min;
                continue;
            }

            // 最低点
            if (prices[i - 1] > prices[i] && prices[i + 1] > prices[i]) {
                min = prices[i];
            }
        }

        return maxProfile;
    }
}
