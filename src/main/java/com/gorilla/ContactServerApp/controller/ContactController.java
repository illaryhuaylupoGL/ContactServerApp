/**
 * 
 */
package com.gorilla.ContactServerApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gorilla.ContactServerApp.model.ContactRequest;
import com.gorilla.ContactServerApp.model.ContactResponse;
import com.gorilla.ContactServerApp.service.ContactService;

/**
 * Contacts controller
 * @author ihuaylupo
 */

@CrossOrigin()
@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	ContactService service;
	
	@RequestMapping(value="/{contact_id}", method = RequestMethod.GET)
	public ResponseEntity<ContactResponse> getContact(@PathVariable(value="contact_id") String contactId){
		ContactResponse response = null;			
		response = service.findById(contactId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<ContactResponse>>  getContacts(){
		List<ContactResponse> responses = null;		
		responses = service.findAll();
		return ResponseEntity.ok(responses);
	}
	
	@PostMapping()
	public ResponseEntity<ContactResponse> createContact(@RequestBody ContactRequest request){
		ContactResponse response = null;		
		response = service.createContact(request);
		return ResponseEntity.ok(response);
	}

	
	@PatchMapping()
	public ResponseEntity<ContactResponse> updateContact(@RequestBody ContactRequest request){
		ContactResponse response = null;
		response = service.updateContact(request);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value="/{contact_id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContact(@PathVariable(value="contact_id") String contactId){
		service.deleteContact(contactId);
		return ResponseEntity.ok("Deleted");
	} 
}
