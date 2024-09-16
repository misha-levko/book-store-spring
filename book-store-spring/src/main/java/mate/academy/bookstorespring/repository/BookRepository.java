package mate.academy.bookstorespring.repository;

import java.util.Optional;
import mate.academy.bookstorespring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> getBookById(Long id);
}
