package com.riis.common.rest.dto;

import java.io.Serializable;
import java.util.List;

public class WorkflowDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String                     id;
    private WorkflowDataType           dataType;
    private boolean                    mandatory;
    private String                     label;
    private List<WorkflowAttributeDto> workflowAttributes;
    private List<WorkflowResponseDto>  workflowResponses;
    private List<WorkflowDto>          children;


    public WorkflowDto() {}

    public WorkflowDto(final String id,
                       final WorkflowDataType dataType,
                       final boolean mandatory,
                       final String label,
                       final List<WorkflowAttributeDto> attributes) {
        setId(id);
        setDataType(dataType);
        setMandatory(mandatory);
        setLabel(label);
        setWorkflowAttributes(attributes);
    }

    public String getId() {
        return id;
    }

    public WorkflowDataType getDataType() {
        return dataType;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public String getLabel() {
        return label;
    }

    public List<WorkflowAttributeDto> getWorkflowAttributes() {
        return workflowAttributes;
    }

    public List<WorkflowResponseDto> getWorkflowResponses() {
        return workflowResponses;
    }

    public List<WorkflowDto> getChildren() {
        return children;
    }

    public void setDataType(final WorkflowDataType dataType) {
        this.dataType = dataType;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setMandatory(final boolean mandatory) {
        this.mandatory = mandatory;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public void setWorkflowAttributes(final List<WorkflowAttributeDto> workflowAttributes) {
        this.workflowAttributes = workflowAttributes;
    }

    public void setWorkflowResponses(final List<WorkflowResponseDto> workflowResponses) {
        this.workflowResponses = workflowResponses;
    }

    public void setChildren(final List<WorkflowDto> children) {
        this.children = children;
    }

    public String findFirstAttribute(final WorkflowAttributeDto.Keys key) {

        if (key != null && workflowAttributes != null) {
            for (WorkflowAttributeDto attribute : workflowAttributes) {
                if (key == attribute.getKey()) return attribute.getValue();
            }
        }

        return null;
    }


}
