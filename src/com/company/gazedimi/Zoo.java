package com.company.gazedimi;

import com.company.gazedimi.UI.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static List<Animal> animals = new ArrayList<>();

    //static initializer
    static {
        animals = deserialize("res/animals.ser");                                   //load previous data
    }

    public static void main(String[] args) {

	    new Menu();                                                                         //open main form
    }

    public static void serialize(List<Animal> animals, String filename){                    //write instances to file
        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(animals);
            o.close();                                                  //close file objs reversely from their creation
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Animal> deserialize(String filename){                                       //read instances from file
        List<Animal> animals = new ArrayList<>();
        try {
            FileInputStream f = new FileInputStream(filename);
            ObjectInputStream o = new ObjectInputStream(f);
            animals = (List<Animal>) o.readObject();
            o.close();                                                  //close file objs reversely from their creation
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animals;
    }
}
