package com.wistful.widgets.api.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wistful.widgets.api.models.Widget;

public interface WidgetRepository extends MongoRepository<Widget, String> {
	public Widget findById(String id);
}
	