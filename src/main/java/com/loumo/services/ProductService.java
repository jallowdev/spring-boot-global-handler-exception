package com.loumo.services;

import com.loumo.controllers.dtos.requests.ProductRequestDTO;

public interface ProductService {
    public void createProduct(ProductRequestDTO requestDTO);
}
