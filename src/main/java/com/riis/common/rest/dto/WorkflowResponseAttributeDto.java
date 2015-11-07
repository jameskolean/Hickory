package com.riis.common.rest.dto;

import java.io.Serializable;

public class WorkflowResponseAttributeDto extends WorkflowAttributeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public WorkflowResponseAttributeDto() { }

    public WorkflowResponseAttributeDto(final String    id,
                                        final Keys      key,
                                        final DataTypes dataType,
                                        final String    value) {
        setId(id);
        setKey(key);
        setDataType(dataType);
        setValue(value);
    }

}
