package com.github.svyaz.dppointsservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BANK")
public class Bank {

    //TODO: сделать ID через базу
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
    private Set<DpPoint> dpPoints = new HashSet<>();

    @Column(name = "NAME", nullable = false)
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
