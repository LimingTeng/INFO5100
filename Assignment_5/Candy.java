/**
 * Created by LynnTeng on 2018/10/16.
 */
public class Candy extends DessertItem {
    private double weight;
    private int pricePerLb;

    public Candy(String name, double weight, int pricePerLb) {
        super(name);
        this.weight = weight;
        this.pricePerLb = pricePerLb;
    }

    public int getCost() {
        int cost = (int)Math.round(pricePerLb * weight);
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public int getPricePerLb() {
        return pricePerLb;
    }
}
