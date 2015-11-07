package com.riis.common.rest.dto;

import java.io.Serializable;


public abstract class SimpleAttributeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String key;
    private String value;

    public SimpleAttributeDto() {
    }

    public SimpleAttributeDto(final String id, final String key, final String value) {
        setId(id);
        setKey(key);
        setValue(value);
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public void setValue(final String value) {
        this.value = value;
    }

}
