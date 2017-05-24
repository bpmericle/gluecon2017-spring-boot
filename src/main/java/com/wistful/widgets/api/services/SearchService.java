package com.wistful.widgets.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wistful.widgets.api.data.WidgetRepository;
import com.wistful.widgets.api.models.Widget;

/**
 * 
 * @author brian.mericle
 *
 */
@Service
public class SearchService {
	
	@Autowired
	private WidgetRepository repository;
	
	/**
	 * 
	 * @return
	 */
	public List<Widget> findAll() {
		return repository.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Widget findById(String id) {
		return repository.findById(id);
	}
}
