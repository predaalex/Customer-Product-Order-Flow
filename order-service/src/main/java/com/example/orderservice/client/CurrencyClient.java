package com.example.orderservice.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface CurrencyClient {

    @GetExchange("currencyConverter/convert/{fromCurrency}/{value}")
    public int convert(@PathVariable("fromCurrency") String fromCurrency,
                       @PathVariable("value") int value);
}
