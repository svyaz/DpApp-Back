package com.github.svyaz.dppointsservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "bank")
    private Set<DpPoint> dpPoints = new HashSet<>();

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DpPoint> getDpPoints() {
        return dpPoints;
    }

    public void setDpPoints(Set<DpPoint> dpPoints) {
        this.dpPoints = dpPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}