package com.example.shortenurl.common;

import lombok.Getter;

@Getter
public enum ResCode {

    SUCCESS("00", "SUCCESS"),
    INTERNAL_ERROR("99", "INTERNAL_ERROR");
    private String code;
    private String description;
    ResCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
