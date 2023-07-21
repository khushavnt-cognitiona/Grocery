package com.grocery.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.model.Customer;
import com.grocery.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired 
	 CustomerRepository customerRepository; 
	 
	 public List<Customer> getCustomer() { 
	  return customerRepository.getCustomer(); 
	 } 
	 
	 public void addCustomer(Customer cust) throws NoSuchAlgorithmException { 
	 
	  java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256"); 
	  md.reset(); 
	  md.update(cust.getPassword().getBytes()); 
	  byte[] digest = md.digest(); 
	  System.err.println("i m in service"); 
	  System.err.println(digest); 
	 
	  StringBuffer sb = new StringBuffer(); 
	 
	  for (int i = 0; i < digest.length; i++) { 
	   sb.append(Integer.toHexString(0xFF & digest[i])); 
	  } 
	  String encryptedpassword = sb.toString(); 
	  // message digest(password encrypt...set again) 
	  System.err.println(encryptedpassword); 
	  cust.setPassword(encryptedpassword); 
	  customerRepository.addCustomer(cust); 
	 } 
	 
		/*
		 * public Customer userLogin(String email, String password,Customer cust) throws
		 * UsernameNotFoundException {
		 * 
		 * if (customerRepository.userLogin(email, password) == null)
		 * 
		 * throw new UsernameNotFoundException("User not found with username or email: "
		 * + email); return cust;
		 * 
		 * 
		 * }
		 */
	 
		/*
		 * public void updateUser(Customer cust) throws NoSuchAlgorithmException {
		 * java.security.MessageDigest md =
		 * java.security.MessageDigest.getInstance("SHA-256"); md.reset();
		 * md.update(cust.getPassword().getBytes()); byte[] digest = md.digest();
		 * StringBuffer sb = new StringBuffer(); for (int i = 0; i < digest.length; i++)
		 * { sb.append(Integer.toHexString(0xFF & digest[i])); } String
		 * encryptedpassword = sb.toString(); cust.setPassword(encryptedpassword);
		 * customerRepository.updateUser(cust);
		 */
	 
	 //} 
	 
	 public void deleteUser(Customer cust) { 
	  customerRepository.deleteUser(cust); 
	 }
}
