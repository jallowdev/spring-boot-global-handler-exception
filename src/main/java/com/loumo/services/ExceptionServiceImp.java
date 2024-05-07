package com.loumo.services;

import com.loumo.exceptions.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImp implements ExceptionService{

   public void badRequest() {
       throw new AppException("Bad request exception message", HttpStatus.BAD_REQUEST);
   }

    public void notFound() {
        throw new AppException("Not found exception message", HttpStatus.NOT_FOUND);
    }

    public void internal() throws Exception {
        throw new Exception("Internal Error");
    }
}
