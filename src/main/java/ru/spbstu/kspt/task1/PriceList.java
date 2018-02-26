package ru.spbstu.kspt.task1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Main class
 */

public class PriceList {
    private final Map<Integer, Product> pricelist = new HashMap<>();

    public void addProduct(String name, int code, int priceRub, int priceCop, int quantity) {
        pricelist.put(code, new Product(name, code, priceRub, priceCop, quantity));
    }

    public void removeProduct(int currentCode) {
        pricelist.remove(currentCode);
    }

    public void priceChange(int currentCode, int currentPriceRub, int currentPriceCop) {
        if (pricelist.containsKey(currentCode)) {
            Product productChanged = new Product(pricelist.get(currentCode).getName(), currentCode, currentPriceRub,
                    currentPriceCop, pricelist.get(currentCode).getQuantity());
            pricelist.replace(currentCode, productChanged);
        }
    }

    public void nameChange(int currentCode, String currentName) {
        if (pricelist.containsKey(currentCode)) {
            Product productChanged = new Product(currentName, currentCode, pricelist.get(currentCode).getPriceRub(),
                    pricelist.get(currentCode).getPriceCop(), pricelist.get(currentCode).getQuantity());
            pricelist.replace(currentCode, productChanged);
        }
    }

    public int[] theTotalCost(int currentCode) {
        try{
            return new int[]{pricelist.get(currentCode).getCostRub(),
                    pricelist.get(currentCode).getCostCop()};
        }  catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceList)) return false;
        PriceList priceList = (PriceList) o;
        return pricelist.equals(priceList.pricelist);
    }

    @Override
    public int hashCode() {
        return pricelist.hashCode();
    }
}

