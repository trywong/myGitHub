package com.wc.algorithm;

import org.junit.Test;

/**
 * @author wangchuan
 * @date 2020-10-29 15:04
 * @since 1.0.0
 */
public class TurnOverArray {

    @Test
    public void testPrint() {
        int[][] array = new int[][] {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34}
        };
        print(array);
    }

    public static void print(int[][] array) {
        if (array.length <= 0) {
            return;
        }

        for (int row = 0; row < array.length; row++) {
            int[] currentRow = array[row];
            for (int col = 0; col < currentRow.length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }

        int[] firstRow = array[0];
        for (int col = 0; col < firstRow.length; col++) {
            for (int row = 0; row < array.length; row++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }
}
