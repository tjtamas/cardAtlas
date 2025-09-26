package com.cardatlas.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    private Long id;
    private Long country_id;
    private String code;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCountry_id() { return country_id; }
    public void setCountry_id(Long country_id) { this.country_id = country_id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}