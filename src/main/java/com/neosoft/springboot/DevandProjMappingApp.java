package com.neosoft.springboot;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosoft.springboot.model.Developer;
import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.model.Project;
import com.neosoft.springboot.repository.DeveloperRepository;

@SpringBootApplication
public class DevandProjMappingApp implements CommandLineRunner {
	
	@Autowired
	private DeveloperRepository devRep;

	public static void main(String[] args) {
		SpringApplication.run(DevandProjMappingApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Developer devloper = new Developer("Jaykumar", "jaykumar@gmail.com");
//		
		Calendar dob = Calendar.getInstance();
		dob.set(2022,30 ,4);
//		
//		Project project = new Project("Web App",dob.getTime());
//		
//		devloper.setProject(project);
//		project.setDevelopers(devloper);
		
//		devRep.save(devloper);
		
		//devRep.deleteById((long) 1);
		
//		Developer dev = devRep.findById((long) 2).orElse(null);
//		dev.setProject(new Project("Web App",dob.getTime()));
//		devRep.save(dev);
		
	}

}
