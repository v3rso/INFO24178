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
public class VerticalSensor extends SquareSensor implements Sensor{

    public VerticalSensor(Scanner scanner) {
        super(scanner);
    }
    
    @Override
    public void apply(Room room) {
        for (int i = y; i < y + size; i++) {
                room.setCell(i, x);
        }
    }
    
}
