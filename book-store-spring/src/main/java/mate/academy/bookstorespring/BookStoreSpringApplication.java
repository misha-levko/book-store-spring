package mate.academy.bookstorespring;

import java.math.BigDecimal;
import mate.academy.bookstorespring.model.Book;
import mate.academy.bookstorespring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreSpringApplication {
    private final BookService bookService;

    @Autowired
    public BookStoreSpringApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setCoverImage("images/book-cover-1984.png");
            book.setTitle("1984");
            book.setDescription("Depicts a gray, totalitarian world dominated by Big Brother");
            book.setAuthor("George Orwell");
            book.setIsbn("418-7-77-7484-78");
            book.setPrice(BigDecimal.valueOf(50));

            bookService.save(book);

            System.out.println(bookService.findAll());
        };
    }
}
