package com.wc.effectivejava;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 保护性拷贝
 * @author wangchuan  E-mail:wulacao@7lk.com
 * @version 2016年12月9日 下午2:29:51
 *
 */
public class Period {
    private Date start;
    private Date end;
    public Period(Date start, Date end) throws Exception {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("开始时间比结束时间晚！");
        }
        /*
         * 此方式，会造成构造完对象之后，start或者end对象还可以改变
         * 造成跳过上面的异常检测！！
         */
        //this.start = start;
        //this.end = end;
    }
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = null;
        try {
            p = new Period(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        end.setYear(78);
        
        System.out.println(end);
        System.out.println(p.getEnd());
    }
}
