package com.madlad.dataviewer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madlad.dataviewer.model.ConnectionType;

@RestController
public class ConnectionTypeController {

	@GetMapping("connection-types")
	public List<ConnectionType> getAllTypes() {
		return Arrays.asList(ConnectionType.values());
	}
	
}
