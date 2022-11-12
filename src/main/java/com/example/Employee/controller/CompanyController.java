package com.example.Employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.model.Company;
import com.example.Employee.model.EmployeeDetails;
import com.example.Employee.service.CompanyService;

@RestController
@RequestMapping("/cmp")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/show")
	public List<Company> findAll(){
		return companyService.findAll();		
	}
	
	@PostMapping("/post")
	public Company insertEmp(@RequestBody Company cmp) {
		return companyService.save(cmp);		
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Company> selectEmpById(@PathVariable int id) throws ResourceNotFoundException {
		return companyService.insertEmp(id);
	}
	

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Company> updateById(@PathVariable int id, @RequestBody Company cmp) throws ResourceNotFoundException{
		return companyService.updateById(id, cmp);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteByID(@PathVariable int id){
		return companyService.delete(id);	
	}

}
