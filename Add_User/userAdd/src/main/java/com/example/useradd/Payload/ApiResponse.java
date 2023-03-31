package com.example.useradd.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean success;
    private Object object;

    public ApiResponse(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

}
