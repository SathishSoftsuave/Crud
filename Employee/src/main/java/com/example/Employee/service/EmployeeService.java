package com.example.Employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Employee.Repository.EmployeeRepository;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.model.EmployeeDetails;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public List<EmployeeDetails> findAll(){
		return employeeRepository.findAll();
	}
	
	public EmployeeDetails save(EmployeeDetails emp) {
		return employeeRepository.save(emp);
	}
	
	public ResponseEntity<EmployeeDetails> insertEmp(int id) throws ResourceNotFoundException {
		EmployeeDetails empDetails = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id is not found"));
		return ResponseEntity.ok(empDetails);
	}
	
	public ResponseEntity<EmployeeDetails> updateById(int id,EmployeeDetails emp ) throws ResourceNotFoundException{
		EmployeeDetails empDetails = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id is not found"));
		empDetails.setEmpID(emp.getEmpID());
		empDetails.setEmp_name(emp.getEmp_name());
		empDetails.setEmp_designation(emp.getEmp_designation());
		empDetails.setSalary(emp.getSalary());
		empDetails.setEmp_doj(emp.getEmp_doj());
		return ResponseEntity.ok(empDetails);	
	}
	
	public ResponseEntity<Map<String, Boolean>> delete(int id){
		employeeRepository.deleteById(id);
		Map<String, Boolean> resp = new HashMap<String, Boolean>();
		resp.put("Deleted", true);
		return ResponseEntity.ok(resp);	
	}

}
