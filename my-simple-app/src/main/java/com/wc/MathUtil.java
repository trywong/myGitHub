/**
 * 
 */
package com.wc;

import java.math.BigDecimal;

/**
 * @Description 概述
 * @author guoyongxiang E-mail: xianshu@qlk.com
 * @version 2015-6-29 下午11:27:25 by guoyongxiang
 */
public class MathUtil {

    /** 货币的保留小数 */
    public static final int MONEY_POINT = 4;

    /**
     * BigDecimal 相加
     * @param v1
     * @param v2
     * @return
     */
    public static Double add(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return n1.add(n2).doubleValue();
    }

    /**
     * BigDecimal 相减
     * @param v1
     * @param v2
     * @return
     */
    public static Double subtract(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return n1.subtract(n2).doubleValue();
    }

    /**
     * BigDecimal 相乘
     * @param v1
     * @param v2
     * @return
     */
    public static Double multiply(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return n1.multiply(n2).doubleValue();
    }

    /**
     * BigDecimal 连环乘
     * @param v1
     * @param params
     * @return
     * @history 2015年11月23日 下午6:03:57 by Gaoll
     */
    public static Double multiply(double v1, double... params) {
        BigDecimal num1 = new BigDecimal(Double.toString(v1));
        BigDecimal result = num1;
        if (null != params && params.length > 0) {
            for (double numX : params) {
                BigDecimal temp = new BigDecimal(Double.toString(numX));
                result = result.multiply(temp);
            }
        }
        return result.doubleValue();
    }

    public static Double multiply(Double v1, Double... params) {
        BigDecimal num1 = new BigDecimal(v1.toString());
        BigDecimal result = num1;
        if (null != params && params.length > 0) {
            for (double numX : params) {
                BigDecimal temp = new BigDecimal(Double.toString(numX));
                result = result.multiply(temp);
            }
        }
        return result.doubleValue();
    }

    /**
     * BigDecimal 相除
     * @param v1
     * @param v2
     * @return
     */
    public static Double divide(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return n1.divide(n2, MONEY_POINT, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("01");
        BigDecimal bigDecimal1 = new BigDecimal("1");
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }
}
