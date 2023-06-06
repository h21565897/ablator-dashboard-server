package com.ablator.dashboard.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseVo<T> {
    private Integer code;
    private T data;
    private String showMessage;
    private String errorMessage;


    public static <T> ResponseVo<T> success() {
        return ResponseVo.<T>builder().code(0).build();
    }

    public static <T> ResponseVo<T> success(T data) {
        return ResponseVo.<T>builder().code(0).data(data).build();
    }

    public static <T> ResponseVo<T> success(T data, String showMsg) {
        return ResponseVo.<T>builder().code(0).data(data).showMessage(showMsg).build();
    }

    public static <T> ResponseVo<T> fail(String showMsg, String errorMsg) {
        return new ResponseVo<>(1, null, showMsg, errorMsg);
    }

}
