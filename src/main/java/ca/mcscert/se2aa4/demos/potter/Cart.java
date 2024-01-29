package ca.mcscert.se2aa4.demos.potter;

import java.util.EnumMap;
import java.util.Map;

public class Cart {

    private Map<Book, Integer> contents = new EnumMap<>(Book.class);

    public Cart() {
        for(Book b: Book.values())
            contents.put(b,0);
    }

    public Cart(Book... chosen) {
        this();
        for(Book book: chosen) {
            contents.put(book, contents.get(book) + 1);
        }
    }

    private Cart(Map<Book, Integer> data) { this.contents = data; }

    public int howMany(Book b) {
        return contents.get(b);
    }

    public int howManyDifferent() {
        return (int) contents.entrySet().stream().filter(pair -> pair.getValue() > 0).count();
    }

    public int howManyBooks() {
        return contents.entrySet().stream().map(Map.Entry::getValue).reduce(0, Integer::sum);
    }

    public boolean isEmpty() { return howManyDifferent() == 0; }

    public void remove(Book... removed) {
        for(Book book: removed) {
            contents.put(book, contents.get(book) - 1);
        }
    }

    public Cart duplicate() {
        Map<Book, Integer> copy = new EnumMap<>(Book.class);
        copy.putAll(contents);
        return new Cart(copy);
    }
}