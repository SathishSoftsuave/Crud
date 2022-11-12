package com.example.Employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Employee.Repository.CompanyRepository;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.model.Company;
import com.example.Employee.model.EmployeeDetails;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> findAll(){
		return companyRepository.findAll();
	}
	
	public Company save(Company emp) {
		return companyRepository.save(emp);
	}
	
	public ResponseEntity<Company> insertEmp(int id) throws ResourceNotFoundException {
		Company cmpny = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id is not found"));
		return ResponseEntity.ok(cmpny);
	}
	
	public ResponseEntity<Company> updateById(int id,Company cmp ) throws ResourceNotFoundException{
		Company cmpDetails = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id is not found"));
		cmpDetails.setC_id(cmp.getC_id());
		cmpDetails.setC_name(cmp.getC_name());
		cmpDetails.setAddress(cmp.getAddress());
		cmpDetails.setEmpDetails(cmp.getEmpDetails());
		return ResponseEntity.ok(cmpDetails);	
	}
	
	public ResponseEntity<Map<String, Boolean>> delete(int id){
		companyRepository.deleteById(id);
		Map<String, Boolean> resp = new HashMap<String, Boolean>();
		resp.put("Deleted", true);
		return ResponseEntity.ok(resp);	
	}

}
