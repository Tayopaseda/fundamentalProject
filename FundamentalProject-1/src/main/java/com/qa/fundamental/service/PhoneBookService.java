package com.qa.fundamental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.fundamental.persistence.domain.PhoneBook;
import com.qa.fundamental.persistence.repository.PhoneBookRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookService {
	
	private PhoneBookRepository repo;

	@Autowired
	public PhoneBookService(PhoneBookRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public PhoneBook create(PhoneBook contact) {
		return this.repo.save(contact);
		
	}
	
	public List<PhoneBook> readAll(){
		List<PhoneBook> contacts = this.repo.findAll();
		return contacts;
	}
	
	public PhoneBook readById(Long id) {
		Optional<PhoneBook> contact = this.repo.findById(id);
		return contact.get();
	}
	
	public List<PhoneBook> readByName(String name) {
		return this.repo.findContactByName(name);
	}
	
	public PhoneBook readByPhone(String num) {
		return this.repo.findContactByPhone(num);
	}
	
	public PhoneBook readByEmail(String email) {
		return this.repo.findContactByEmail(email);
	}
	
//	public PhoneBook updateById(Long id, PhoneBook contact) {
//		Optional<PhoneBook> op = this.repo.findById(id);
//		PhoneBook old = op.get();
//		old.setFirst_name(contact.getFirst_name());
//		old.setLast_name(contact.getLast_name());
//		old.setPhone_number(contact.getPhone_number());
//		old.setEmail(contact.getEmail());
//		
//		return this.repo.save(old);	
//	}
//	
	public PhoneBook updateNumById(Long id, String num) {
		Optional<PhoneBook> op = this.repo.findById(id);
		PhoneBook old = op.get();
		old.setPhone_number(num);
		return this.repo.save(old);
	}
	
	public PhoneBook updateFirstNameById(Long id, String name) {
		Optional<PhoneBook> op = this.repo.findById(id);
		PhoneBook old = op.get();
		old.setFirst_name(name);
		return this.repo.save(old);
	}
	
	public PhoneBook updateLastNameById(Long id, String name) {
		Optional<PhoneBook> op = this.repo.findById(id);
		PhoneBook old = op.get();
		old.setLast_name(name);
		return this.repo.save(old);
	}
	
	public PhoneBook updateEmailById(Long id, String email) {
		Optional<PhoneBook> op = this.repo.findById(id);
		PhoneBook old = op.get();
		old.setEmail(email);
		return this.repo.save(old);
	}
	
	public boolean deleteById(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
		
	}
	
	
	
}
