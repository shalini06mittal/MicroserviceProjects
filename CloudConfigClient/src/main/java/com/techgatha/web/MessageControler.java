package com.techgatha.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageControler {

	@Value("${msg:Cloud config not working, please check}")
	String msg;
	
	@RequestMapping("/message")
	public String getMessage()
	{
		return this.msg;
	}
}
