package it.unibo.IngSW.common;

/**
 * @author Fabio
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public enum FanSpeed {
	ZEROSPEED(0),
	LOWSPEED(30),
	MEDIUMSPEED(60),
	HIGHSPEED(90);
	
	public static int MAXREVOLSPEED=100;
	
	private int perc;
	
	private FanSpeed(int perc){
		this.perc=perc;
	}
	
/*	public int getPerc(){
		return perc;
	}
*/	
	public int getRevolMid(){
		return Math.round((MAXREVOLSPEED/100)*perc);
	}
	
	public int getRevolMin(){
		return getRevolMid()-Math.round((MAXREVOLSPEED/100)*10);
	}
	public int getRevolMax(){
		return getRevolMid()+Math.round((MAXREVOLSPEED/100)*10);
	}
}