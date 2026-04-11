package com.tutego.ch_09.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// not flexible at runtime
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quote")
public class QuoteNotFoundException extends RuntimeException { }