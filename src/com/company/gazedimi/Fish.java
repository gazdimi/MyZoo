package com.company.gazedimi;

public class Fish extends Animal implements IAnimals{
    private Kind animal_class = Kind.Fish;

    @Override
    public Fish edit() {
        //edit
        return this;
    }
}
