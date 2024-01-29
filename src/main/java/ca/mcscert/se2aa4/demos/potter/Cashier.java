package ca.mcscert.se2aa4.demos.potter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cashier {

    public static final double PRICE = 8.0;

    private List<Discount> discounts =
            Arrays.asList(new Discount(5, 0.75), new Discount(4, 0.80),
                          new Discount(3, 0.90), new Discount(2, 0.95) );

    public double price(Cart b) {
        if(b == null) { return 0.0; }
        return compute(b);
    }

    private double compute(Cart b) {
        if(b.isEmpty()) { return 0.0; }

        List<Discount> availables = findAvailableDiscount(b);
        if(availables.isEmpty()) {
            return PRICE * b.howManyBooks();
        } else {
            return availables.stream().map(d -> compute(b, d)).min(Double::compare).get();
        }
    }

    private double compute(Cart b, Discount d) {
        double local = d.apply(b);
        Cart remaining = d.removePayedBooks(b);
        return local + compute(remaining);
    }

    private List<Discount> findAvailableDiscount(Cart b) {
        return discounts.stream().filter(d -> d.canBeApplied(b)).collect(Collectors.toList());
    }

}
