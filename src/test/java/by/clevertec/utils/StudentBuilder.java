package by.clevertec.utils;

import by.clevertec.model.Student;

public class StudentBuilder {

    private int id;
    private String surname;
    private int age;
    private String faculty;
    private String group;


    {
        this.id = 0;
        this.surname = "";
        this.age = 0;
        this.faculty = "";
        this.group = "";
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public StudentBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public Student build() {
        return new Student(id, surname, age, faculty, group);
    }
}

