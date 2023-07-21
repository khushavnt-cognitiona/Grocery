package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.PaymentMode;
import com.grocery.model.Roles;
import com.grocery.service.RolesService;

@RestController
public class RolesController 
{
@Autowired
RolesService rolesService;
@GetMapping("/get/role")
public List<Roles>getAllRoles()
{
	return rolesService.getAllRoles();
	
}
@PostMapping("/post/role")
public void AddRoles(@RequestBody List<Roles>roles) 
{
	rolesService.AddRolesService(roles);
}
//delete
@DeleteMapping("/deleterole/{roleId}")
public void DeleteRoles(@PathVariable Integer roleId,@RequestBody Roles roles) 
{
	rolesService.DeleteRoles(roles);
}

}
