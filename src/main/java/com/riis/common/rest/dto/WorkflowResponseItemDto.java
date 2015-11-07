package com.riis.common.rest.dto;

import java.io.Serializable;

public class WorkflowResponseItemDto implements Serializable {

    private static final long serialVersionUID = -3707712057940241637L;

    private String      id;
    private String      label;
    private AnswerType  answerType;
    private String      answer;
    private WorkflowDto workflow;


    public WorkflowResponseItemDto() {
    }

    public WorkflowResponseItemDto(AnswerType answerType) {
        this.answerType = answerType;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public String getAnswer() {
        return answer;
    }

    public WorkflowDto getWorkflow() {
        return workflow;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setWorkflow(WorkflowDto workflow) {
        this.workflow = workflow;
    }

}
