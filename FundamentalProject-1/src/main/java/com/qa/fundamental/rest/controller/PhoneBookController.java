package com.qa.fundamental.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import com.qa.fundamental.persistence.domain.PhoneBook;
import com.qa.fundamental.service.PhoneBookService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/phonebook")
public class PhoneBookController {
	
	/*
	 * passes things to the service
	 */
	private PhoneBookService service;
	
	
    /*
     *  Service dependency injection
     */
	@Autowired
	public PhoneBookController(PhoneBookService service) {
		super();
		this.service = service;
	}
	
	/*
	 * Create new contact
	 */
	@PostMapping("/create")
	public ResponseEntity<PhoneBook> create(@RequestBody PhoneBook contact){
		PhoneBook new_contact = this.service.create(contact);
		return new ResponseEntity<PhoneBook>(new_contact, HttpStatus.CREATED);
	}
	
	
	/*
	 *  Read All contacts
	 */
	@GetMapping("/readAll")
	public ResponseEntity<List<PhoneBook>> readAll(){
		return ResponseEntity.ok(this.service.readAll()); 
	}
	
	
	/*
	 * Read by ID
	 */
	@GetMapping("/read/id/{id_}")
	public ResponseEntity<PhoneBook> readById(@PathVariable Long id_) {
		PhoneBook contact = this.service.readById(id_);
		return ResponseEntity.ok(contact);
	}
	
	/*f
	 * Read by name
	 */
	@GetMapping("/read/name/{name_}")
	public ResponseEntity<List<PhoneBook>> readByName(@PathVariable String name_) {
		return ResponseEntity.ok(this.service.readByName(name_));
	}
	
	/*
	 * Read by email
	 */
	@GetMapping("read/email/{email_}")
	public ResponseEntity<PhoneBook> readByEmail(@PathVariable String email_){
		return ResponseEntity.ok(this.service.readByEmail(email_));
	}
	
	/*
	 * Read by Phone number
	 */
	@GetMapping("read/phone/{num}")
	public ResponseEntity<PhoneBook> readByNumber(@PathVariable String num){
		return ResponseEntity.ok(this.service.readByPhone(num));
	}
	
	/*
	 * Update phone number by ID
	 */
	
	@PatchMapping("/update/phone/{id}")
	public ResponseEntity<PhoneBook> updateNum(@PathVariable("id") Long id, @RequestBody String num){
		PhoneBook updated_contact = this.service.updateNumById(id, num);
		return new ResponseEntity<PhoneBook>(updated_contact, HttpStatus.ACCEPTED);
	}
	
	/*
	 * Update first name by ID
	 */
	@PatchMapping("/update/first-name/{id}")
	public ResponseEntity<PhoneBook> updateFirstName(@PathVariable("id") Long id, @RequestBody String name){
		PhoneBook updated_contact = this.service.updateFirstNameById(id, name);
		return new ResponseEntity<PhoneBook>(updated_contact, HttpStatus.ACCEPTED);
	}
	
	/*
	 * Update last name by ID
	 */
	@PatchMapping("/update/last-name/{id}")
	public ResponseEntity<PhoneBook> updateLastName(@PathVariable("id") Long id, @RequestBody String name){
		PhoneBook updated_contact = this.service.updateLastNameById(id, name);
		return new ResponseEntity<PhoneBook>(updated_contact, HttpStatus.ACCEPTED);
	}
	
	/*
	 * Update email by ID
	 */
	@PatchMapping("/update/email/{id}")
	public ResponseEntity<PhoneBook> updateEmail(@PathVariable("id") Long id, @RequestBody String email){
		PhoneBook updated_contact = this.service.updateEmailById(id, email);
		return new ResponseEntity<PhoneBook>(updated_contact, HttpStatus.ACCEPTED);
	}
	
	/*
	 * Delete by ID
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PhoneBook> delteById(@PathVariable Long id) {
		
		if (this.service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
}
