package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatrolsController {
	
	@RequestMapping(value = "/patrols", method = RequestMethod.GET)
	public String patrols() {
		return "patrols";
	}

}
