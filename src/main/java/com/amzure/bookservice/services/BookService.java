package com.amzure.bookservice.services;


import com.amzure.bookservice.dto.requst.BookRequest;
import com.amzure.bookservice.dto.response.BookResponse;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

   
    public BookResponse createBook(BookRequest bookRequest) ;

    public Page<BookResponse> findAll(Pageable pageable);

    public BookResponse findById(Long id);
    
    public List<BookResponse> findByTitle(String title);
    
    public List<BookResponse> findByPublishedDateAfter(LocalDate date);
    
    public void deleteBookById( Long id);
    
  
}