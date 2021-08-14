package com.example.hrmanagment.Entities;

import javax.persistence.*;

@Entity
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer HRID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

    public Integer getHRID() {
        return HRID;
    }

    public void setHRID(Integer HRID) {
        this.HRID = HRID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public employee(Integer HRID, String firstName, String lastName, String birthDate, String phone, String email, String department) {
        this.HRID = HRID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    public employee() {
    }
}
