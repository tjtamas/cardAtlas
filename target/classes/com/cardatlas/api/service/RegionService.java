package com.cardatlas.api.service;

import com.cardatlas.api.dto.RegionDto;
import java.util.List;
import java.util.Optional;

public interface RegionService {

    /**
     * Visszaadja az összes régiót DTO formátumban.
     * @return Régió DTO-k listája.
     */
    List<RegionDto> findAll();

    /**
     * Megkeres egy régiót azonosító alapján.
     * @param id A keresett régió azonosítója.
     * @return Egy Optional, ami a megtalált Régió DTO-t tartalmazza, vagy üres.
     */
    Optional<RegionDto> findById(Long id);
}