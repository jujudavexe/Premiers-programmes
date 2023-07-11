package fr.jujudave.entity.race;

import fr.jujudave.entity.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Bar extends Fish {
    public Bar(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.HERBIVORE);
        setRace(Race.BAR);
        setSexuality(Sexuality.AGE);
    }

    @Override
    public Living reproduce(PrintWriter writer) throws IOException {
        String newName = randomName();
        writer.write(newName + " est né(e).\n");
        return new Bar(randomName(), aleatoryGender(), 0);
    }
}
