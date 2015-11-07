package com.riis.common.rest.dto;

import java.io.Serializable;
import java.util.List;

public class WorkflowResponseGroupDto implements Serializable {

    private static final long serialVersionUID = -843010430817009247L;

    private List<WorkflowResponseItemDto> items;

    public List<WorkflowResponseItemDto> getItems() {
        return items;
    }

    public void setItems(List<WorkflowResponseItemDto> items) {
        this.items = items;
    }

}
