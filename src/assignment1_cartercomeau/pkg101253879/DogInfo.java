/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_cartercomeau.pkg101253879;

import java.util.*;

/**
 *
 * @author Carter Comeau 
 *          Student ID: 101253879 
 *          Assignment 1 
 *          2020/10/02
 */
public class DogInfo {
//initialize variables

    private int dogId;
    private String name;
    private double age;
    private String breed;
    private char sex;
    private boolean foundHome;

//default constructor     
    public DogInfo() {
    }

    ;
//constructor for DogInfo    
    public DogInfo(int dogId, String name, double age, String breed, char sex) {
        this.dogId = dogId;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.sex = sex;
        this.foundHome = false;
    }
//if dog finds a home it sets foundHome to true

    public void dogFoundHome() {
        this.foundHome = true;
    }
//getter for dogId

    public int getDogId() {
        return this.dogId;
    }
//getter for foundHome

    public boolean returnDogStatus() {
        return this.foundHome;
    }
//getter for dogStatus, different because it takes a dog ID

    public boolean getDogStatus(int dogId) {
        return this.foundHome;
    }
//formats information for a dogInfo object

    public String displayInfo() {
        String data = "Dog ID: " + dogId + "\n";
        data += "Name: " + name + "\n";
        data += "Age: " + age + "\n";
        data += "Breed: " + breed + "\n";
        data += "Sex: " + sex + "\n";
        data += "Has home: " + foundHome + "\n";

        return data + "\n";
    }

}
