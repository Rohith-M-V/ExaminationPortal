package com.javatechie.keycloak.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class Employee {
    @Id
    @GeneratedValue
    @JsonProperty
    private int id;
    
    @JsonProperty
    private String username;
    
    @JsonProperty
    private String secondname;
    
    @JsonProperty
    private double salary;
    
    public Employee() {
    	
    }

    public Employee(String name, double salary, String secondname) {
        this.username = name;
        this.id = id;
        this.secondname = secondname;
        this.salary = salary;  
       
    }
}
