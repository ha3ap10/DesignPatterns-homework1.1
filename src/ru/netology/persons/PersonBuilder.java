package ru.netology.persons;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Неправильно указан возраст!");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) throw new IllegalStateException("Не введено имя!");
        if (surname == null) throw new IllegalStateException("Не введена фамилия!");
        if (address == null) throw new IllegalStateException("Не введен адрес!");

        if (age == null) {
            return new Person(name, surname, address);
        } else {
            return new Person(name, surname, age.getAsInt(), address);
        }
    }
}
