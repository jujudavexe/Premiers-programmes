import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Combien avez vous d'argent?");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();


        List<Computer> computers = new ArrayList<>();

        computers.add(new HP("Spectre", 230));
        computers.add(new HP("Pavilion", 700));
        computers.add(new HP("15s", 630));
        computers.add(new MSI("GS76", 250));
        computers.add(new MSI("GT66", 1780));
        computers.add(new MSI("GP76", 350));



        for (Computer computer : computers){
            if(computer.getPrice() < money){
                System.out.println(computer.getClass().getName() +" "+ computer.getModel() +" "+ computer.getPrice()+" euros.");
            }
        }



    }
}
