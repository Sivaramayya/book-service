package com.amzure.bookservice.dto.response;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private int price;
    private LocalDate pubDate;
   	private int cashBack;
   
}
