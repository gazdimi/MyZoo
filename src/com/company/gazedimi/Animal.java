package com.company.gazedimi;

import java.io.*;

public class Animal implements Serializable {
    private int code;
    private String name;
    private Kind kind;
    private double weight;
    private int max_age;
    private String description;

    //instanceof & return new Mammal() or new Fish() etc.
    public Animal(){ }

    //------------------getters & setters for editing and displaying attributes---------------
    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Kind getKind() { return kind; }

    public void setKind(Kind kind) { this.kind = kind; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public int getMax_age() { return max_age; }

    public void setMax_age(int max_age) { this.max_age = max_age; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    //check for existing animal
    public static final boolean checkExistence(String code, String name, String kind, double weight, int max_age, String description){
        for(Animal a : Zoo.animals){
            if(a.getName().equals(name))
                return true;
        }
        addAnimal(code, name, kind, weight, max_age, description);
        return false;
    }

    private static void addAnimal(String code, String name, String kind, double weight, int max_age, String description){
            switch (Kind.valueOf(kind)){
                case Mammals:
                    new Mammals(Integer.valueOf(code), name, weight, max_age, description);
                    break;
                case Amphibians:
                    new Amphibians(Integer.valueOf(code), name, weight, max_age, description);
                    break;
                case Birds:
                    new Birds(Integer.valueOf(code), name, weight, max_age, description);
                    break;
                case Fish:
                    new Fish(Integer.valueOf(code), name, weight, max_age, description);
                    break;
                case Reptiles:
                    new Reptiles(Integer.valueOf(code), name, weight, max_age, description);
                    break;
            }
    }

    /*public static void addAnimal(Animal animal){          //will be removed from here
        if(animal instanceof Mammals){
            ((Mammals) animal).add();
        }else if(animal instanceof Amphibians){
            ((Amphibians) animal).add();
        }else if(animal instanceof Birds){
            ((Birds) animal).add();
        }else if(animal instanceof Fish){
            ((Fish) animal).add();
        }else if(animal instanceof Reptiles){
            ((Reptiles) animal).add();
        }
    }*/
}
