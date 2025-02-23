package com.example.projj;

import androidx.annotation.NonNull;

public class Comment {
    private String name;
    private String comm;

    public Comment(String name, String comm) {
        this.name = name;
        this.comm = comm;
    }

    public String getName() {
        return name;
    }

    public String getComm() {
        return comm;
    }

    @NonNull
    @Override
    public String toString(){
        return name + ": " + comm;
    }
}
