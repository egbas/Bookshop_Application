package com.egbas.BookshopApplication.controller;


import com.egbas.BookshopApplication.dto.BookDto;
import com.egbas.BookshopApplication.service.BookService;
import com.egbas.BookshopApplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
@Tag(name = "Book Services APIs")
public class BookController{

    private final BookService bookService;
    private final UserService userService;


    @Operation(
            summary = "Create Book for User",
            description = "Creation of new book for user"
    )
    @PostMapping("/create-book/{id}")
    public ResponseEntity<BookDto> createBook(@PathVariable Long id,
                                @RequestBody BookDto bookDto) {
        bookDto = bookService.createBook(id, bookDto);

        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Retrieve Book by ID",
            description = "Retrieve Book by Book ID"
    )
    @GetMapping("/get-book/{id}")
            public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        BookDto bookDto = null;
        bookDto = bookService.getBookById(id);

        return ResponseEntity.ok(bookDto);

    }

    @Operation(
            summary = "Get Book By ID",
            description = "Retrieve all book in a list related to one User"
    )

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookDto>> getAllBooksByUserId(@PathVariable Long userId){

        List<BookDto> books = bookService.getAllBooksByUserId(userId);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @Operation(
            summary = "Update Book",
            description = "Update details of a particular book selected by ID"
    )
    @PutMapping("update-book/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        bookDto = bookService.updateBook(id, bookDto);

        return ResponseEntity.ok(bookDto);

    }


    @Operation(
            summary = "Delete Book",
            description = "Delete Book with Specific ID"
    )

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id){

        boolean deleted = false;
        deleted = bookService.deleteBook(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", deleted);

        return ResponseEntity.ok(response);

    }

}
