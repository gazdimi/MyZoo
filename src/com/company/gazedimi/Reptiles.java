package com.company.gazedimi;

public class Reptiles extends Animal implements IAnimals{

    private Kind animal_class = Kind.Reptiles;

    @Override
    public Reptiles edit() {
        //edit
        return this;
    }
}
