package ru.kpfu.itis.group11501.volkov.tgbot.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String firstName;

    @Column( nullable = false)
    private String secondName;

    @Column( nullable = false)
    private String thirdName;

    private String address;

    private Integer age;

    public User(String firstName, String secondName, String thirdName, String address, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.address = address;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
