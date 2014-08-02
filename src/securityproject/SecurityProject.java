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
        System.out.println("Enter room size");
        int roomSize = scanner.nextInt();
        Room room = new Room(roomSize);
        loop: while(true){
            System.out.println("Enter kind of sensor (square/vertical/horizontal) or request coverage: ");
            String input = scanner.next();
            switch (input){
                case "square":
                    room.addSensor(new SquareSensor(scanner));
                    break;
                case "horizontal":
                    room.addSensor(new HorizontalSensor(scanner));
                    break;
                case "vertical":
                    room.addSensor(new VerticalSensor(scanner));
                    break;
                default:
                    System.out.printf("The coverage is %f\n", room.getCoverage()*100);
                    break loop;
            }
            room.applySensors();
            room.print();
        }
    }
}
