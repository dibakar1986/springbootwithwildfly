package com.dcwebworks.springbootwithwildfly.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dcwebworks.springbootwithwildfly.model.Student;
import com.dcwebworks.springbootwithwildfly.repository.StudentRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
	private final StudentRepository studentRepository;
	
	public DataLoader(StudentRepository repository) {
		this.studentRepository = repository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		Student student1 = new Student();
		student1.setFirstName("Dibakar");
		student1.setLastName("Chakraborty");
		student1.setYear(2011);
		studentRepository.save(student1);
		
		Student student2 = new Student();
		student2.setFirstName("Sanu");
		student2.setLastName("Chakraborty");
		student2.setYear(2012);
		studentRepository.save(student2);
		
		Student student3 = new Student();
		student3.setFirstName("Malini");
		student3.setLastName("Chakraborty");
		student3.setYear(2011);
		studentRepository.save(student3);
		
		Student student4 = new Student();
		student4.setFirstName("Sankar");
		student4.setLastName("Chakraborty");
		student4.setYear(2011);
		studentRepository.save(student4);
		
	}
}
