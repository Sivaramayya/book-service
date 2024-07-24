package com.amzure.bookservice.dto.response;
import java.time.LocalDate;
import lombok.Data;

public class BookResponse {
    private Long id;
    private String title;
    private int price;
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
	public int getCashBack() {
		return cashBack;
	}
	public void setCashBack(int cashBack) {
		this.cashBack = cashBack;
	}
	private LocalDate pubDate;
   	private int cashBack;
}
