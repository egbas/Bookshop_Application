package com.egbas.BookshopApplication.service;

import com.egbas.BookshopApplication.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(Long id,BookDto bookDto);

    BookDto getBookById (Long id);

    List<BookDto> getAllBooksByUserId(Long userId);

    BookDto updateBook(Long id, BookDto bookDto);

    boolean deleteBook(Long id);
}
