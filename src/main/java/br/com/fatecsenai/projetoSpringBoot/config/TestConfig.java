package br.com.fatecsenai.projetoSpringBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fatecsenai.projetoSpringBoot.entities.Category;
import br.com.fatecsenai.projetoSpringBoot.entities.Order;
import br.com.fatecsenai.projetoSpringBoot.entities.Product;
import br.com.fatecsenai.projetoSpringBoot.entities.User;
import br.com.fatecsenai.projetoSpringBoot.entities.enums.OrderStatus;
import br.com.fatecsenai.projetoSpringBoot.repositories.CategoryRepository;
import br.com.fatecsenai.projetoSpringBoot.repositories.OrderRepository;
import br.com.fatecsenai.projetoSpringBoot.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2022-01-01T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-01-02T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2022-01-03T15:21:22Z"), OrderStatus.WAYTING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
