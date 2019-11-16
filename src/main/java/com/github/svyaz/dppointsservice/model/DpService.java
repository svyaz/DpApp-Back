package com.github.svyaz.dppointsservice.model;

public class DpService {
    private int id;
    private String name;

    //TODO: for debug
    public DpService(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
