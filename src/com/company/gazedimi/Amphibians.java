package com.company.gazedimi;

public class Amphibians extends Animal implements IAnimals{
    private Kind animal_class = Kind.Amphibians;

    @Override
    public Amphibians edit() {
        //edit
        return this;
    }
}
