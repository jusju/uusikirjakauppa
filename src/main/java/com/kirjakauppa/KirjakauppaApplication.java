package com.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kirjakauppa.model.Book;
import com.kirjakauppa.model.BookRepository;
import com.kirjakauppa.model.User;
import com.kirjakauppa.model.UserRepository;


@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory
			.getLogger(KirjakauppaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, UserRepository urepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				log.info("save a couple of books");
				repository
						.save(new Book("Sinuhe", "Waltari", 1961, "2432432432", 10));
				repository
						.save(new Book("Synkkä yksinpuhelu", "Paavolainen", 1943, "243988979", 11));

				log.info("fetch all books");
				for (Book book : repository.findAll()) {
					log.info(book.toString());
				}
				// Create users: admin/admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
			};
		};
	}
}
