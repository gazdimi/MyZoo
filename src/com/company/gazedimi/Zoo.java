package com.company.gazedimi;

import com.company.gazedimi.UI.Menu;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        /*new Mammals(0, "tiger", 25, 15, "something in here");
        System.out.println(animals.get(0).getDescription());
        System.out.println(animals.get(0).getKind());*/
	    new Menu();
    }
}
