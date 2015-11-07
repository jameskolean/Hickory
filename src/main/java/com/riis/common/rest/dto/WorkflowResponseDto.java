package com.riis.common.rest.dto;

import java.io.Serializable;
import java.util.List;

public class WorkflowResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String                    id;
    private String                    label;
    private String                    answer;
    private WorkflowDto               workflow;
    private List<WorkflowResponseDto> children;

    public WorkflowResponseDto() {
        super();
    }

    public WorkflowResponseDto(final String label, final String answer) {
        super();
        this.label = label;
        this.setAnswer(answer);
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getAnswer() {
        return answer;
    }

    public WorkflowDto getWorkflow() {
        return workflow;
    }

    public List<WorkflowResponseDto> getChildren() {
        return children;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public void setWorkflow(final WorkflowDto workflow) {
        this.workflow = workflow;
    }

    public void setChildren(final List<WorkflowResponseDto> children) {
        this.children = children;
    }

}
