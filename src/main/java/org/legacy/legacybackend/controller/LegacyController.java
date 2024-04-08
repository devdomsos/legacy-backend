package org.legacy.legacybackend.controller;

import lombok.RequiredArgsConstructor;
import org.legacy.legacybackend.model.Exchange_rate;
import org.legacy.legacybackend.model.RAndMChar;
import org.legacy.legacybackend.model.RAndMResponse;
import org.legacy.legacybackend.service.LegacyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LegacyController {

    private final LegacyService legacyService;
    // OpenAPI
    @GetMapping("/price")
    public void getPrices() {
        List<Exchange_rate> pirceOfEth = legacyService.getEthExchangeRate();
        System.out.println("Output: " + pirceOfEth);
    }
    // Rick and Morty API
    @GetMapping("/chars")
    public List<RAndMChar> getAllRickAndMortyChars() {
        return legacyService.getAllRickAndMortyChars();
    }

    @GetMapping("/chars/{id}")
    public RAndMChar getRickAndMortyCharById(@PathVariable int id) {
        return legacyService.getRickAndMortyCharById(id);
    }
    @GetMapping("/chars/")
    public List<RAndMChar> getRickAndMortyFilteredByStatus(@RequestParam String status) {
        return legacyService.getRickAndMortyFilteredByStatus(status);
    }

    @GetMapping("/species-statistic/")
    public List<RAndMChar> getRickAndMortyCharsFilteredBySpecies(@RequestParam String species) {
        return legacyService.getRickAndMortyCharsFilteredBySpecies(species);
    }
}
