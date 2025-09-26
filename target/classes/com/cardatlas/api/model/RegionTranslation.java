package com.cardatlas.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "region_translations")
@IdClass(RegionTranslationId.class) // <-- 1. Módosítás: Jelöljük, hogy összetett kulcsot használ
public class RegionTranslation {

    @Id
    private Long region_id;

    @Id
    private String lang_code;

    private String name;


    public Long getRegion_id() { return region_id; }
    public void setRegion_id(Long region_id) { this.region_id = region_id; }
    public String getLang_code() { return lang_code; }
    public void setLang_code(String lang_code) { this.lang_code = lang_code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}