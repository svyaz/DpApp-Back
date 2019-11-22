package com.github.svyaz.dppointsservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CITY")
public class City {
    //TODO: сделать ID через базу
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    @JsonBackReference
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<DpPoint> dpPoints;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
