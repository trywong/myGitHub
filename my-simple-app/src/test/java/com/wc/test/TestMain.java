package com.wc.test;

/**
 * @author wangchuan
 * @date 2019-01-16 10:13
 * @since 1.0.0
 */
public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        try {
            testMain.testException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testException() throws Exception {
        try {
            System.out.println("try");

            int i = 2/0;
        } catch (Exception e) {
            System.out.println("exception");
            throw new Exception("my Exception");
        } finally {
            System.out.println("finally");
        }
    }
}
