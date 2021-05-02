package com.company.gazedimi;

public class Birds extends Animal implements IAnimals{

    private Kind animal_class = Kind.Birds;

    public Birds(int code, String name, double weight, int max_age, String description){
        super.setCode(code);
        super.setName(name);
        super.setKind(animal_class);
        super.setWeight(weight);
        super.setMax_age(max_age);
        super.setDescription(description);

        Zoo.animals.add(this);
        Zoo.serialize(Zoo.animals,"res/animals.ser");
    }

    @Override
    public Birds edit() {
        //edit
        return this;
    }
}
