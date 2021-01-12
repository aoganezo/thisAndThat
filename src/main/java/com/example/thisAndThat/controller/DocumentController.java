package com.example.thisAndThat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thisAndThat.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	DocumentService docService;
	
	@GetMapping
	public void getDocument() {
		
	}
	
	@PutMapping
	public void addDocument() {
		
	}
}
