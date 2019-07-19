package com.toycompany.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.toycompany.demo.Model.Repository.Rate;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    private String currency;
    private String code;
    private List<Rate> rates = new ArrayList<>();

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
