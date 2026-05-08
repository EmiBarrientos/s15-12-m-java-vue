package com.nc.Propiedades360.app.exception;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ApiError {
    private int status;
    private String error;
    private LocalDateTime timestamp;

    public ApiError(int status, String error) {
        this.status = status;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
