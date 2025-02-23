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

    public void setName(String name) {
        this.name = name;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @NonNull
    @Override
    public String toString(){
        return name + ": " + comm;
    }
}
