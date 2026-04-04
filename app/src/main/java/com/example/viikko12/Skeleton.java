package com.example.viikko12;

import java.util.Random;

public class Skeleton extends Monster{
    private static final String[] names = new String[]{"Matti", "Aapo", "Eero", "Helena", "Jouko", "Nico", "Seppo", "Annikki", "Tuulikki"};
    private static final Random RANDOM = new Random();

    public Skeleton() {
        this(getMonsterName(), getMax());
    }
    public Skeleton(String name, int maxLife) {

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