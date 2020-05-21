package pupils;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private int birth;

    public Pupil() {
    }

    public Pupil(int number, String name, Gender gender, int birth) {
       setNumber(number);
       setName(name);
       setGender(gender);
       setBirth(birth);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    String [] namesWomen = {"Александра" , "Алина", "Алла", "Анастасия", "Валентина", "Валерия", "Вероника"};
    String [] namesMen = {"Александр", "Алексей", "Анатолий", "Андрей", "Антон", "Аркадий", "Артем", "Вадим", "Валерий"};



    public void setPropertiesWomen (){
        setNumber(number + 1);
        setGender(Gender.FEMALE);
        setName(namesWomen[(int) (Math.random() * 7)]);
        setBirth((int)(Math.random()* 5 + 1995));
        setNumber(getNumber() + 1);
    }

    public void setPropertiesMen (){
        setNumber(getNumber() + 1);
        setGender(Gender.MALE);
        setName(namesMen[(int)(Math.random() * 9)]);
        setBirth((int)(Math.random() * 5 + 1995));
        setNumber(getNumber() + 1);
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

}
