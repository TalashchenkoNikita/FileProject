package homework;

public class People {
    private final String name;
    private final int age;
    private final Sex sex;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex;
    }

    public enum Sex {
        MAN, WOMAN
    }
}
