package com.example.viikko12;

public class Skeleton extends Monster{
    private String[] names;
    public Skeleton(String name, int maxLife) {
        super(name, maxLife);
        names = new String[]{"Matti", "Aapo", "Eero", "Helena", "Jouko", "Nico", "Seppo", "Annikki", "Tuulikki"};
    }
}
