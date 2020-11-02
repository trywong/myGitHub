package com.wc.lamda;

/**
 * @author wangchuan
 * @date 2019-03-10 12:42
 * @since 1.0.0
 */
public class FatherClass {
    private Long id;
    private String cT;
    private String uT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcT() {
        return cT;
    }

    public void setcT(String cT) {
        this.cT = cT;
    }

    public String getuT() {
        return uT;
    }

    public void setuT(String uT) {
        this.uT = uT;
    }

    /*@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }*/
}
