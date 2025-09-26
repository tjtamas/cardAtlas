package com.cardatlas.api.repository;

import com.cardatlas.api.model.RegionTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionTranslationRepository extends JpaRepository<RegionTranslation, Long> {

    Optional<RegionTranslation> findByRegionIdAndLangCode(Long regionId, String langCode);
}