package com.loumo.controllers;

import com.loumo.commons.AppMessage;
import com.loumo.controllers.dtos.VoidResponse;
import com.loumo.controllers.dtos.requests.ProductRequestDTO;
import com.loumo.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    @Operation(summary = "Create product")
    @ApiResponse(responseCode = "200", description = "Create product.")
    public ResponseEntity<VoidResponse> badRequest(@RequestHeader HttpHeaders headers, @RequestBody @Valid ProductRequestDTO request) {
        log.info("# CREATE PRODUCT : {} ",request);
        productService.createProduct(request);
        return new ResponseEntity<>(new VoidResponse(AppMessage.SUCCESS), HttpStatus.OK);
    }


}
