import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by LynnTeng on 2018/10/19.
 */
class DessertShoppeTest {

    @Test
    void cents2dollarsAndCents() {
        String expectCents2dollarsAndCents = "1.05";

        String actualCents2dollarsAndCents = DessertShoppe.cents2dollarsAndCents(105);

        assertEquals(expectCents2dollarsAndCents, actualCents2dollarsAndCents);
    }
}
