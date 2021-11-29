package com.neosoft.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Trainer;
import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.springboot.repository.TrainerRepository;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	@GetMapping()
	public List<Trainer> getAllTrainers(){
		return trainerRepository.findAll();
	}
	
	@PostMapping("/add")
	public String addTrainer(@RequestBody Trainer trainer) {
		trainerRepository.save(trainer);
		return "Saved Successfully";
	}
	
	@GetMapping("/and/{firstname}/{lastname}")
	public Trainer getTrainerFnameAndLname(@PathVariable String firstname, @PathVariable String lastname) {
		return trainerRepository.findByFirstnameAndLastname(firstname, lastname);
	}
	
	@GetMapping("/or/{firstname}/{lastname}")
	public List<Trainer> getTrainerFnameOrLname(@PathVariable String firstname, @PathVariable String lastname) {
		return trainerRepository.findByFirstnameOrLastname(firstname, lastname);
	}
	
	@GetMapping("age/less/{age}")
	public List<Trainer> getTrainerbyAgeLessThan(@PathVariable int age) {
		return trainerRepository.findByAgeLessThan(age);
	}
	
	@GetMapping("age/lesseq/{age}")
	public List<Trainer> getTrainerbyAgeLessThanEqual(@PathVariable int age) {
		return trainerRepository.findByAgeLessThanEqual(age);
	}
	
	@GetMapping("age/greatereq/{age}")
	public List<Trainer> getTrainerbyAgeGreaterThanEqual(@PathVariable int age) {
		return trainerRepository.findByAgeGreaterThanEqual(age);
	}
	
	@GetMapping("age/between/{age1}/{age2}")
	public List<Trainer> getTrainerbyAgeBetween(@PathVariable int age1,@PathVariable int age2) {
		return trainerRepository.findByAgeBetween(age1, age2);
	}
	
	@GetMapping("age/lastname/{age}")
	public List<Trainer> getTrainerbyAgeOrderByLname(@PathVariable int age) {
		return trainerRepository.findByAgeOrderByLastnameDesc(age);
	}
	
	@GetMapping("like/{firstname}")
	public List<Trainer> getTrainerbyAgeOrderByLname(@PathVariable String firstname) {
		return trainerRepository.findByFirstnameLike("%"+firstname+"%");
	}
	
	@GetMapping("/active")
	public List<Trainer> getAllActiveTrainer() {
		return trainerRepository.findAllActiveTrainers(1);
	}
	
	@GetMapping("/active/{age}")
	public List<Trainer> getAllActiveTrainerwithAge(@PathVariable int age) {
		return trainerRepository.findAllActiveTrainerswithAge(1, age);
	}
	
	@PutMapping("/{status}/{firstname}")
	public int updateTrainerSetStatusForName(@PathVariable int status,@PathVariable String firstname) {
		return trainerRepository.updateTrainerSetStatusForName(status, firstname);
	}
	
	@GetMapping("/{id}")
	public EntityModel<Trainer> getTrainerById(@PathVariable long id){
		Optional<Trainer> trainer = trainerRepository.findById(id);
		if(!trainer.isPresent()) {
			throw new ResourceNotFoundException("Trainer", "Id", id);
		}
		
		EntityModel<Trainer> resource = EntityModel.of(trainer.get());
		WebMvcLinkBuilder linkto = linkTo(methodOn(this.getClass()).getAllTrainers());
		resource.add(linkto.withRel("all-trainers"));
		
		return resource;
	}
}
