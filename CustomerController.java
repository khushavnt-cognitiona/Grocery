/*
 * package com.grocery.controller;
 * 
 * import java.security.NoSuchAlgorithmException; import java.util.HashSet;
 * import java.util.List; import java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.grocery.model.Customer; import
 * com.grocery.service.CustomerService;
 * 
 * @RestController
 * 
 * @RequestMapping("/Customer") public class CustomerController {
 * 
 * @Autowired CustomerService customerService;
 * 
 * @GetMapping("/get") public ResponseEntity<List<Customer>> getCustomer() {
 * 
 * return new ResponseEntity<List<Customer>>(customerService.getCustomer() ,
 * HttpStatus.OK); }
 * 
 * @PostMapping("/Register") public void addCustomer(@RequestBody Customer cust)
 * { try { customerService.addCustomer(cust); } catch (NoSuchAlgorithmException
 * e) {
 * 
 * e.printStackTrace(); }
 * 
 * }
 * 
 * @PostMapping("/login") public String userLogin(@RequestParam("email") String
 * email, @RequestParam("password") String password,Customer cust) { try {
 * Customer cust1 = customerService.userLogin(email, password,cust);
 * Set<SimpleGrantedAuthority>roles=new HashSet<>(); User user=new
 * User(String.valueOf(cust1.getCustomerId()),"",roles); String token = "";
 * //jwtServiceImpl.generateToken(user); return token; } catch
 * (UsernameNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return "401- User is not Authenticate"; }
 * 
 * @PutMapping("/{customerId}") public void updateUser(@PathVariable Integer
 * customerId, @RequestBody Customer cust) { cust.setCustomerId(customerId); try
 * { customerService.updateUser(cust); } catch (NoSuchAlgorithmException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }
 * 
 * @DeleteMapping("/{customerId}") public void deleteUser(@PathVariable Integer
 * customerId, @RequestBody Customer cust) { customerService.deleteUser(cust); }
 * 
 * }
 * 
 * 
 * 
 */