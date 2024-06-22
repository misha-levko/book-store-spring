package mate.academy.bookstorespring.service;

import java.util.List;
import mate.academy.bookstorespring.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
