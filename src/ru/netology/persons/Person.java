package ru.netology.persons;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);
//                .setAge(0);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age.getAsInt();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age = OptionalInt.of(this.age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        if (age != null) {
            return name + " " + surname +
                    " (" + age.getAsInt() +
                    ", " + address + ')';
        } else {
            return name + " " + surname +
                    " (" + address + ')';
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
