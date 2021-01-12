package com.example.thisAndThat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thisAndThat.entity.Document;
import com.example.thisAndThat.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	DocumentService docService;
	
	Document testDoc = new Document(1,"FirstTitle","What A Long Doc This is");
	
	@GetMapping(value= "/{title}")
	public ResponseEntity<Document> getDocument(@PathVariable String title) {
		return new ResponseEntity<>(testDoc, HttpStatus.OK);	
	}
	
	@PutMapping
	public ResponseEntity<Document> addDocument(@RequestBody Document doc) {
		return new ResponseEntity<>(testDoc, HttpStatus.CREATED);
		
	}
}
