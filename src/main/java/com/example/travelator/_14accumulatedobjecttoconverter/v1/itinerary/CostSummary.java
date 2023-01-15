package com.example.travelator._14accumulatedobjecttoconverter.v1.itinerary;


import com.example.travelator._14accumulatedobjecttoconverter.v1.money.CurrencyConversion;
import com.example.travelator._14accumulatedobjecttoconverter.v1.money.Money;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CostSummary {
    private final List<CurrencyConversion> lines = new ArrayList<>();
    private Money total;

    public CostSummary(Currency userCurrency) {
        this.total = Money.of(0, userCurrency);
    }

    public void addLine(CurrencyConversion line) {
        lines.add(line);
        total = total.add(line.getToMoney());
    }

    public List<CurrencyConversion> getLines() {
        return List.copyOf(lines);
    }

    public Money getTotal() {
        return total;
    }
}