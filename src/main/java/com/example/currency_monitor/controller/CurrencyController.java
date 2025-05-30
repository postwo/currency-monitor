package com.example.currency_monitor.controller;


import com.example.currency_monitor.model.currency.CurrencyResponse;
import com.example.currency_monitor.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currencies")
public class CurrencyController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/{currency}")
    public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable String currency) {
        var exchange = exchangeService.getExchangeByCurrency(currency);
        var currencyResponse = CurrencyResponse.from(exchange);
        return ResponseEntity.ok(currencyResponse);
    }
}
