/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securityproject;

import java.util.Scanner;

/**
 *
 * @author Herman
 */
public class SecurityProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the security sensor simulator.\n");
        System.out.println("Enter your desired room size: ");
        int roomSize = scanner.nextInt();
        Room room = new Room(roomSize);
        loop: while(true){
            System.out.println("Choose an action from the options below.\n\n"
                    + "1. Create square sensor.\n"
                    + "2. Create horizontal sensor.\n"
                    + "3. Create vertical sensor.\n"
                    + "4. Display current sensor map.\n"
                    + "5. Calculate sensor coverage.\n"
                    + "6. Begin sensor simulation.\n"
                    + "7. Exit.\n\n");
            String input = scanner.next();
            switch (input){
                case "1":
                    room.addSensor(new SquareSensor(scanner));
                    break;
                case "2":
                    room.addSensor(new HorizontalSensor(scanner));
                    break;
                case "3":
                    room.addSensor(new VerticalSensor(scanner));
                    break;
                case "4":
                    room.print();
                    break;
                case "5":
                    System.out.printf("The coverage is %f\n", room.getCoverage()*100);
                    break;
                case "6":
                    Logger logger = new Logger();
                    logger.startSim(room);
                    break;
                case "7":
                    System.exit(0);
                default:
                    System.out.println("That was not an acceptable input, try again.");
            }
            room.applySensors();
        }
    }
}
