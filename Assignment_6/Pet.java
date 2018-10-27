/**
 * Created by LynnTeng on 2018/10/26.
 */
public class Pet {
    private String petName, ownerName, color;
    public static final int MALE=1, FEMALE=2, SPAYED=3, NEUTERED=4;
    protected int sex;

    public Pet (String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setSex(int sexid) {
        try {
            switch(sexid) {
            case MALE:
                return "MALE";
                break;
            case FEMALE:
                return "FEMALE";
                break;
            case SPAYED:
                return "SPAYED";
                break;
            case NEUTERED:
                return "NEUTERED";
                break;
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Value not allowed!");
        }
    }

    String getSex() {
        return this.sex = sexid;
    }


    public String toString() {
        return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex();
    }
}
