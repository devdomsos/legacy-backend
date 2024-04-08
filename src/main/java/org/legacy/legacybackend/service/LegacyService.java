package org.legacy.legacybackend.service;

import org.legacy.legacybackend.model.CoinApiResponse;
import org.legacy.legacybackend.model.Exchange_rate;
import org.legacy.legacybackend.model.RAndMChar;
import org.legacy.legacybackend.model.RAndMResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
public class LegacyService {

    // docs at https://docs.coinapi.io/market-data/rest-api/
    private RestClient restClient = RestClient.builder()
            .baseUrl("https://rest.coinapi.io/v1")
            .build();

    private RestClient rickRestClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();

    public Exchange_rate getEthExchangeRate() {
        return Objects.requireNonNull(restClient.get()
                        .uri("/exchangerate/ETH/USD")
                        .header("X-CoinAPI-Key", "F11A11C0-885D-0A68-EE4E-750164280859")
                        .retrieve()
                        .body(Exchange_rate.class));
    }


    //getPlsExchangeRate
    public Exchange_rate getPlsExchangeRate() {
        return Objects.requireNonNull(restClient.get()
                .uri("/exchangerate/PLS/USD")
                .header("X-CoinAPI-Key", "F11A11C0-885D-0A68-EE4E-750164280859")
                .retrieve()
                .body(Exchange_rate.class));
    }

    public List<RAndMChar> getAllRickAndMortyChars() {
        return rickRestClient.get()
                .uri("/character")
                .retrieve()
                .body(RAndMResponse.class)
                .getResults();
    }

    public RAndMChar getRickAndMortyCharById(int id) {
        return rickRestClient.get()
                .uri("/character/"+ id  )
                .retrieve()
                .body(RAndMChar.class);
    }

    public List<RAndMChar> getRickAndMortyFilteredByStatus(String status) {
        return rickRestClient.get()
                .uri("/character/?status="+ status  )
                .retrieve()
                .body(RAndMResponse.class)
                .getResults();
    }

    public List<RAndMChar> getRickAndMortyCharsFilteredBySpecies(String species) {
        return rickRestClient.get()
                .uri("/character/?species="+ species  )
                .retrieve()
                .body(RAndMResponse.class)
                .getResults();
    }

}
