package testcases;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.amzure.bookservice.dto.requst.BookRequest;
import com.amzure.bookservice.dto.response.BookResponse;
import com.amzure.bookservice.entities.BookEntity;
import com.amzure.bookservice.handlers.ResourceNotAvailableException;
import com.amzure.bookservice.repositories.BookRepository;
import com.amzure.bookservice.services.BookServiceIN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class BookServiceINTest {

    @Mock
    private BookRepository bookRepository;

    private BookServiceIN bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceIN();
        bookService.bookRepository = bookRepository;
       
    }

    @Test
    public void testCreateBook() {
        //Prepare Mock Data
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("Easy Java");
        bookRequest.setPrice(200);
        bookRequest.setPubDate(LocalDate.of(2024,7,26));

        BookEntity savedBookEntity = new BookEntity();
        savedBookEntity.setId(1L);
        savedBookEntity.setTitle("Easy Java");
        savedBookEntity.setPrice(200);
        savedBookEntity.setPubDate(LocalDate.of(2024,7,26));

        BookResponse expectedResponse = new BookResponse();
        expectedResponse.setId(1L);
        expectedResponse.setTitle("Easy Java");
        expectedResponse.setPrice(200);
        expectedResponse.setPubDate(LocalDate.of(2024,7,26));

        when(bookRepository.save(any(BookEntity.class)))
                .thenReturn(savedBookEntity);

        BookResponse actualResponse = bookService.createBook(bookRequest);

        assertEquals(expectedResponse, actualResponse);

    }

    @Test
    public void testFindById() {
        Long bookId = 1L;

        BookEntity existingBookEntity = new BookEntity();
        existingBookEntity.setId(1L);
        existingBookEntity.setTitle("Easy Java");
        existingBookEntity.setPrice(200);
        existingBookEntity.setPubDate(LocalDate.of(2024,7,26));

        BookResponse expectedResponse = new BookResponse();
        expectedResponse.setId(1L);
        expectedResponse.setTitle("Easy Java");
        expectedResponse.setPrice(200);
        expectedResponse.setPubDate(LocalDate.of(2024,7,26));

        when(bookRepository.findById(bookId))
                .thenReturn(Optional.of(existingBookEntity));

        BookResponse actualResponse = bookService.findById(bookId);

        assertEquals(expectedResponse, actualResponse);

    }

    @Test
    public void testFindById_BookNotFound() {
        Long bookId = 1L;
        when(bookRepository.findById(bookId))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotAvailableException.class, () -> {
            bookService.findById(bookId);
        });


    }


}
