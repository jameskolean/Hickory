package com.riis.common.rest.dto;

import java.io.Serializable;

public class WorkflowAttributeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Keys {
        HINT,
        TEXT_FIELD_LENGTH,
        TEXT_FIELD_VALIDATION_REGEX,
        DEFAULT_VALUE
    }

    public enum DataTypes {
        BOOLEAN,
        TEXT,
        INTEGER,
        CURRENCY,
        DATE
    }

    private String    id;
    private Keys      key;
    private DataTypes dataType;
    private String    value;


    public WorkflowAttributeDto() {}

    public WorkflowAttributeDto(final String    id,
                                final Keys      key,
                                final DataTypes dataType,
                                final String    value) {
        setId(id);
        setKey(key);
        setDataType(dataType);
        setValue(value);
    }

    public String    getId()       { return id;       }
    public Keys      getKey()      { return key;      }
    public DataTypes getDataType() { return dataType; }
    public String    getValue()    { return value;    }

    public void setId(final       String    id)       { this.id       = id;       }
    public void setKey(final      Keys      key)      { this.key      = key;      }
    public void setDataType(final DataTypes dataType) { this.dataType = dataType; }
    public void setValue(final    String    value)    { this.value    = value;    }

}
