/**
 * Created by LynnTeng on 2018/10/26.
 */

import java.util.Calendar;

public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    public Cat(String petName, String ownerName, String color, String hairLength){
        super(petName, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }
    public String toString() {
        return "CAT: \n" + getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex() + "\nHair: " + getHairLength();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        start.set(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        end.set(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if(calendar.compareTo(start) >= 0 && calendar.compareTo(end) <= 0) {
            return true;
        }
        return false;
    }
}