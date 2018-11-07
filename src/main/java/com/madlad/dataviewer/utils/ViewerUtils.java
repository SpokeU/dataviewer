package com.madlad.dataviewer.utils;

import java.util.List;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.model.ConnectionType;

public class ViewerUtils {

	public static Dataviewer<?, ?> findByType(List<Dataviewer<?, ?>> viewers, ConnectionType type) {
		return viewers.stream().filter(v -> v.type().equals(type)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No provider for type: " + type + " found"));
	}

}
