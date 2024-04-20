package com.egbas.BookshopApplication.dto;


import com.egbas.BookshopApplication.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotBlank(message = "title name must not be blank")
    private String title;

    @NotBlank(message = "author name must not be blank")
    private String author;

    @NotBlank(message = "pages must not be blank")
    private int pages;


    private BookStatus bookStatus;
}
