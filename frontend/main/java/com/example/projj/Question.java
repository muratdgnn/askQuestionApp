package com.example.projj;

public class Question {
    private String name;
    private String text;

    public Question(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString(){
        return name + ": " + text;
    }
}
