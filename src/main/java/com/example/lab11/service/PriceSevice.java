package com.example.lab11.service;

import org.springframework.stereotype.Service;

@Service
public class PriceSevice {
    public int[] calculateSaleAndRedemptionPrice(int itemPrice, int months) {
        if(itemPrice <= 0 || months < 0) {
            throw new IllegalArgumentException("Item price should be greater than 0 and months should be non-negative");
        }
        int[] result = new int[2];

        // Рассчитываем цену за продажу (примерно 70% от изначальной цены)
        int salePrice = (int) (itemPrice * 0.7);
        result[0] = salePrice;

        // Рассчитываем цену за выкуп через n месяцев
        int redemptionPrice = (int) (itemPrice * 0.7 * Math.pow(1.05, months)); // Предполагаем 5% рост цены каждый месяц
        result[1] = redemptionPrice;

        return result;
    }
}
