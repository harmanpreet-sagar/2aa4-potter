package ca.mcscert.se2aa4.demos.potter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class  Discount {

    private int nbBooks;
    private double percentage;

    public Discount(int nbBooks, double percentage) {
        this.nbBooks = nbBooks;
        this.percentage = percentage;
    }

    public boolean canBeApplied(Cart b) {
        return b.howManyDifferent() >= nbBooks;
    }

    public double apply(Cart b) {
        return Cashier.PRICE * nbBooks * percentage;
    }

    public Cart removePayedBooks(Cart b) {
        Map<Book, Integer> data = contents(b);
        Book[] consumed =
                data.entrySet().stream()
                        .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()).subList(0, nbBooks).toArray(new Book[]{});
        Cart result = b.duplicate();
        result.remove(consumed);
        return result;
    }

    private Map<Book, Integer> contents(Cart b) {
        Map<Book, Integer> data = new HashMap<>();
        for(Book book: Book.values())
            data.put(book, b.howMany(book));
        return data;
    }
}
