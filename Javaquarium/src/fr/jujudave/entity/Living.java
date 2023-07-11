package fr.jujudave.entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public abstract class Living{
    Random random = new Random();



    private String name;

    private double lifePoint;
    private int energyValue;
    private Race race;
    private int age;

    private int lifeResistance;

    private boolean eaten = false;


    public abstract Living reproduce(PrintWriter writer) throws IOException;






    public double getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(double lifePoint) {
        this.lifePoint = lifePoint;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }


    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public int getLifeResistance() {
        return lifeResistance;
    }

    public void setLifeResistance(int lifeResistance) {
        this.lifeResistance = lifeResistance;
    }

    public String randomName() throws IOException {
        String file = Files.readString(Paths.get("name.txt"));
        String[] file2 = file.split("\r\n");
        int numberProposition = random.nextInt(file2.length);
        return file2[numberProposition];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
