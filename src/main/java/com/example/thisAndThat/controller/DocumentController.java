package com.example.thisAndThat.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thisAndThat.Repository.DocumentsRepository;
import com.example.thisAndThat.entity.Document;
import com.example.thisAndThat.service.DocumentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	DocumentService docService;
	
	@Autowired
	DocumentsRepository docRepo;
	
	/**
	 * Retrieves the document if it exists in h2, otherwise returns an Exception and logs it.
	 * 
	 * @param title
	 * @return ResponseEntity(Document, HTTPStatus)
	 */
	@GetMapping(value= "/{docId}")
	public ResponseEntity<Document> getDocument(@PathVariable Integer docId) throws Exception {
		log.info("Get call made for a document with id: {}", docId);
		
		Optional<Document> doc = docRepo.findById(docId); 
		if (doc.isPresent()) {
			return new ResponseEntity<>(doc.get(), HttpStatus.OK);	
		}
		
		else {
			log.error("A document with id {} doesn't exist!", docId);	
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * Reads the document from the request body and saves it to the database. Returns doc back to user with status 201 - created.
	 * A put mapping was used instead of post because a call with the same document will always be the same. 
	 * 
	 * @param doc
	 * @return
	 */
	
	@PutMapping
	public ResponseEntity<Document> addDocument(@RequestBody Document doc) {
		log.info("put call made with new document called: {} with id: {}", doc.getTitle(), doc.getId());
		
		if (docRepo.findById(doc.getId()).isPresent()) {
			log.info("A doc with this id already exists! Please try a new id.");
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		else {
			Document addDoc = new Document(doc.getId(),doc.getTitle(),doc.getContent());
			docRepo.save(doc);
			return new ResponseEntity<>(doc, HttpStatus.NO_CONTENT);
		}
	}
}
