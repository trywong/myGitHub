package com.wc.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangchuan
 * @date 2020-10-03 19:23
 * @since 1.0.0
 */
public class StringCacheTest {

    @Test
    public void testCache() {
        String shortString1 = "aaa";
        String shortString2 = "aaa";
        Assert.assertTrue(shortString1 == shortString2);
        String longString1 = "dsfasdfadsfasdfasdf324tredfasdfasdfasdfasdfasdfasdfasdaaaadfadsfasdfasdfasdfasdfasdfasdfasfasdfasdfasdfa";
        String longString2 = "dsfasdfadsfasdfasdf324tredfasdfasdfasdfasdfasdfasdfasdaaaadfadsfasdfasdfasdfasdfasdfasdfasfasdfasdfasdfa";
        Assert.assertTrue(longString1 == longString2);
    }
}
