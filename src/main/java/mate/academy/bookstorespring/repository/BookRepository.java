package mate.academy.bookstorespring.repository;

import java.util.List;
import mate.academy.bookstorespring.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
