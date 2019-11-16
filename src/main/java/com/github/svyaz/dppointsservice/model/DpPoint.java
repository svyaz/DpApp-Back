package com.github.svyaz.dppointsservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DPPOINT")
public class DpPoint {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CITY_ID", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "BANK_ID", nullable = false)
    private Bank bank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DPPOINT_DPSERVICE",
            joinColumns = @JoinColumn(name = "DPPOINT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DPSERVICE_ID")
    )
    private Set<DpService> dpServices = new HashSet<>();

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
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
