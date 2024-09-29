package com.jay.user_service.entity.column;

public enum Role {

    ADMIN("admin"),
    USER("user");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    String getName(){
        return this.name;
    }

}
