package com.shreyas.javacrud.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="user_entity", uniqueConstraints = {
        @UniqueConstraint(name="user_email_unique", columnNames = "email")
})
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name="email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name="phone_number", nullable = false, columnDefinition = "TEXT")
    private String phoneNumber;

    @Column(name="date_of_birth", nullable = false)
    private LocalDate dob;

    @Transient
    private Integer age;

    @Column(name="city", nullable = false, columnDefinition = "TEXT")
    private String city;

    @Column(name="state", nullable = false, columnDefinition = "TEXT")
    private String state;

    @Column(name="country", nullable = false, columnDefinition = "TEXT")
    private String country;

    public User() {

    }

    public User(String name, String email, String phoneNumber, LocalDate dob, String city, String state, String country) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public User(Long id, String name, String email, String phoneNumber, LocalDate dob, String city, String state, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return Period.between(getDob(), LocalDate.now()).getYears();
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
