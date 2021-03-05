package com.qa.fundamental.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor   // needed when returning list of objects
@AllArgsConstructor // needed for testing
@Data
public class PhoneBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	@NotNull
	private String phone_number;
	
	@Column
	private String email;

	//When auto-generating id's
	public PhoneBook(@NotNull String first_name, String last_name, @NotNull String phone_number, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
	}
	
}
