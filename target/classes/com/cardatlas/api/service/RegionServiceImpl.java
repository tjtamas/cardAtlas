package com.cardatlas.api.service;

import com.cardatlas.api.dto.RegionDto;
import com.cardatlas.api.mapper.RegionMapper;
import com.cardatlas.api.model.Region;
import com.cardatlas.api.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Jelzi a Spring-nek, hogy ez a Service réteg logikája
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    // A Spring automatikusan "beadja" (inject) a szükséges Repository-t és Mapper-t
    public RegionServiceImpl(RegionRepository regionRepository, RegionMapper regionMapper) {
        this.regionRepository = regionRepository;
        this.regionMapper = regionMapper;
    }

    @Override
    public List<RegionDto> findAll() {
        // 1. Lekérjük az összes Region entitást az adatbázisból
        List<Region> regions = regionRepository.findAll();
        // 2. A Mapper segítségével átalakítjuk őket DTO listává és visszaadjuk
        return regionMapper.toDtoList(regions);
    }

    @Override
    public Optional<RegionDto> findById(Long id) {
        // 1. Lekérjük a Region entitást ID alapján (ez egy Optional-t ad vissza)
        Optional<Region> regionOptional = regionRepository.findById(id);
        // 2. A .map() segítségével csak akkor alakítjuk át DTO-vá, ha létezik,
        //    majd visszaadjuk az eredményt (ami egy Optional<RegionDto>)
        return regionOptional.map(regionMapper::toDto);
    }
}