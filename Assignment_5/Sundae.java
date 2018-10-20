/**
 * Created by LynnTeng on 2018/10/16.
 */
public class Sundae extends IceCream {
    private String nameTopping;
    private int costTopping;

    public Sundae(String nameIceCream, int costIceCream, String nameTopping, int costTopping) {
        super(nameIceCream, costIceCream);
        this.nameTopping = nameTopping;
        this.costTopping = costTopping;
    }

    public int getCost() {
        return super.getCost() + costTopping;
    }

    public String getNameTopping() {
        return nameTopping;
    }

    public int getCostTopping() {
        return costTopping;
    }
}
