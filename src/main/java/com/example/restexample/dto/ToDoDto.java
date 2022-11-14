package com.example.restexample.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {

    //@JsonProperty("id") this  annotation uses in case of differences in incoming json fields
    //@JsonIgnore this annotation is used to ignore field in case of our object has more fields rather than incoming json
    private int id;
    private int userId;
    private String title;
    private boolean completed;

}
