package com.cardatlas.api.mapper;

import com.cardatlas.api.dto.RegionDto;
import com.cardatlas.api.model.Region;
import com.cardatlas.api.model.RegionTranslation;
import com.cardatlas.api.repository.RegionTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegionMapper {

    private final RegionTranslationRepository translationRepository;

    @Autowired
    public RegionMapper(RegionTranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    /**
     * Átalakít egy Region entitást RegionDto-vá.
     * Megkeresi a magyar nyelvű fordítást, ha nincs, a régió kódját használja névként.
     * @param region A konvertálandó Region entitás.
     * @return A kész RegionDto.
     */
    public RegionDto toDto(Region region) {
        // Keressük meg a magyar fordítást a kapott régió ID-jához
        String name = translationRepository.findByRegionIdAndLangCode(region.getId(), "hu")
                .map(RegionTranslation::getName) // Ha van találat, annak a nevét vesszük
                .orElse(region.getCode());     // Ha nincs, a "code" mezőt használjuk fallbackként

        return new RegionDto(region.getId(), name);
    }

    /**
     * Átalakít egy listányi Region entitást egy listányi RegionDto-vá.
     * @param regions A konvertálandó Region entitások listája.
     * @return A kész RegionDto-k listája.
     */
    public List<RegionDto> toDtoList(List<Region> regions) {
        return regions.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


}