package com.loumo.controllers.dtos.requests;

import com.loumo.exceptions.AppException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO implements Serializable {


    @NotBlank(message = "The name is not blank.")
    private String name;
    private BigDecimal price;
    private String currency;
    private Long Weight;

    public String getName() {
        if(StringUtils.isBlank(name))
            throw new AppException("The name is not blank.", HttpStatus.BAD_REQUEST);
        return name ;
    }


    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getWeight() {
        return Weight;
    }

    public void setWeight(Long weight) {
        Weight = weight;
    }
}
