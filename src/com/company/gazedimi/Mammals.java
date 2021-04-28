package com.company.gazedimi;

public class Mammals extends Animal implements IAnimals{

    private Kind animal_class = Kind.Mammals;

    public Mammals(int code, String name, float weight, int max_age, String description){
        super.setCode(code);
        super.setName(name);
        super.setKind(animal_class);
        super.setWeight(weight);
        super.setMax_age(max_age);
        super.setDescription(description);

        Zoo.animals.add(this);
        super.setAvailableCode(Zoo.animals.size());
    }

    /*public void example(){
        for (Kind k : Kind.values()){
            System.out.println(k);
        }
    }*/

    @Override
    public Mammals add() {
        //return new Mammals();
        return null;
    }
}
