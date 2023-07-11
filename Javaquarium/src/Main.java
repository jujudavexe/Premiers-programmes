import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Menu menu = new Menu();

        File tourFile = new File("./Sauvegardes/tour.txt");
        File rapport = new File("./Sauvegardes/rapport.txt");
        File entity = new File("./Sauvegardes/entité.txt");


        if(!tourFile.exists()){
            tourFile.createNewFile();
            PrintWriter writer = new PrintWriter(tourFile, StandardCharsets.UTF_8);
            writer.print("========== Tour 0 ==========\n");
            writer.close();
        }

        if(!rapport.exists()) rapport.createNewFile();
        if(!entity.exists()) entity.createNewFile();


        menu.start();
    }
}

