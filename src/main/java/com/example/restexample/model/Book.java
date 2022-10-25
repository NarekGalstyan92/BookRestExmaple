package com.example.restexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    //    @JsonProperty("author_name") in case of different getting or posting json fields we use this annotation
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private BookLanguage language;
    @ManyToOne
    private Author author;

}
