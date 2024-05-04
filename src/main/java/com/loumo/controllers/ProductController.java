package com.loumo.controllers;

import com.loumo.controllers.dtos.VoidResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @PostMapping
    @Operation(summary = "create product")
    @ApiResponse(responseCode = "200", description = "create product")
    public ResponseEntity<VoidResponse> createUser(@RequestHeader HttpHeaders headers, @RequestBody @Valid UserRequestDto req) {

        log.info("### CREATE PRODUCT : {} ", req);
        var session = sessionService.checkAndGetSessionByToken(headers);
        userService.createUser(session, req);
        return new ResponseEntity<>(new OperationResponse(DiotaliMessage.DB_SUCCESS_CREATE), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "liste des utilsateurs par partenaire")
    @ApiResponse(responseCode = "200", description = "liste des utilsateurs par partenaire")
    public ResponseObject<UserDetailsStatisticDTO> getUsers(@RequestHeader HttpHeaders headers,
                                                            @RequestParam(name = "parentId", required = false) Long parentId,
                                                            @RequestParam(name = "lastName", required = false) String lastName,
                                                            @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                                                            @RequestParam(value = "page", required = false, defaultValue = "0") @Parameter(description = "Page") int page,
                                                            @RequestParam(value = "size", required = false, defaultValue = "100") @Parameter(description = "Nombre element") int size
    ) {
        LOG.info("### List User : ParentId : {} PHONE: {} ", parentId, phoneNumber);
        return new ResponseObject<>(DiotaliMessage.DB_SUCCESS, userService.getUsers(parentId, lastName, phoneNumber, page, size));
    }
}
