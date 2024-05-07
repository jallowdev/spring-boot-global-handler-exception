package com.loumo.services;

public interface ExceptionService {
    public void badRequest();
    public void notFound();
    public void internal() throws Exception;
}
