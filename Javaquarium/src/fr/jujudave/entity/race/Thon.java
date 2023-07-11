package fr.jujudave.entity.race;

import fr.jujudave.entity.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Thon extends Fish {
    public Thon(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.CARNIVORE);
        setRace(Race.THON);
        setSexuality(Sexuality.MONO);
    }

    @Override
    public Living reproduce(PrintWriter writer) throws IOException {
        String newName = randomName();
        writer.write(newName + " est né(e).\n" );
        return new Thon(newName, aleatoryGender(), 0);
    }
}
