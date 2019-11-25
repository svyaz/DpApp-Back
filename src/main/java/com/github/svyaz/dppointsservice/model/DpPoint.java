package com.github.svyaz.dppointsservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DPPOINT")
public class DpPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DPPOINT_SEQ_GEN")
    @SequenceGenerator(name = "DPPOINT_SEQ_GEN", sequenceName = "DPPOINT_ID_SEQ",
            initialValue = 1, allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CITY_ID", nullable = false)
    @JsonManagedReference
    private City city;

    @ManyToOne
    @JoinColumn(name = "BANK_ID", nullable = false)
    @JsonManagedReference
    private Bank bank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinTable(name = "DPPOINT_DPSERVICE",
            joinColumns = @JoinColumn(name = "DPPOINT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DPSERVICE_ID")
    )
    private Set<DpService> dpServices;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
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
