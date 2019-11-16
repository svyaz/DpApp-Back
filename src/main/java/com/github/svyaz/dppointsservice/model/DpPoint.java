package com.github.svyaz.dppointsservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dp-point")
public class DpPoint {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dp-point_dp-service",
            joinColumns = @JoinColumn(name = "dp-point_id"),
            inverseJoinColumns = @JoinColumn(name = "dp-service_id")
    )
    private Set<DpService> dpServices = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Set<DpService> getDpServices() {
        return dpServices;
    }

    public void setDpServices(Set<DpService> dpServices) {
        this.dpServices = dpServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
