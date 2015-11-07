package com.riis.WorkflowExample.business.service.rest;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.riis.common.rest.dto.WorkflowAttributeDto;
import com.riis.common.rest.dto.WorkflowAttributeDto.DataTypes;
import com.riis.common.rest.dto.WorkflowDataType;
import com.riis.common.rest.dto.WorkflowDto;
import com.riis.common.rest.dto.WorkflowResponseDto;
import com.riis.common.rest.dto.WorkflowType;

/**
 * RESTful interface to workflow services.
 */
@Controller
public class WorkflowServiceRest {

	@Autowired
	ObjectMapper objectMapper;

	@ResponseBody
	@RequestMapping(value = "/rest/workflow-responses", method = RequestMethod.POST, produces = { "application/json" })
	public WorkflowResponseDto createWorkflowResponse(@RequestBody final WorkflowResponseDto workflowResponse)
			throws IOException {
		final File file = new File("json/out/workflow.json");
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.writeValue(file, workflowResponse);
		return workflowResponse;
	}

	@RequestMapping(value = "/rest/workflows/{workflowType}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public WorkflowDto getWorkflow(@PathVariable("workflowType") final WorkflowType workflowType)
			throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(new File("json/in/workflow.json"), WorkflowDto.class);
	}

	@RequestMapping(value = "/rest/workflows/build/default", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String init() throws JsonParseException, JsonMappingException, IOException {
		final WorkflowDto workflowDto = new WorkflowDto();
		workflowDto.setDataType(WorkflowDataType.TEXT);
		workflowDto.setId("WF-ID-01");
		workflowDto.setLabel("Sample Label");
		workflowDto.setMandatory(true);
		final WorkflowDto child = new WorkflowDto();
		workflowDto.setChildren(Lists.newArrayList());
		workflowDto.getChildren().add(child);
		child.setDataType(WorkflowDataType.BOOLEAN);
		child.setId("WF-ID-02");
		child.setLabel("Sample Child Label");
		child.setMandatory(false);
		final WorkflowAttributeDto workflowAttributeDto = new WorkflowAttributeDto();
		workflowDto.setWorkflowAttributes(Lists.newArrayList());
		workflowDto.getWorkflowAttributes().add(workflowAttributeDto);
		workflowAttributeDto.setDataType(DataTypes.BOOLEAN);
		workflowAttributeDto.setId("WFA-ID-01");
		workflowAttributeDto.setKey(WorkflowAttributeDto.Keys.HINT);
		workflowAttributeDto.setValue("value");
		workflowDto.setWorkflowResponses(Lists.newArrayList());
		workflowDto.getWorkflowResponses().add(new WorkflowResponseDto("label", "answer"));

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.writeValue(new File("json/in/workflow.json"), workflowDto);

		return "Success";
	}

}
