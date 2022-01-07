package br.com.fatecsenai.projetoSpringBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fatecsenai.projetoSpringBoot.entities.Category;
import br.com.fatecsenai.projetoSpringBoot.entities.Order;
import br.com.fatecsenai.projetoSpringBoot.entities.User;
import br.com.fatecsenai.projetoSpringBoot.entities.enums.OrderStatus;
import br.com.fatecsenai.projetoSpringBoot.repositories.CategoryRepository;
import br.com.fatecsenai.projetoSpringBoot.repositories.OrderRepository;
import br.com.fatecsenai.projetoSpringBoot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository OrderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2022-01-01T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-01-02T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2022-01-03T15:21:22Z"), OrderStatus.WAYTING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
