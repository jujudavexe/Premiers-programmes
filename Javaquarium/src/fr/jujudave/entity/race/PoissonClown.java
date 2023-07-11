package fr.jujudave.entity.race;

import fr.jujudave.entity.*;

import java.io.IOException;
import java.io.PrintWriter;

public class PoissonClown extends Fish {
    public PoissonClown(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.CARNIVORE);
        setRace(Race.POISSONCLOWN);
        setSexuality(Sexuality.OPPORTUNISTE);
    }

    @Override
    public Living reproduce(PrintWriter writer) throws IOException {
        String newName = randomName();
        writer.write(newName +" est né(e).\n");
        return new PoissonClown(newName, aleatoryGender(), 0);
    }

}
