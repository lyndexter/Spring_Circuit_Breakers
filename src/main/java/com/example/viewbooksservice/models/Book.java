package com.example.viewbooksservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private int id;
    private String name;
    private Integer year;
    private Integer numberOfPages;


}
