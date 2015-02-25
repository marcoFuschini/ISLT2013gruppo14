package it.unibo.IngSW.common;

public enum Command {
	START,STOP,DECSPEED,INCSPEED,LOWSPEED,MEDIUMSPEED,HIGHSPEED;
	
	
	public static Command StringToCommand(String s){
		
		if(START.toString().equals(s)){
			return START;
		}else if(STOP.toString().equals(s)){
			return STOP;
		}else if(DECSPEED.toString().equals(s)){
			return DECSPEED;
		}else if(INCSPEED.toString().equals(s)){
			return INCSPEED;
		}else if(LOWSPEED.toString().equals(s)){
			return LOWSPEED;
		}else if(MEDIUMSPEED.toString().equals(s)){
			return MEDIUMSPEED;
		}else if(HIGHSPEED.toString().equals(s)){
			return HIGHSPEED;
		}
		return null;
	}
}

