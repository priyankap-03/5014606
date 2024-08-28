package com.example.bookstore.mapper;
import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public abstract class BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    abstract BookDTO bookToBookDTO(Book book);
    abstract Book bookDTOToBook(BookDTO bookDTO);
}
