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
public class SquareSensor implements Sensor{
    public int x;
    public int y;
    public int size;

    public SquareSensor(Scanner scanner) {
        System.out.println("Enter the X coordinate:");
        this.x = scanner.nextInt();
        System.out.println("Enter the Y coordinate:");
        this.y = scanner.nextInt();
        System.out.println("Enter the size of the sensor:");
        this.size = scanner.nextInt();
    }
    
    @Override
    public void apply(Room room) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                room.setCell(j, i);
            }
        }
    }
    
}
