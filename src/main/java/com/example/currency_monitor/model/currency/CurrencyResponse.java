package com.example.currency_monitor.model.currency;

import com.example.currency_monitor.model.exchange.ExchangeResponse;

public record CurrencyResponse(String unit, String name, Double rate) { // 서버가 클라이언트에게 응답 데이터를 전달하기 위해 사용하는 DTO
    public static CurrencyResponse from(ExchangeResponse exchangeResponse) {
        return new CurrencyResponse(
                exchangeResponse.cur_unit (),
                exchangeResponse.cur_nm(),
                Double.parseDouble(exchangeResponse.deal_bas_r().replace(",", "")));
    }
}
