/**
 * @author lloyd.brian.v.dagoc
 *
 */

package com.lloyd.common;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class HackTimer {

	private static final int DEFAULT_TEN_SECONDS = 10000;
	private boolean inToggle = true;

	
	Timer timer = null;
	RemindTask rTask = null;
	Date dateParam =null;
	
	public HackTimer () {
		this(DEFAULT_TEN_SECONDS);
	}
	
	public HackTimer (long dayTime) {
		timer = new Timer();
		rTask = new RemindTask();
		dateParam = new Date (dayTime);
		
		if(dayTime <= 0) {
			timer.schedule(rTask, DEFAULT_TEN_SECONDS);
		} else {
			//System.out.println(dayTime);
			timer.schedule(rTask, dateParam);
			
		}
		
	}

	public boolean returnToggle () {
		return inToggle;
	}
	
	class RemindTask extends TimerTask {
		
		public void run () {
			System.out.println("Terminating task!");
			inToggle = false;
            timer.cancel(); //Terminate the timer thread
		}
		
	}

}
