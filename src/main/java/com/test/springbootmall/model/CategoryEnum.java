package com.test.springbootmall.model;

public enum CategoryEnum {
    電子產品,
    水果,
    房地產,
    餅乾,
    手搖;
    public static boolean isValid(String value) {
        for (CategoryEnum category : CategoryEnum.values()) {
            if (category.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
