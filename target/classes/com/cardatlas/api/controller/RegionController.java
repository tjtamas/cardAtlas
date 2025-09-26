package com.cardatlas.api.controller;

import com.cardatlas.api.dto.RegionDto;
import com.cardatlas.api.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    // Most már a Service-től függünk, nem a Repository-tól
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public List<RegionDto> getAllRegions() {
        // A controller csak hívja a service-t, a "piszkos munkát" az végzi
        return regionService.findAll();
    }

    // Új végpont egy konkrét régió lekérdezéséhez
    @GetMapping("/{id}")
    public ResponseEntity<RegionDto> getRegionById(@PathVariable Long id) {
        return regionService.findById(id)
                .map(regionDto -> ResponseEntity.ok(regionDto)) // Ha a service találta, 200 OK válasszal küldjük vissza
                .orElse(ResponseEntity.notFound().build());      // Ha nem, 404 Not Found választ adunk
    }
}