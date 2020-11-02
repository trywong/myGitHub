package com.wc.lamda;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author wangchuan
 * @date 2019-03-10 12:43
 * @since 1.0.0
 */
public class ChildClass extends FatherClass {
    private String cT;
    private String uT;

    private Integer count;

    @Override
    public String getcT() {
        return cT;
    }

    @Override
    public void setcT(String cT) {
        this.cT = cT;
    }

    @Override
    public String getuT() {
        return uT;
    }

    @Override
    public void setuT(String uT) {
        this.uT = uT;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
