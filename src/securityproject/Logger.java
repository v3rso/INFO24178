package securityproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

/**
 *
 * @author Patrick
 */

public class Logger {
    
    public static int count;
    
    //Options for simulation
    public String[] accessArray = {"Unrecognized USB device detected",
                                    "UAC settings altered",
                                    "User password altered",
                                    "Firewall settings altered",
                                    "Network security settings altered"};
    
    public String[] actionArray = {"Software installation performed",
                                    "Software uninstallation performed",
                                    "File added/removed/altered",
                                    "Software uninstallation performed",
                                    "Unknown network communication detected",
                                    "Script executed"};
    
    public String[] threatArray = {"A Trojan",
                                    "Spyware",
                                    "Adware",
                                    "A Keylogger",
                                    "A Worm",
                                    "A Rootkit",
                                    "A Virus"};
    
    public Logger(){
        
    }
    
    public void startSim(Room room){
        
        final Timer timer = new Timer();
        
        final int delayCount = (int) (Math.random() * (5) + 1);
        
        final int chosenDevice = (int) (Math.random() * (room.getSensorCount() + 10));
        final int chosenAccess = (int) (Math.random() * (5));
        final int chosenAction = (int) (Math.random() * (6));
        final int chosenThreat = (int) (Math.random() * (7));
        
        System.out.println("Simulation starting...");
        System.out.println(chosenDevice);
        
        //begin timed simulation
        timer.scheduleAtFixedRate(new TimerTask() {
            
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.print(dateFormat.format(date));
                
                if (count == delayCount + 1){

                    System.out.println(": Warning: Movement detected on sensor " + chosenDevice + " - Activating device log.");
                } else if (count == delayCount + 7){
                    System.out.println(": Warning: " + accessArray[chosenAccess] + " on computer " + chosenDevice + ".");
                } else if (count == delayCount + 14){
                    System.out.println(": Warning: " + actionArray[chosenAction] + " on computer " + chosenDevice + ".");
                } else if (count == delayCount + 18){
                    System.out.println(": Notification: No further movement detected on sensor " + chosenDevice + " - commencing Malware Scan.");
                } else if (count == delayCount + 25){
                    System.out.println(": Notification: " + threatArray[chosenThreat] + " has been detected on computer " + chosenDevice + ".");
                    cancel();
                    timer.cancel();
                } else {
                    System.out.println(": <no action detected>");
                }
                count++;                
            }
            
        }, 0, 1000);
        
    }
    
}
