package com.amzure.bookservice.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Data
@NoArgsConstructor
@Entity
@Table(name ="BOOKS" )
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
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
	private String title;
    private int price;
    @Column(name = "PUBLISH_DATE")
    private LocalDate pubDate;
   
}