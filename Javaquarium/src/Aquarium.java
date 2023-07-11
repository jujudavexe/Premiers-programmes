import fr.jujudave.entity.*;
import fr.jujudave.entity.race.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium {

    Random random = new Random();
    List<Fish> fishList = new ArrayList<>();
    List<Agua> aguaList = new ArrayList<>();

    File rapport = new File("./Sauvegardes/rapport.txt");

    PrintWriter writer;

    public Aquarium() throws FileNotFoundException {
        this.writer = new PrintWriter(rapport);
    }


    public void Turn() throws InterruptedException, IOException {


        writer.println("Rapport :\n");
        oldingPhase();
        recycleEntities(writer);
        writer.println();
        eatingPhase(writer);
        writer.println();
        recycleEntities(writer);
        writer.println();
        reproducingPhase(writer);
        writer.println();
        resetStatue();
        showEntities();
        writer.flush();

        Thread.sleep(1000);

    }

    public void showEntities() {
        for (Fish fish : fishList)
            System.out.println(fish.getName() + " " + fish.getGender() + " " + fish.getRace() + " age: " + fish.getAge() + " PV: " + fish.getLifePoint());

        if (aguaList.size() > 0)
            System.out.println("\nIl y a " + aguaList.size() + " algues dans l'aquarium");
        else
            System.out.println("\nIl n'y a plus d'algue dans l'aquarium.");

        if (fishList.size() > 0)
            System.out.println("Il y a " + fishList.size() + " poissons dans l'aquarium\n");
        else
            System.out.println("Il n'y a plus de poisson dans l'aquarium.\n");
    }

    public void firstEntity() {
        addFish(new Sole("Martin", Gender.MALE, random.nextInt(20)));
        addFish(new Sole("Noemie", Gender.FEMALE, random.nextInt(20)));
        addFish(new Thon("Luc", Gender.MALE, random.nextInt(20)));
        addFish(new Thon("Lou", Gender.FEMALE, random.nextInt(20)));
        addFish(new PoissonClown("Eden", Gender.FEMALE, random.nextInt(20)));
        addFish(new PoissonClown("Nemo", Gender.MALE, random.nextInt(20)));
        addFish(new Merou("Virginie", Gender.FEMALE, random.nextInt(20)));
        addFish(new Merou("Esteban", Gender.MALE, random.nextInt(20)));
        addFish(new Carpe("Lucas", Gender.MALE, random.nextInt(20)));
        addFish(new Carpe("Niouma", Gender.FEMALE, random.nextInt(20)));
        addFish(new Bar("Mathieu", Gender.MALE, random.nextInt(20)));
        addFish(new Bar("Charlotte", Gender.FEMALE, random.nextInt(20)));

        for (int i = 0; i < 5; i++)
            addAgua(new Agua(random.nextInt(20), 10));
    }

    public void addAgua(Agua agua) {
        aguaList.add(agua);
    }

    public void addFish(Fish fish) {
        fishList.add(fish);
    }

    public Fish aleatoryFish() {
        //System.out.println("poissonnnnnnnn");
        return fishList.get(random.nextInt(fishList.size()));

    }

    public Living aleatoryLiving() {
        int randomNumber = random.nextInt(2);

        Living randomLivingEntity = null;
        if (randomNumber == 0 && !aguaList.isEmpty()) {
            randomLivingEntity = aleatoryAgua();
        } else if (!fishList.isEmpty()) {
            randomLivingEntity = aleatoryFish();
        }
        return randomLivingEntity;
    }

    public Agua aleatoryAgua() {
        return aguaList.get(random.nextInt(aguaList.size()));

    }

    public void eatingPhase(PrintWriter writer) {
        Living eaten;
        boolean b;
        if (fishList.size() > 0) {
            for (int i = fishList.size() - 1; i >= 0; i--) {
                Fish eater = fishList.get(i);
                if (eater.getLifePoint() > 0 && eater.getLifePoint() <= 5 && !eater.isEaten() && !foodNotAvailable(eater)) {
                    do {
                        eaten = aleatoryLiving();
                        b = eater.canEat(eaten);
                    } while (!b);

                    eater.eat(eaten, writer);
                }


            }
        }
    }

    public boolean foodNotAvailable(Fish f) {
        return f.getRegime().equals(Regime.HERBIVORE) && aguaList.isEmpty();
    }

    public void oldingPhase() {
        for (Fish fish : fishList) {
            fish.setAge(fish.getAge() + 1);
            fish.setLifePoint(fish.getLifePoint() - 1);
        }
        for (Agua agua : aguaList) {
            agua.setAge(agua.getAge() + 1);
            agua.setLifePoint(agua.getLifePoint() + 1);
        }
    }

    public void recycleEntities(PrintWriter writer) {
        int numberAguaDie = 0;
        if (!fishList.isEmpty()) {
            for (int i = fishList.size() - 1; i >= 0; i--) {
                if (fishList.get(i).getLifePoint() <= 0 || fishList.get(i).getAge() > 20){
                    writer.println(fishList.get(i).getName()+" est mort(e).");
                    fishList.remove(fishList.get(i));
                }
            }
        }

        if (!aguaList.isEmpty()){
            for (int i = aguaList.size() - 1; i >= 0; i--) {
                if (aguaList.get(i).getLifePoint() <= 0 || aguaList.get(i).getAge() > 20){
                    aguaList.remove(aguaList.get(i));
                    numberAguaDie++;
                }
            }
        }

        if(numberAguaDie == 1){
            writer.println(numberAguaDie + " algue est morte.");

        } else if (numberAguaDie > 1) {
            writer.println(numberAguaDie + " algues sont mortes.");

        }

    }

    public void reproducingPhase(PrintWriter writer) throws IOException {

        for (int i = aguaList.size() - 1; i >= 0; i--) {
            Agua agua = aguaList.get(i);
            if (agua.canReproduce()) {
                aguaList.add((Agua) agua.reproduce(writer));
            }
        }
        for (int i = fishList.size() - 1; i >= 0; i--) {
            Fish fish = fishList.get(i);
            Fish f = aleatoryFish();
            fish.genderChangement(f);
            if (fish.canReproduceWith(f) && !fish.isEaten()) {
                fishList.add((Fish) fish.reproduce(writer));

            }
        }
    }

    public void resetStatue() {
        for (int i = fishList.size() - 1; i >= 0; i--) {
            Fish fish = fishList.get(i);
            fish.setEaten(false);
        }
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public List<Agua> getAguaList() {
        return aguaList;
    }
}

