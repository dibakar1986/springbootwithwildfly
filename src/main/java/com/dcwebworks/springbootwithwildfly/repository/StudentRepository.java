package com.dcwebworks.springbootwithwildfly.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcwebworks.springbootwithwildfly.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
}
