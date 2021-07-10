package com.anil.demo11.controller.num2words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anil.demo11.domainobject.num2words.Num2Words;
import com.anil.demo11.service.num2words.Num2WordsService;

@RestController
public class Num2WordsController {
	
	@Autowired
	private Num2WordsService num2WordsService;
		
	@GetMapping("/num2words")
	public Num2Words num2words(@RequestParam(value = "num", defaultValue = "0") int number) {
		Num2Words num2Words = num2WordsService.getInWords(number);
		return num2Words;
	}

}
