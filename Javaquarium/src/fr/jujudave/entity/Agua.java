package fr.jujudave.entity;

import java.io.PrintWriter;

public class Agua extends Living {

    public Agua(int age, double lifePoint) {
        setAge(age);
        setEnergyValue(3);
        setLifeResistance(2);
        setLifePoint(lifePoint);
    }


    public boolean canReproduce(){
        return this.getLifePoint() > 10;
    }

    @Override
    public Living reproduce(PrintWriter writer) {
        this.setLifePoint(getLifePoint()/2);
        return new Agua(0, this.getLifePoint());
    }

}
