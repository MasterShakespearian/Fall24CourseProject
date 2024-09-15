package edu.fscj.cen3024c.financialclarity;

// Entity and repostirory imports
import edu.fscj.cen3024c.financialclarity.entity.Users;
import edu.fscj.cen3024c.financialclarity.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("edu.fscj.cen3024c.financialclarity.repository")
public class FinancialClarityApplication implements CommandLineRunner {


	@Autowired
	private UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinancialClarityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Users user1 = new Users();
		user1.setUsername("Cole");
		user1.setAge(20);
		user1.setEmail("test@example.com");
		user1.setPassword("pass");
		user1.setTotalIncome("1000");
		user1.setTotalExpences("1000");
		usersRepository.save(user1);



		// Call the findAll() method to test it
		List<Users> users = usersRepository.findAll();

		// Print the results to verify
		System.out.println("All users in the database:");
		users.forEach(user -> System.out.println(user.getUsername()));
	}
}
