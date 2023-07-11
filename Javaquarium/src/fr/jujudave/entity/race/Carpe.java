package fr.jujudave.entity.race;

import fr.jujudave.entity.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Carpe extends Fish {
    public Carpe(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.HERBIVORE);
        setRace(Race.CARPE);
        setSexuality(Sexuality.MONO);
    }

    @Override
    public Living reproduce(PrintWriter writer) throws IOException {
        String newName = randomName();
        writer.write(newName + " est né(e).\n");
        return new Carpe(newName, aleatoryGender(), 0);
    }
}
