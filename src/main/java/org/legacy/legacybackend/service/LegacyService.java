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

    public List<Exchange_rate> getEthExchangeRate() {
        return Objects.requireNonNull(restClient.get()
                        .uri("/exchangerate/ETH?filter_asset_id=USD&invert=false")
                        .header("X-CoinAPI-Key", "APIKEY")
                        .retrieve()
                        .body(CoinApiResponse.class))
                .getAsset_id_base()
                .getExchange_rates();
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
}
