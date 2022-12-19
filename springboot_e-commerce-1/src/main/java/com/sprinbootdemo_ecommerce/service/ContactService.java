package com.sprinbootdemo_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinbootdemo_ecommerce.entity.Contact;
import com.sprinbootdemo_ecommerce.repository.ContactRepository;

@Service
public class ContactService {
	
	
	@Autowired
	private ContactRepository contactRepository;
	
	// add the customer query
	public boolean addQuery(Contact contact) {
		
		System.err.println(contact);
		if(contact.getEmail()!=null &&  contact.getFullName()!=null &&  contact.getMessage()!=null) {
			
			this.contactRepository.save(contact);
			return true;
		}
		return false;
	}
}

