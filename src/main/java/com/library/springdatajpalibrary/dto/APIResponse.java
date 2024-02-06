package com.library.springdatajpalibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    T response;
    // if is = 0 => show Data else in Ui show Message:...
    Integer status;

}
