/**
 * Created by LynnTeng on 2018/10/16.
 */
public class DessertShoppe {
    public static final double TAX_RATE = 6.5;  // 6.5%
    public static final String STORE_NAME = "M & M DessertShoppe";
    public static final int MAX_ITEM_NAME_SIZE = 25;
    public static final int COST_WIDTH = 6;

    public static String cents2dollarsAndCents(int cents) {
        String s = "";
        if (cents < 0) {
            s = s + "-";
            cents = cents * -1;
        }

        int dollars = cents / 100;
        cents = cents % 100;
        if (dollars > 0) {
            s = s + dollars;
        }
        s = s + ".";
        if (cents < 10) {
            s = s + "0";
        }
        s = s + cents;
        return s;
    }
}
