package com.loumo.controllers;

import com.loumo.commons.AppMessage;
import com.loumo.controllers.dtos.VoidResponse;
import com.loumo.services.ExceptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/exceptions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Exceptions")
public class ExceptionController {

    private final ExceptionService exceptionService;

    public ExceptionController(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @PostMapping
    @Operation(summary = "Bad request exception.")
    @ApiResponse(responseCode = "200", description = "Bad request exception.")
    public ResponseEntity<VoidResponse> badRequest(@RequestHeader HttpHeaders headers) {
        exceptionService.badRequest();
        return new ResponseEntity<>(new VoidResponse(AppMessage.SUCCESS), HttpStatus.OK);
    }
}
