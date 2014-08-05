/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securityproject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Herman
 */
public class Room {
    private ArrayList<Sensor> sensors;
    private int[][] cells;
    private int size;

    public Room(int size) {
        this.sensors = new ArrayList();
        this.size = size;
        this.cells = new int[size][size];
    }
    
    public void print(){
        String str = "";
        String bound = "+ ";
        for (int i = 0; i < size; i++) {
            bound += "- ";
            str += "| ";
            for (int j = 0; j < size; j++) {
                str += cells[i][j] == 0 ? "  " : "0 ";
            }
            str += "|\n"; 
        }
        bound += "+ \n";
        System.out.printf("%s%s%s", bound, str, bound);
    }
    
    public void setCell (int x, int y){
        cells[x][y] = 1;
    }
    
    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }
    
    public void applySensors (){
        for (Iterator<Sensor> it = sensors.iterator(); it.hasNext();) {
            Sensor sensor = it.next();
            sensor.apply(this);
        }
    }
    
    public int getSensorCount(){
        return sensors.size();
    }
    
    public double getCoverage (){
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] != 0){
                    counter++;
                }
            }
        }
        return counter/size/size;
    }
}
