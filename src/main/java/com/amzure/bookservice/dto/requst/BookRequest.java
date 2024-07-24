package com.amzure.bookservice.dto.requst;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import lombok.Data;

//@Data
public class BookRequest {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getPubDate() {
		return pubDate;
	}
	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}
	private Long id;
    @NotNull(message = "Please provide a title")
    @NotEmpty(message = "Title should not be empty")
    private String title;
   @NotNull(message = "Please provide price")
   //@Min(1)
    private int price;
    private LocalDate pubDate;
  
}
