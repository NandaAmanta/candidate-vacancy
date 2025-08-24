package com.nanda.candidate_vacancy.commons.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    public boolean success;
    public String message;
    public T data;
}
