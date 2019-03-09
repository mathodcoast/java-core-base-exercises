package com.mathodcoast.model;

import lombok.*;


@Getter @Setter
@ToString
@EqualsAndHashCode(exclude = "id")
public class CrewMember {

    public CrewMember(String firstName,String secondName,String email,double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.salary = salary;
    }

    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private double salary;
}