package com.company.gazedimi;

public class Fish extends Animal{
    private Kind animal_class = Kind.Fish;

    public Fish(int code, String name, double weight, int max_age, String description){
        super.setCode(code);
        super.setName(name);
        super.setKind(animal_class);
        super.setWeight(weight);
        super.setMax_age(max_age);
        super.setDescription(description);

        Zoo.animals.add(this);
        Zoo.serialize(Zoo.animals,"res/animals.ser");
    }
}
