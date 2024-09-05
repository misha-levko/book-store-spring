package mate.academy.bookstorespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "mate.academy.bookstorespring")
public class BookStoreSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreSpringApplication.class, args);
    }
}

