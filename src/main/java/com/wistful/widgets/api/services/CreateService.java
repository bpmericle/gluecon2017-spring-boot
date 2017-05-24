package com.wistful.widgets.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wistful.widgets.api.data.WidgetRepository;
import com.wistful.widgets.api.models.Widget;

@Service
public class CreateService {
	@Autowired
	private WidgetRepository repository;
	
	/**
	 * 
	 * @param widget
	 * @return
	 */
	public String create(Widget widget) {
		return repository.save(widget).getId();
	}
}
