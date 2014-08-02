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
public class HorizontalSensor extends SquareSensor implements Sensor{

    public HorizontalSensor(Scanner scanner) {
        super(scanner);
    }
    
    @Override
    public void apply(Room room) {
        for (int i = x; i < x + size; i++) {
            room.setCell(y, i);
        }
    }
    
}
