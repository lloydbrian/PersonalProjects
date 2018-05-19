/**
 * @author lloyd.brian.v.dagoc
 *
 */

package com.lloyd.utilities;

import java.awt.Robot;
import java.util.Random;

import com.lloyd.common.DateFormatter;
import com.lloyd.common.HackTimer;

import java.util.Calendar;
import java.sql.Timestamp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;

public class ScreenSaverHack {

    //private static boolean ScreenSaverStop = true;
    private static final int FIVE_SECONDS = 5000;
    private static final int MAX_Y = 400;
    private static final int MAX_X = 400;
    
    private Timestamp tStamp = null;
    
    private long endTime = 0;
    private HackTimer hTimer = null;
    
    public void init() {
       // no init items required
    }
    
    public ScreenSaverHack () {
    	// default constructor
    }

    public ScreenSaverHack (String dOption) {
    	// "yyyy-MM-dd h:mm a"
    	int yearToday = Calendar.getInstance().get(Calendar.YEAR);
    	
    	System.out.println("You chose to end this screensaver hack on " + yearToday + "-" + dOption);
    	
    	try {
        	DateFormatter df = new DateFormatter (new String (yearToday+"-"+dOption));
        	endTime = df.longDateValue();
    	} catch (ParseException e) {
    		endTime = 0;    		
    	} 
    }
    	
    public void startScreenSaverHack() throws Exception {
        
    	System.out.println("Starting the ScreenSaver Hack...");     
        System.out.println("Configured for intervals of... 5 seconds");
        System.out.println("Watch your mouse pointer ");
        
        hTimer = new HackTimer(endTime);
        
        while (hTimer.returnToggle()) {
        	Random random = new Random();
        	Robot robot = new Robot();
        	
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
        	tStamp = new Timestamp (System.currentTimeMillis());

            System.out.println(tStamp);
            Thread.sleep(FIVE_SECONDS);
            
            robot = null;
            random = null;
        }
    	
    }   
    
    public static void main(String[] args) throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Choose end Month in 'mm' format: ");
    	String mString = reader.readLine();

    	System.out.println("Choose end Day in 'dd' format: ");
    	String dString = reader.readLine();
    	
    	System.out.println("Choose end time in 'h:mm am/pm' format: ");
    	String time = reader.readLine();
    	
    	ScreenSaverHack stopScreenSaver = new ScreenSaverHack(new String(mString+"-"+dString+" "+time));
    	stopScreenSaver.startScreenSaverHack();
        System.out.println("ScreenSaver Hack has been stopped.");     
    }

}
