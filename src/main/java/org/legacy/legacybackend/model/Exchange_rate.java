package org.legacy.legacybackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Exchange_rate {
    /** Time of the market data used to calculate exchange rate */
    private String time;

    /** Exchange rate base asset identifier */
    private String asset_id_base;

    /** Exchange rate quote asset identifier */
    private String asset_id_quote;

    /** Exchange rate between assets */
    private double rate;
}
