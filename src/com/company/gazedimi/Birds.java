package com.company.gazedimi;

public class Birds extends Animal implements IAnimals{

    private Kind animal_class = Kind.Birds;

    @Override
    public Birds add() {
        return new Birds();
    }
}
