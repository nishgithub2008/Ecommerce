package com.sprinbootdemo_ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sprinbootdemo_ecommerce.entity.Contact;
import com.sprinbootdemo_ecommerce.service.ContactService;
@Controller
public class ContactController {
	
   @Autowired
   private 	ContactService contactService;

   @RequestMapping("/contact")
   public String contact() {
	   return "contact";
   }
   
   
   @PostMapping("/contact")
   public String contact(Contact c  ) {
	     System.out.println(c);
	   if(this.contactService.addQuery(c)) {
		   
		   return "redirect:shop?msgg=Thank you for your response ...will get back to you"+"  "+c.getFullName();
	   }
	   return"contact";
   }
   
   
   
   
}
