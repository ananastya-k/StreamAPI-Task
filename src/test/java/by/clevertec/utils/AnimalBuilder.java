package by.clevertec.utils;

import by.clevertec.model.Animal;
import lombok.Builder;

public class AnimalBuilder {
    private int id;
    private String breed;
    private int age;
    private String origin;
    private String gender;

    {
        this.id = 0;
        this.breed = "";
        this.age = 0;
        this.origin = "";
        this.gender = "";
    }

    public AnimalBuilder setBreed(String breed) {
        this.breed = breed;
        return this;
    }
    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public AnimalBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Animal build() {
        return new Animal(id, breed, age, origin, gender );
    }
}
