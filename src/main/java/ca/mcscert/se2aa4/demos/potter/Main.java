package ca.mcscert.se2aa4.demos.potter;

import static ca.mcscert.se2aa4.demos.potter.Book.*;

public class Main {
    public static void main(String[] args) {
        emptyOrders();
        basicScenarios();
        simpleDiscounts();
        severalDiscounts();
        edgeCase();
    }

    private static void emptyOrders() {
        System.out.println("** Empty Carts **");
        Cashier cashier = new Cashier();
        System.out.println("Null cart:  " + cashier.price(null));
        System.out.println("Empty cart: " + cashier.price(new Cart()));
    }

    private static void basicScenarios() {
        System.out.println("** Basic Carts **");
        Cashier cashier = new Cashier();
        System.out.println("Book 1: " + cashier.price(new Cart(BOOK1)));
        System.out.println("Book 2: " + cashier.price(new Cart(BOOK2)));
        System.out.println("Book 3: " + cashier.price(new Cart(BOOK3)));
        System.out.println("Book 4: " + cashier.price(new Cart(BOOK4)));
        System.out.println("Book 5: " + cashier.price(new Cart(BOOK5)));
        System.out.println("2 x Book 1: " + cashier.price(new Cart(BOOK1, BOOK1)));
        System.out.println("3 x Book 2: " + cashier.price(new Cart(BOOK2, BOOK2, BOOK2)));
    }

    private static void simpleDiscounts() {
        System.out.println("** Simple Discounts **");
        Cashier cashier = new Cashier();
        System.out.println("Book 1 -> 5: " + cashier.price(new Cart(BOOK1, BOOK2, BOOK3, BOOK4, BOOK5)));
        System.out.println("Book 1 -> 4: " + cashier.price(new Cart(BOOK1, BOOK2, BOOK3, BOOK4)));
        System.out.println("Book 1 -> 3: " + cashier.price(new Cart(BOOK1, BOOK2, BOOK3)));
        System.out.println("Book 1 -> 2: " + cashier.price(new Cart(BOOK1, BOOK2)));   
    }

    private static void severalDiscounts() {
        System.out.println("** Multiple Discounts **");
        Cashier cashier = new Cashier();
        System.out.println("B1, B1, B2: " + cashier.price(new Cart(BOOK1, BOOK1, BOOK2)));
        System.out.println("B1, B1, B2, B2: " + cashier.price(new Cart(BOOK1, BOOK1, BOOK2, BOOK2)));
        System.out.println("B1, B1, B2, B3, B4: " + cashier.price(new Cart(BOOK1, BOOK1, BOOK2, BOOK3, BOOK4)));
        System.out.println("B1, B2, B2, B3, B4, B5: " + cashier.price(new Cart(BOOK1, BOOK2, BOOK2, BOOK3, BOOK3, BOOK5)));
    }

    private static void edgeCase() {
        System.out.println("** Edge Cases **");
        Cashier cashier = new Cashier();
        Cart c = new Cart(BOOK1, BOOK1, BOOK2, BOOK2, BOOK3, BOOK3, BOOK4, BOOK5);
        System.out.println("B1, B1, B2, B2, B3, B3, B4, B5: " + cashier.price(c));

        Cart allin = new Cart(
                BOOK1, BOOK1, BOOK1, BOOK1, BOOK1,
                BOOK2, BOOK2, BOOK2, BOOK2, BOOK2,
                BOOK3, BOOK3, BOOK3, BOOK3,
                BOOK4, BOOK4, BOOK4, BOOK4, BOOK4,
                BOOK5, BOOK5, BOOK5, BOOK5 );
        System.out.println("All in: " + cashier.price(allin));
    }

}
