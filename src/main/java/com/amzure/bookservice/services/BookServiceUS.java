package com.amzure.bookservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.amzure.bookservice.dto.requst.BookRequest;
import com.amzure.bookservice.dto.response.BookResponse;
import com.amzure.bookservice.entities.BookEntity;
import com.amzure.bookservice.handlers.ResourceNotAvailableException;
import com.amzure.bookservice.repositories.BookRepository;

@Profile("us")
@Service
public class BookServiceUS implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Value("${books.cashBack}")
	private int cashBack;

	public BookResponse save(BookRequest bookRequest) {
		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(bookRequest, bookEntity);
		bookEntity = bookRepository.save(bookEntity);
		return convertEntityToResponse(bookEntity);
	}

	public List<BookResponse> findAll() {
		return bookRepository.findAll().stream().map(this::convertEntityToResponse).collect(Collectors.toList());
	}

	public BookResponse findById(Long id) {
	    BookEntity bookEntity = bookRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotAvailableException("Item Not Available"));
	    return convertEntityToResponse(bookEntity);
	}

	public List<BookResponse> findByTitle(String title) {
		return bookRepository.findByTitle(title).stream().map(this::convertEntityToResponse).collect(Collectors.toList());
	}

	public List<BookResponse> findByPublishedDateAfter(LocalDate date) {
		return bookRepository.findByPublishedDateAfter(date).stream().map(this::convertEntityToResponse).collect(Collectors.toList());
	}
	
    public void deleteBookById(Long id) {
    	bookRepository.deleteById(id);
    }
    		
	public BookResponse convertEntityToResponse(BookEntity bookEntity) {
		BookResponse bookResponse = new BookResponse();
		BeanUtils.copyProperties(bookEntity, bookResponse);
		bookResponse.setCashBack(cashBack);
		return bookResponse;
	}
}
