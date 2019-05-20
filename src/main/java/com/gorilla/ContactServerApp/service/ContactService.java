package com.gorilla.ContactServerApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gorilla.ContactServerApp.entity.ContactEntity;
import com.gorilla.ContactServerApp.model.ContactRequest;
import com.gorilla.ContactServerApp.model.ContactResponse;
import com.gorilla.ContactServerApp.repository.ContactRepository;

/**
 * Contact Service
 * @author ihuaylupo
 *
 */

@Service
public class ContactService {

	@Autowired
	ContactRepository repository;

	/**
	 * Method that inserts a contact into the database
	 * @return contactResponse
	 */
	public ContactResponse createContact(ContactRequest contactRequest) {
		ContactResponse contactResponse = null;
		ContactEntity entity = null;

		entity = convertRequest(contactRequest);
		entity =  repository.save(entity);
		contactResponse = convertResponse(entity);

		return contactResponse;
	}
	
	/**
	 * Method that updates a contact into the database
	 * @return contactResponse
	 */
	public ContactResponse updateContact(ContactRequest contactRequest) {
		ContactResponse contactResponse = null;
		ContactEntity entity = null;

		entity = convertRequest(contactRequest);
		entity =  repository.save(entity);
		contactResponse = convertResponse(entity);

		return contactResponse;
	}

	/**
	 * Method that deletes an specific contact
	 * @param id
	 */
	public void deleteContact(String id) {
		repository.deleteById(id);
	}
	
	
	/**
	 * Find by Id
	 * @param id
	 * @return responses
	 */
	public ContactResponse findById(String id) {
		ContactEntity result = null;
		ContactResponse response = null;
		
		result = repository.findById(id).orElse(null);
		response = convertResponse(result);
		
		return response;
	}

	/**
	 * Find all contacts
	 * @return responses
	 */
	@CrossOrigin
	public List<ContactResponse> findAll(){
		List<ContactEntity> results = null;
		List<ContactResponse> responses = null;
		
		results = (List<ContactEntity>) repository.findAll();
		responses = convertResponses(results);
		
		return responses;
	}

	/**
	 * Method that converts several requests into entities
	 * @param contactRequests
	 * @return entities
	 */
	public List<ContactEntity> convertRequests(List<ContactRequest> contactRequests){
		List<ContactEntity> entities = null;
		if(null != contactRequests) {
			entities = new ArrayList<>(contactRequests.size());
			for(ContactRequest request : contactRequests) {
				ContactEntity entity = convertRequest(request);
				entities.add(entity);			
			}
		}
		
		return entities;
	}
	
	/**
	 * Method that converts several entities into responses
	 * @param entities
	 * @return responses 
	 */
	public List<ContactResponse> convertResponses(List<ContactEntity> entities){
		List<ContactResponse> responses = null;
		if(null != entities) {
			responses = new ArrayList<>(entities.size());
			for(ContactEntity entity : entities) {
				ContactResponse response = convertResponse(entity);
				responses.add(response);			
			}
		}
		
		return responses;
	}

	/**
	 * Converts a request into a entity object
	 * @param contactRequest
	 * @return entity - ContactEntity
	 */
	public ContactEntity convertRequest(ContactRequest contactRequest) {
		ContactEntity entity = null;

		entity = new ContactEntity();
		entity.setEmail(contactRequest.getEmail());
		entity.setId(contactRequest.getId());
		entity.setLastName(contactRequest.getLastName());
		entity.setName(contactRequest.getName());
		entity.setPhoneNumber(contactRequest.getPhone());

		return entity;
	}

	/**
	 * Converts an entity into a response model.
	 * @param entity
	 * @return resonse - ContactResponse
	 */
	public ContactResponse convertResponse(ContactEntity entity) {
		ContactResponse response = null;

		response = new ContactResponse();
		response.setEmail(entity.getEmail());
		response.setId(entity.getId());
		response.setLastName(entity.getLastName());
		response.setName(entity.getName());
		response.setPhone(entity.getPhoneNumber());

		return response;

	}

}
