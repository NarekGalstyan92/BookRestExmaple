package com.example.restexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotEmpty(message = "title can't be null or empty")
    private String title;
    //    @JsonProperty("author_name") in case of different getting or posting json fields we use this annotation
    private String description;
    @Range(min = 0, max = 1000)
    private double price;
    @Enumerated(EnumType.STRING)
    private BookLanguage language;
    @NotNull(message = "Author can't be null")
    @ManyToOne
    private Author author;

}
