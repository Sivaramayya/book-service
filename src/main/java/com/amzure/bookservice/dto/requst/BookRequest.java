package com.amzure.bookservice.dto.requst;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequest {
    private Long id;
    @NotNull(message = "Please provide a title")
    @NotEmpty(message = "Title should not be empty")
    private String title;
    @NotNull(message = "Please provide price")
    @Min(1)
    private int price;
    private LocalDate pubDate;
  
}
