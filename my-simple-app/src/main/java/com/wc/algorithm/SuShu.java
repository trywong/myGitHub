package com.wc.algorithm;

/**
 * 
 * <一句话描述>
 *
 * @Description <详细描述>
 * @See <接口/父类>
 * @author wangchuan E-mail:wulacao@7lk.com
 * @version 2017年2月8日 下午6:35:46 by wangchuan
 */
public class SuShu {
    private int intVal;
    private String strVal;
    
    /**
     * 
     * 是否是素数
     * 
     * @param number 判断的数字
     * @return Boolean 如果是素数，返回true；否则返回false
     * @Throws 异常信息
     * @History 2017年2月8日 下午6:24:51 by wangchuan
     */
    
    /**
     * 
     * <一句话简述>
     * 
     * <详细描述>
     *
     * @param 
     * @return <返回值描述>
     * @Throws 异常信息
     * @History 2017年2月8日 下午6:30:13 by wangchuan
     */
    
    /**
     * 
     * <一句话简述>
     * 
     * <详细描述>
     *
     * @param number
     * @return
     * @Throws 异常信息
     * @History 2017年2月8日 下午6:34:31 by wangchuan
     */
    private static boolean isSuShu(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isSuShu(i)) {
                System.out.println(i);
            }
        }
    }

    public int getIntVal() {
        return intVal;
    }
    
    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStrVal() {
        return strVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }
}
