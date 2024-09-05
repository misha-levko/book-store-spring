package mate.academy.bookstorespring.service;

import java.util.List;
import mate.academy.bookstorespring.dto.BookDto;
import mate.academy.bookstorespring.dto.CreateBookRequestDto;

public interface BookService {
    BookDto createBook(CreateBookRequestDto bookDto);

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    void deleteById(Long id);

    BookDto updateBookById(Long id, BookDto bookDto);
}
