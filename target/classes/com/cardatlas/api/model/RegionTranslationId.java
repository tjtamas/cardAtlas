package com.cardatlas.api.model;

import java.io.Serializable;
import java.util.Objects;

public class RegionTranslationId implements Serializable {

    private Long region_id;
    private String lang_code;

    public RegionTranslationId() {
    }

    public RegionTranslationId(Long region_id, String lang_code) {
        this.region_id = region_id;
        this.lang_code = lang_code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionTranslationId that = (RegionTranslationId) o;
        return Objects.equals(region_id, that.region_id) && Objects.equals(lang_code, that.lang_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region_id, lang_code);
    }
}