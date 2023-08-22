package com.ebac.modulo44.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseEntity<T> {
    Map<String, Object> headers;
    T body;
    String statusCode;
    int statusCodeValue;
}
