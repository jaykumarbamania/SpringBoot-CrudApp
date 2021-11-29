package com.neosoft.springboot;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosoft.springboot.model.Gender;
import com.neosoft.springboot.model.UserProfile;
import com.neosoft.springboot.model.Users;
import com.neosoft.springboot.repository.UsersRepository;

@SpringBootApplication
public class MappingMainApplication implements CommandLineRunner {
	
	@Autowired
	private UsersRepository userRep;
	
	public static void main(String[] args) {
		SpringApplication.run(MappingMainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//create a user instance
		/*
		 * Users user = new Users("Yash", "Ketan", "yash@gmail.com", "J@ykumar99");
		 * 
		 * Calendar dob = Calendar.getInstance(); dob.set(1999, 16,11);
		 * 
		 * UserProfile userProfile = new UserProfile("+91-978787565", Gender.MALE,
		 * dob.getTime(), "Diu" , "Daman and Diu", "India", "362520");
		 * 
		 * //set child references in parent entity user.setUserprofile(userProfile);
		 * userProfile.setUsers(user); //set Parent reference also will save child ref
		 * as well userRep.save(user);
		 * 
		 * Users user = usersRepository.findById((long)5).get();
		userProfile.setUsers(user);
		usersProfileRepository.save(userProfile);
		 */
	}
}
