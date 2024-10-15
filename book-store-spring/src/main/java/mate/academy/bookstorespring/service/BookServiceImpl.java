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
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
        Book book = bookRepository.getBookById(id).orElseThrow(

                () -> new EntityNotFoundException("Can't get book by id " + id)
        );
        return bookMapper.toDto(book);
    }

    @Override

    public BookDto updateBookById(CreateBookRequestDto bookRequestDto, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Can't find book by id: " + id));
        bookMapper.updateBookFromDto(bookRequestDto, book);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBookById(Long id, BookDto bookDto) {
        Book bookUpdate = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't update book by id " + id)
        );
        bookUpdate.setTitle(bookDto.getTitle());
        bookUpdate.setAuthor(bookDto.getAuthor());
        bookUpdate.setPrice(bookDto.getPrice());
        bookUpdate.setIsbn(bookDto.getIsbn());
        bookUpdate.setDescription(bookDto.getDescription());
        bookUpdate.setCoverImage(bookDto.getCoverImage());

        return bookMapper.toDto(bookRepository.save(bookUpdate));
    }
}
