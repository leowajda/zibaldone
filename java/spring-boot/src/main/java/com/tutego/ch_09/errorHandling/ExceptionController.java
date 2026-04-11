package com.tutego.ch_09.errorHandling;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping
    public void exception() {
        throw new QuoteNotFoundException(); // 1. exception is mapped to an HTTP status code (not recommended)

        // 2. Spring data type for throwing exceptions at the @Controller level
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such quote");
        // local / global exception handlers (see GlobalControllerAdvice)
    }


}
