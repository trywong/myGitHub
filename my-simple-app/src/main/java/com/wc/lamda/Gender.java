package com.wc.lamda;

import org.apache.commons.lang3.StringUtils;

public enum Gender {
    MAN ("男", 1),
    WOMAN ("女", 2),
    UNKOWN ("未知", 0);

    private String type;
    private Integer value;

    private Gender(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public Integer getGenderValue(String type) {
        if (StringUtils.isEmpty(type)) {
            return UNKOWN.value;
        }

        for (Gender gender : Gender.values()) {
            if (type.equals(gender.type)) {
                return gender.value;
            }
        }

        return UNKOWN.value;
    }

    public String getGenderDesc(Integer value) {
        if (value == null) {
            return UNKOWN.type;
        }

        for (Gender gender : Gender.values()) {
            if (value.equals(gender.value)) {
                return gender.type;
            }
        }

        return UNKOWN.type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
