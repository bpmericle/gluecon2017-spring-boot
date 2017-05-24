package com.wistful.widgets.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wistful.widgets.api.models.Widget;
import com.wistful.widgets.api.services.SearchService;

@Controller
@EnableAutoConfiguration
public class B2CApiController {
	private static final Logger LOGGER = LoggerFactory.getLogger(B2CApiController.class);
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(path="/widgets", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	List<Widget> findAll() {
    	LOGGER.debug("Searching for all widgets.");
    	
		return searchService.findAll();
	}
	
	@RequestMapping(path="/widgets/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	Widget findById(@PathVariable String id) {
    	LOGGER.debug("Searching for the widget with id: [{}].", id);
    	
		return searchService.findById(id);
	}
}
