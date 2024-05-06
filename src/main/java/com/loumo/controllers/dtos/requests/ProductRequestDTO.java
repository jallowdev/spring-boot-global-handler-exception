package com.loumo.controllers.dtos.requests;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    private String name;

    private BigDecimal price;

    public String currency;

    private Long Weight;
}
