package com.wistful.widgets.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.wistful.widgets.api.models.Widget;
import com.wistful.widgets.api.services.CreateService;

@Controller
@EnableAutoConfiguration
public class AdminApiController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminApiController.class);

	@Autowired
	private CreateService createService;

	@PostMapping(path="/widgets", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	ResponseEntity<?> create(UriComponentsBuilder builder, @RequestBody Widget widget) {
		LOGGER.debug("Creating new widget: [{}].", widget);

		ResponseEntity<?> response = null;
		try {
			String id = createService.create(widget);
			
			UriComponents uriComponents = 
					builder.path("/widgets/{id}").buildAndExpand(id);
			
			response = ResponseEntity.created(uriComponents.toUri()).build();
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return response;
	}
}
