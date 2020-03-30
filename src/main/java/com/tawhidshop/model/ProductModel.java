package com.tawhidshop.model;

import com.tawhidshop.entities.Product;
import lombok.Data;
import java.util.Set;

@Data
public class ProductModel {
    private Set<Product> products ;
}
