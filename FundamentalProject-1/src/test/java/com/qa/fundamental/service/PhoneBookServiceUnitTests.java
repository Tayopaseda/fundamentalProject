package com.qa.fundamental.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.fundamental.persistence.domain.PhoneBook;
import com.qa.fundamental.persistence.repository.PhoneBookRepository;


@SpringBootTest
@ActiveProfiles("test")
public class PhoneBookServiceUnitTests {

	@Autowired
	private PhoneBookService service;
	
	@MockBean
	private PhoneBookRepository repo;
	
	private PhoneBook contact_1 = new PhoneBook(1L,"jimmy", "Giant", "+2345353532", "hardy@tomsnet.com");
	private PhoneBook contact_2 = new PhoneBook(2L,"sarah", "smartypants", "+1111111532", "S@pants.com");
	private PhoneBook contact_3 = new PhoneBook(3L,"lucy", "La", "+44445353532", "LaLaLucy@gmail.com");
	
	
	
	
	
	
	
	@Test
	void testCreate() {
		Mockito.when(this.repo.save(new PhoneBook("jimmy", "Giant", "+2345353532", "hardy@tomsnet.com"))).thenReturn(contact_1);
		Assertions.assertThat(this.service.create(new PhoneBook("jimmy", "Giant","+2345353532", "hardy@tomsnet.com"))).isEqualTo(contact_1);
		Mockito.verify(this.repo, Mockito.times(1)).save(new PhoneBook("jimmy", "Giant", "+2345353532", "hardy@tomsnet.com"));
	}
	
	@Test
	void testReadAll() {
		List<PhoneBook> test_contacts = new ArrayList<PhoneBook>();
		test_contacts.add(contact_1);
		test_contacts.add(contact_2);
		test_contacts.add(contact_3);
		Mockito.when(this.repo.findAll()).thenReturn(test_contacts);
		Assertions.assertThat(this.service.readAll()).isEqualTo(test_contacts);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testReadById() {
		Optional<PhoneBook> op = Optional.ofNullable(contact_1);
		Mockito.when(this.repo.findById(1L)).thenReturn(op);
		Assertions.assertThat(this.service.readById(1L)).isEqualTo(contact_1);
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
	
	@Test
	void testReadByName() {
		List<PhoneBook> list = new ArrayList<PhoneBook>();
		list.add(contact_3);
		Mockito.when(this.repo.findContactByName("lucy")).thenReturn(list);
		Assertions.assertThat(this.service.readByName("lucy")).isEqualTo(list);
		Mockito.verify(this.repo, Mockito.times(1)).findContactByName("lucy");
	}
	
	@Test
	void testReadByPhone() {
		Mockito.when(this.repo.findContactByPhone("+11113453532")).thenReturn(contact_2);
		Assertions.assertThat(this.service.readByPhone("+11113453532")).isEqualTo(contact_2);
		Mockito.verify(this.repo, Mockito.times(1)).findContactByPhone("+11113453532");
	}
	
	@Test
	void testReadByEmail() {
		Mockito.when(this.repo.findContactByEmail("S@pants.com")).thenReturn(contact_2);
		Assertions.assertThat(this.service.readByEmail("S@pants.com")).isEqualTo(contact_2);
		Mockito.verify(this.repo, Mockito.times(1)).findContactByEmail("S@pants.com");
	}
	
	@Test
	void testUpdateById() {
		Optional<PhoneBook> op = Optional.ofNullable(contact_1);
		Mockito.when(this.repo.findById(1L)).thenReturn(op);
		
	}
	
	@Test
	void testUpdateNumById() {
		Optional<PhoneBook> op = Optional.ofNullable(contact_1);
		Mockito.when(this.repo.findById(1L)).thenReturn(op);
		Mockito.when(this.repo.save(new PhoneBook(1L,"jimmy", "Giant", "+1234567", "hardy@tomsnet.com"))).thenReturn(new PhoneBook(1L,"jimmy", "Giant", "+1234567", "hardy@tomsnet.com"));
		Assertions.assertThat(this.service.updateNumById(1L, "+1234567")).isEqualTo(new PhoneBook(1L,"jimmy", "Giant", "+1234567", "hardy@tomsnet.com"));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(new PhoneBook(1L,"jimmy", "Giant", "+1234567", "hardy@tomsnet.com"));
	}
	
	@Test
	void testUpdateEmailById() {
		Optional<PhoneBook> op = Optional.ofNullable(contact_1);
		Mockito.when(this.repo.findById(1L)).thenReturn(op);
		Mockito.when(this.repo.save(new PhoneBook(1L,"jimmy", "Giant", "+2345353532", "test@tomsnet.com"))).thenReturn(new PhoneBook(1L,"jimmy", "Giant", "+2345353532", "test@tomsnet.com"));
		Assertions.assertThat(this.service.updateEmailById(1L,"test@tomsnet.com")).isEqualTo(new PhoneBook(1L,"jimmy", "Giant", "+2345353532", "test@tomsnet.com"));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(new PhoneBook(1L,"jimmy", "Giant", "+2345353532", "test@tomsnet.com"));
	}
	
	@Test
	void testUpdateFirstNameById() {
		Optional<PhoneBook> op = Optional.ofNullable(contact_1);
		Mockito.when(this.repo.findById(1L)).thenReturn(op);
		Mockito.when(this.repo.save(new PhoneBook(1L,"test_first", "Giant", "+2345353532", "hardy@tomsnet.com"))).thenReturn(new PhoneBook(1L,"test_first", "Giant", "+2345353532", "hardy@tomsnet.com"));
		Assertions.assertThat(this.service.updateFirstNameById(1L,"test_first")).isEqualTo(new PhoneBook(1L,"test_first", "Giant", "+2345353532", "hardy@tomsnet.com"));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(new PhoneBook(1L,"test_first", "Giant", "+2345353532", "hardy@tomsnet.com"));
	}
	
	@Test
	void testUpdateLastNameById() {
		Optional<PhoneBook> op = Optional.ofNullable(contact_1);
		Mockito.when(this.repo.findById(1L)).thenReturn(op);
		Mockito.when(this.repo.save(new PhoneBook(1L,"jimmy", "test_last", "+2345353532", "hardy@tomsnet.com"))).thenReturn(new PhoneBook(1L,"jimmy", "test_last", "+2345353532", "hardy@tomsnet.com"));
		Assertions.assertThat(this.service.updateLastNameById(1L,"test_last")).isEqualTo(new PhoneBook(1L,"jimmy", "test_last", "+2345353532", "hardy@tomsnet.com"));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(new PhoneBook(1L,"jimmy", "test_last", "+2345353532","hardy@tomsnet.com"));
	}
	
    @Test
    void testDeleteById() {
       Mockito.when(this.repo.existsById(1L)).thenReturn(false);
	   Assertions.assertThat(this.service.deleteById(1L)).isEqualTo(true);
	   Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	   Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
	   
	   
   }
	
}

