package com.toycompany.demo.Model.Service;

import com.toycompany.demo.Model.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPService implements CurrencyService {

    @Override
    public Currency getCurrency(String currency){
        String apiPath = "http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/?format=json";
        return new RestTemplate().getForObject(apiPath,Currency.class);
    }
}
