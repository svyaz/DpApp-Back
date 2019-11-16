package com.github.svyaz.dppointsservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DPSERVICE")
public class DpService {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToMany(mappedBy = "dpServices")
    private Set<DpPoint> dpPoints = new HashSet<>();

    @Column(name = "NAME")
    private String name;

    //TODO: for debug
    public DpService(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
