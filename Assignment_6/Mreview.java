/**
 * Created by LynnTeng on 2018/10/26.
 */
import java.util.*;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private ArrayList<Integer> ratings;

    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl, int firstRating) {
        this.title = ttl;
        this.ratings = new ArrayList<>(firstRating);
    }

    public static void main(String[] args) {
        Mreview mreview = new Mreview("Kill Bill");
        mreview.addRating(3);
        mreview.addRating(4);
        mreview.addRating(3);
        System.out.println(mreview.toString());
        System.out.println(mreview.aveRating());

    }

    public static void addRating(int r) {
        ratings.add(r);
    }

    public double aveRating() {
        double ave = 0.0;
        for(int rate : ratings) {
            ave += rate;
        }
        ave = ave / ratings.size();
        return ave;
    }

    public int compareTo(Mreview obj) {
        return this.title.compareTo(obj.title);
    }

    public boolean equals(Object obj) {
        if(this.title.equals(obj)) {
            obj = new Mreview();
            return this.title.equals(obj);
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public int numRatings() {
        return ratings.size();
    }

    public String toString() {
        return getTitle() + ", average " + aveRating() + " out of " + numRatings() + " ratings";
    }

}
