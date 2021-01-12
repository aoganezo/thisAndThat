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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	DocumentService docService;
	
	/**
	 * Retrieves the document if it exists in h2, otherwise returns an Exception and logs it.
	 * 
	 * @param title
	 * @return ResponseEntity(Document, HTTPStatus)
	 */
	@GetMapping(value= "/{title}")
	public ResponseEntity<Document> getDocument(@PathVariable String title) {
		log.info("Get call made for: {}", title);
		Document doc = null; //TODO
		return new ResponseEntity<>(doc, HttpStatus.OK);	
	}
	
	/**
	 * Reads the document from the request body and saves it to the database. Returns doc back to user with status 201 - created.
	 * 
	 * @param doc
	 * @return
	 */
	
	@PutMapping
	public ResponseEntity<Document> addDocument(@RequestBody Document doc) {
		log.info("put call made with new document called: {}", doc.getTitle());
		return new ResponseEntity<>(doc, HttpStatus.CREATED);
		
	}
}
