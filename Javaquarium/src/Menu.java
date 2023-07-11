import fr.jujudave.entity.Agua;
import fr.jujudave.entity.Fish;
import fr.jujudave.entity.Gender;
import fr.jujudave.entity.Living;
import fr.jujudave.entity.race.*;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    int numberOfTurn;

    Aquarium aquarium = new Aquarium();

    File tourFile = new File("./Sauvegardes/tour.txt");
    File entity = new File("./Sauvegardes/entité.txt");

    public Menu() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tourString = Files.readString(Paths.get("./Sauvegardes/tour.txt"));
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(tourString);
        if (matcher.find()) {
            numberOfTurn = Integer.parseInt(matcher.group());
        }

        loadEntity();

    }

   public void loadEntity() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new FileReader(entity));
        String line;
        if(entity.length() <= 0){
            aquarium.firstEntity();
        } else {
            while ((line = reader.readLine()) != null){
                if (line.trim().isEmpty()) {
                    continue;
                }
                line = line.replaceAll(",", "");
                String[] word = line.split(" ");

                if (word[1].equals("algues")){
                    for(int i = 0; i < Integer.parseInt(word[0]); i++)
                        aquarium.getAguaList().add(new Agua(Integer.parseInt(word[2]), 10));
                } else {
                    Gender gender;
                    if (word[2].equalsIgnoreCase("FEMALE")) {
                        gender = Gender.FEMALE;

                    } else {
                        gender = Gender.MALE;
                    }
                    String classeName = "fr.jujudave.entity.race." + word[1].replace("-", "");
                    Class<?> classe = Class.forName(classeName);
                    Constructor<?> constructor = classe.getConstructor(String.class, Gender.class, int.class);
                    Object instance = constructor.newInstance(word[0], gender, Integer.parseInt(word[3]));
                    aquarium.getFishList().add((Fish) instance);
                }
            }

        }
    }

    public void saveEntity() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(entity);

        if (!aquarium.aguaList.isEmpty()) {
            Agua previousAgua = aquarium.aguaList.get(0);
            int numberOfSimilarAgua = 0;
            aquarium.getAguaList().sort(Comparator.comparingInt(Living::getAge));
            for(Agua agua : aquarium.getAguaList()){
                if (agua.getAge() == previousAgua.getAge()){
                    numberOfSimilarAgua++;
                } else {
                    if(numberOfSimilarAgua !=0)
                        writer.println(numberOfSimilarAgua+" algues "+ agua.getAge()+" ans");
                }
                previousAgua = agua;
            }
            writer.println();
        }


        for(Fish fish : aquarium.getFishList())
            writer.println(fish.getName() + ", " + fish.getRace() + ", " + fish.getGender().toString() + ", " + fish.getAge());


        writer.close();
    }


    public void start() throws IOException, InterruptedException {

        while (aquarium.aleatoryLiving() != null) {
            numberOfTurn++;
            PrintWriter writer = new PrintWriter(tourFile, StandardCharsets.UTF_8);
            writer.print("========== Tour "+ numberOfTurn +" ==========\n");
            writer.close();
            System.out.println("========== Tour "+ numberOfTurn +" ==========\n");
            aquarium.Turn();
            saveEntity();
        }

        System.err.println("\nFIN DE LA SIMULATION\n\nRAISON : AUCUNE FORME DE VIE RESTANTE");
    }
}

