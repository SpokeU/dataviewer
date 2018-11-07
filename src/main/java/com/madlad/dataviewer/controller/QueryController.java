package com.madlad.dataviewer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("query")
public class QueryController {

	@GetMapping("/parameters")
	public List<String> parameters(@RequestParam String type) {
		return null;
	}

}
