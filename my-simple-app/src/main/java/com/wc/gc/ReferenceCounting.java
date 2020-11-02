package com.wc.gc;

/**
 * 引用计数法
 * @author shovel
 * @date 2018/12/23 17:44
 * @since 1.0.0
 */
public class ReferenceCounting {
    private Object obj = null;

    /**分配一个2M的内存，以便在GC日志中看清是否被回收过*/
    private byte[] bigSize = new byte[2 * 1024 * 1024];

    public static void testGC() {
        ReferenceCounting countingA = new ReferenceCounting();
        ReferenceCounting countingB = new ReferenceCounting();

        countingA.obj = countingB;
        countingB.obj = countingA;

        countingA = null;
        countingB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
