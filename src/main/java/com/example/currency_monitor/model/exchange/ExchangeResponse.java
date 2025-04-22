package com.example.currency_monitor.model.exchange;

public record ExchangeResponse(String cur_unit, String cur_nm, String deal_bas_r) {} //API를 통해 받아온 값을 추리기 위한 DTO
