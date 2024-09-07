package mate.academy.bookstorespring.mapper;

import mate.academy.bookstorespring.config.MapperConfig;
import mate.academy.bookstorespring.dto.BookDto;
import mate.academy.bookstorespring.dto.CreateBookRequestDto;
import mate.academy.bookstorespring.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookDto);
}
