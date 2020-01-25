package com.lits.borysov.restApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankModel {

    @JsonProperty("StartDate")
    private String StartDate;
    @JsonProperty("TimeSign")
    private String TimeSign;
    @JsonProperty("CurrencyCode")
    private String CurrencyCode;
    @JsonProperty("CurrencyCodeL")
    private String CurrencyCodeL;
    @JsonProperty("Units")
    private int Units;
    @JsonProperty("Amount")
    private Double Amount;
}
