package com.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kirjakauppa.model.Book;
import com.kirjakauppa.model.BookRepository;


@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory
			.getLogger(KirjakauppaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
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
			};
		};
	}
}
