package com.example.viikko12;

import java.util.Random;

public class Vampire extends Monster{
    private static final String[] names = new String[]{"Matti", "Aapo", "Eero", "Helena", "Jouko", "Nico", "Seppo", "Annikki", "Tuulikki"};
    private static final Random RANDOM = new Random();

    public Vampire() {
        this(getMonsterName(), getMax());
    }
    public Vampire(String name, int maxLife) {

        super(name, maxLife);


    }
    private static String getMonsterName() {
        int index = RANDOM.nextInt(names.length);
        return names[index];
    }
    private static int getMax() {
        return 20 + RANDOM.nextInt(20);
    }
}