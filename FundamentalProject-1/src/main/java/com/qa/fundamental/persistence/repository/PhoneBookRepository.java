package com.qa.fundamental.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.fundamental.persistence.domain.PhoneBook;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {
	
	@Query("SELECT c FROM PhoneBook c WHERE c.first_name like %?1% OR c.last_name like %?1%")
	List<PhoneBook> findContactByName(String name);
	
	@Query("SELECT c FROM PhoneBook c WHERE c.phone_number = ?1")
	PhoneBook findContactByPhone(String num);
	
	@Query("SELECT c FROM PhoneBook c WHERE c.email = ?1")
	PhoneBook findContactByEmail(String email);
	
}