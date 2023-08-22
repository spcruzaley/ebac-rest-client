package com.ebac.modulo44.dto;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private boolean success;
    private String message;
    private ResponseEntity<T> responseEntity;
}
