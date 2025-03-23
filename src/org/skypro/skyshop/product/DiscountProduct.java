package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private final int discountPercent;

    public DiscountProduct(String name, int basePrice, int discountPercent) {
        super(name, (int) (basePrice * (100 - discountPercent) / 100.0));
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %d руб. (%d%%)",
                getName(),
                getPrice(),
                discountPercent
        );
    }
}
