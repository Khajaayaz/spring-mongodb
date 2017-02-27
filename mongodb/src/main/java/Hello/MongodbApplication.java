package Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("khaja", "yousufuddin"));
		repository.save(new Customer("khaja", "ayaz"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('khaja'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("khaja"));

		System.out.println("Customers found with findByLastName('yousufuddin'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("yousufuddin")) {
			System.out.println(customer);
		}

	}

}
