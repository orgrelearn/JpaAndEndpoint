package com.realm.relearn.model.enumeration;

public enum Category {
    TECHNOLOGY("Technology"),
    BLOCKCHAIN("Blockchain"),
    BUSINESS("Business"),
    AI("Artificial Intelligence"),
    CRYPTO("Crypto"),
    LEADERSHIP("Leadership");

    private final String category;
    Category(String category) {this.category=category;}
    public String getCategory(){
        return category;
    }
}
