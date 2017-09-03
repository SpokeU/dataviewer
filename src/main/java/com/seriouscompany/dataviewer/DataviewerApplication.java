package com.seriouscompany.dataviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DataviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataviewerApplication.class, args);
	}

	@RequestMapping(path = "/")
	public String home(){
        return "index";
    }
}
