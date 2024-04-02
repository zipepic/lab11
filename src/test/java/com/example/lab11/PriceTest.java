package com.example.lab11;

import com.example.lab11.service.PriceSevice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceTest {
    private PriceSevice priceService = new PriceSevice();
    @Test
    void testCalculateSaleAndRedemptionPrice_WithZeroMonths() {
        int[] expected = {70, 70};
        assertArrayEquals(expected, priceService.calculateSaleAndRedemptionPrice(100, 0));
    }

    @Test
    void testCalculateSaleAndRedemptionPrice_WithOneMonth() {
        int[] expected = {70, 73};
        assertArrayEquals(expected, priceService.calculateSaleAndRedemptionPrice(100, 1));
    }

    @Test
    void testCalculateSaleAndRedemptionPrice_WithThreeMonths() {
        int[] expected = {70, 81};
        assertArrayEquals(expected, priceService.calculateSaleAndRedemptionPrice(100, 3));
    }

    @Test
    void testCalculateSaleAndRedemptionPrice_WithSixMonths() {
        int[] expected = {70, 93};
        assertArrayEquals(expected, priceService.calculateSaleAndRedemptionPrice(100, 6));
    }

    @Test
    void testCalculateSaleAndRedemptionPrice_WithTenMonths() {
        int[] expected = {70, 114};
        assertArrayEquals(expected, priceService.calculateSaleAndRedemptionPrice(100, 10));
    }
    @Test
    void testCalculateSaleAndRedemptionPrice_NegativeItemPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            priceService.calculateSaleAndRedemptionPrice(-100, 6);
        });
    }

    @Test
    void testCalculateSaleAndRedemptionPrice_ZeroItemPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            priceService.calculateSaleAndRedemptionPrice(0, 6);
        });
    }

    @Test
    void testCalculateSaleAndRedemptionPrice_NegativeMonths() {
        assertThrows(IllegalArgumentException.class, () -> {
            priceService.calculateSaleAndRedemptionPrice(100, -6);
        });
    }
}
