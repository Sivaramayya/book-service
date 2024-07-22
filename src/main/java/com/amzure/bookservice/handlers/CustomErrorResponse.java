package com.amzure.bookservice.handlers;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {
	
	private int statusCode;
    private String message;
    private Map<String, String> errors;
    
}
