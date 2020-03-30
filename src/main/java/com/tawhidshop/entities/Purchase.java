package com.tawhidshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import oracle.sql.DATE;

import java.util.ArrayList;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Purchase {
    private int  id;
    private DATE date;
    private String fullName;
    private String phone;
    private String address;
    private String email;
    private ArrayList<Product> Products;
}
