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
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
   
    // create a book http://localhost:8080/books  POST
    @PostMapping
    public BookResponse createBook(@Valid @RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }
    
    // Get all books  http://localhost:8080/books  GET
    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    // Get book    http://localhost:8080/books/1 GET
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable @Min(1) Long id) {
    	 return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }
    
    //http://localhost:8080/books/title/C#   GET
    @GetMapping("/title/{title}")
    public List<BookResponse> getBookByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }
    
    //http://localhost:8080/books/date-after/2024-05-27   GET
    @GetMapping("/date-after/{date}")
    public List<BookResponse> findByPublishedDateAfter(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return bookService.findByPublishedDateAfter(date);
    }

    // update a book  http://localhost:8080/books  PUT
    @PutMapping
    
    public BookResponse updateBook(@RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }

    // delete a book  http://localhost:8080/books/53 DELETE
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "Deleted Successfully";
    }
    
   
}