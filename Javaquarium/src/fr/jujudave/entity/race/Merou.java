package fr.jujudave.entity.race;

import fr.jujudave.entity.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Merou extends Fish {
    public Merou(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.CARNIVORE);
        setRace(Race.MEROU);
        setSexuality(Sexuality.AGE);
    }

    @Override
    public Living reproduce(PrintWriter writer) throws IOException {
        String newName = randomName();
        writer.write(newName + " est né(e).\n");
        return new Merou(newName, aleatoryGender(), 0);
    }
}
