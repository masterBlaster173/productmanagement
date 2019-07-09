package com.alexanderbaranov.productmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item are not found")
public class NotFoundException extends RuntimeException {

}
