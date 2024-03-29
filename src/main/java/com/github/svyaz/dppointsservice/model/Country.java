package com.github.svyaz.dppointsservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_SEQ_GEN")
    @SequenceGenerator(name = "COUNTRY_SEQ_GEN", sequenceName = "COUNTRY_ID_SEQ",
            initialValue = 1, allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<City> cities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
