package com.amzure.bookservice.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amzure.bookservice.dto.requst.BookRequest;
import com.amzure.bookservice.dto.response.BookResponse;
import com.amzure.bookservice.services.BookService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/books")
@Tag(name = "Book Management", description = "Operations pertaining to books in the Book Service")
public class BookController {

    @Autowired
    private BookService bookService;
   
    @Operation(summary = "Create a new book", description = "Creates a new book in the library", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Book created successfully", content = @Content(schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public BookResponse createBook(
        @Valid @RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }
    
    @Operation(summary = "Get all books", description = "Retrieve all books from the library", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    @Operation(summary = "Get a book by ID", description = "Retrieve a book by its ID", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved book", content = @Content(schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(
        @PathVariable @Min(1) Long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }
    
    @Operation(summary = "Get books by title", description = "Retrieve books by their title", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved books", content = @Content(schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "404", description = "Books not found")
    })
    @GetMapping("/title/{title}")
    public List<BookResponse> getBookByTitle(
        @PathVariable String title) {
        return bookService.findByTitle(title);
    }
    
    @Operation(summary = "Get books published after a certain date", description = "Retrieve books published after a specified date", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved books", content = @Content(schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid date format")
    })
    @GetMapping("/date-after/{date}")
    public List<BookResponse> findByPublishedDateAfter(
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return bookService.findByPublishedDateAfter(date);
    }

    @Operation(summary = "Update an existing book", description = "Updates the details of an existing book", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book updated successfully", content = @Content(schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PutMapping
    public BookResponse updateBook(
        @RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }

    @Operation(summary = "Delete a book by ID", description = "Deletes a book by its ID", tags = { "Book Management" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @DeleteMapping("/{id}")
    public String deleteBookById(
        @PathVariable Long id) {
        bookService.deleteBookById(id);
        return "Deleted Successfully";
    }
}
