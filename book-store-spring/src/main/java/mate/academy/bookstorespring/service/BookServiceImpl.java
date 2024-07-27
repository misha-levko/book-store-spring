package mate.academy.bookstorespring.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstorespring.dto.BookDto;
import mate.academy.bookstorespring.dto.CreateBookRequestDto;
import mate.academy.bookstorespring.exception.EntityNotFoundException;
import mate.academy.bookstorespring.mapper.BookMapper;
import mate.academy.bookstorespring.model.Book;
import mate.academy.bookstorespring.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto createBook(CreateBookRequestDto bookDto) {
        Book book = bookMapper.toModel(bookDto);
        return bookMapper.toDto(bookRepository.createBook(book));
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.getAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.getBookById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't get book by id " + id)
        );
        return bookMapper.toDto(book);
    }
}
