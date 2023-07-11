package fr.jujudave.entity.race;

import fr.jujudave.entity.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Sole extends Fish {
    public Sole(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.HERBIVORE);
        setRace(Race.SOLE);
        setSexuality(Sexuality.OPPORTUNISTE);
    }

    @Override
    public Living reproduce(PrintWriter writer) throws IOException {
        String newName = randomName();
        writer.write(newName +" est né(e).\n");
        return new Sole(newName, aleatoryGender(), 0);
    }
}
