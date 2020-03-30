package com.tawhidshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
    private int id;
    private String title;
    private String description;
    private String image;
    private Double price;
}
