package com.amzure.bookservice.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name ="BOOKS" )
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
    private String title;
    private int price;
    @Column(name = "PUBLISH_DATE")
    private LocalDate pubDate;
   
}