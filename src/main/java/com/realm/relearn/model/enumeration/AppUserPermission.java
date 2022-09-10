package com.realm.relearn.model.enumeration;

public enum AppUserPermission {
    READ_POST("read:post"),
    WRITE_POST("write:post"),
    READ_COMMENT("read:comment"),
    WRITE_COMMENT("write:comment");

    private final String permission;

    AppUserPermission(String permission){
        this.permission= permission;
    }
    public String getPermission() {
        return permission;
    }
}
