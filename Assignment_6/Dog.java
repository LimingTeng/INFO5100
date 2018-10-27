/**
 * Created by LynnTeng on 2018/10/26.
 */
import java.util.Calendar;

public class Dog extends Pet implements Boardable{
    private String size;
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    public Dog(String petName, String ownerName, String color, String size){
        super(petName, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
    public String toString() {
        return "DOG: \n" + getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex() + "\nSize: " + getSize();
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