package com.example.currencyservice.controller;

import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/currencyConverter")
public class CurrencyController {

    @GetMapping("/convert/{fromCurrency}/{value}")
    public int convert(@PathVariable String fromCurrency,
                       @PathVariable int value) {
        return switch (fromCurrency) {
            case "RS" -> value;
            case "USD" -> value * 80;
            case "EURO" -> value * 100;
            case "Pounds" -> value * 120;
            default -> -1;
        };
    }
}
