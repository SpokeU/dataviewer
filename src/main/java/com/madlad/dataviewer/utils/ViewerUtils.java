package com.madlad.dataviewer.utils;

import java.util.Collections;
import java.util.List;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.model.ConnectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViewerUtils {

	@Autowired
	private List<Dataviewer<?, ?>> viewers;

	public List<Dataviewer<?, ?>> findAll(){
		return Collections.unmodifiableList(viewers);
	}

	public Dataviewer findByType(ConnectionType type) {
		return viewers.stream().filter(v -> v.type().equals(type)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No provider for type: " + type + " found"));
	}

}
