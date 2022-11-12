package com.example.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
