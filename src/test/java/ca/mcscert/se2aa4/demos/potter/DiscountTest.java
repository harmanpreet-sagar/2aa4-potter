package ca.mcscert.se2aa4.demos.potter;

import static ca.mcscert.se2aa4.demos.potter.Book.BOOK1;
import static ca.mcscert.se2aa4.demos.potter.Book.BOOK2;
import static ca.mcscert.se2aa4.demos.potter.Book.BOOK3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    private Cart cart;

    @BeforeEach
    public void initializeCart() {
        cart = new Cart(BOOK1, BOOK2, BOOK3);
    }
    
    @Test
    public void sampleTest() {
        assertEquals(1, 1);
    }

    @Test
    public void twoDifferentBooks() {
        Discount discount = new Discount(2, 0.9);
        assertTrue(discount.canBeApplied(cart));
        cart.remove(BOOK1);
        assertTrue(discount.canBeApplied(cart));
        cart.remove(BOOK2);
        assertFalse(discount.canBeApplied(cart));
    }

    @Test
    public void threeDifferentBooks() {
        Discount discount = new Discount(3, 0.9);
        assertTrue(discount.canBeApplied(cart));
        cart.remove(BOOK1);
        assertFalse(discount.canBeApplied(cart));
    }
}
