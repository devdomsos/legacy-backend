package org.legacy.legacybackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AssetIdQuote {
    List<Exchange_rate> exchange_rates;
    String ETH;
}
