import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable{

	private boolean hasLightTurned; // takes the value of true if the light is turned on
	private Calendar programTime; // keeps the exact time of automatic activation of the smart device
	private boolean programAction; // keeps the next action of the smart device (either turn on or turn off)
	
	public SmartLight() { // no arg constructor
		setAlias("Default");
		setMacId("Default");
	}

	public SmartLight(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	
	public void turnOnLight() { // this method should check the connection of a smart light firstly and it should turn on the light by printing the opening time
		if (isConnectionStatus()) {
			if (isHasLightTurned() == false) {
				setHasLightTurned(true);
				setProgramAction(false);
				Calendar currentTime = Calendar.getInstance();
				String currentTimeString = currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND);
				System.out.println(this.getClass().getName() + " - " + getAlias() + " is turned on now (Current time: " + currentTimeString + ")");
			}
			else {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " has been already turned on");
			}
		}
	}
	
	public void turnOffLight() { // method should check the connection of a smart light firstly and it should turn off the light by printing the power-off time
		if (isConnectionStatus()) {
			if (isHasLightTurned() == true) {
				setHasLightTurned(false);
				setProgramAction(true);
				Calendar currentTime = Calendar.getInstance();
				String currentTimeString = currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND);
				System.out.println(this.getClass().getName() + " - " + getAlias() + " is turned off now (Current time: " + currentTimeString + ")");
			}
			else {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " has been already turned off");
			}
		}
	}
	
	public boolean testObject() { // this method should check the connection of a smart light firstly and it should test the functionalities
		if (isConnectionStatus()) {
			System.out.println("Test is starting for " + this.getClass().getName());
			smartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for " + this.getClass().getName());
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean shutDownObject() {
		smartObjectToString();
		if (isConnectionStatus()) {
			if (isHasLightTurned() == true) {
				turnOffLight();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void onLeave() {
		if (isConnectionStatus()) {
			turnOffLight();
		}
	}
	
	public void onCome() {
		if (isConnectionStatus()) {
			turnOffLight();
		}
	}
	
	public void setTimer(int seconds) { // this method should set the timer of a smart light with the given amount of seconds
		if (isConnectionStatus()) {
			setProgramTime(Calendar.getInstance());
			programTime.add(Calendar.SECOND, seconds);
			
			if (isHasLightTurned() == true) {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " will be turned off " + seconds + " later! (Current Time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
			}
			else {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " will be turned on " + seconds + " later! (Current Time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
			}
		}
	}
	
	public void cancelTimer() { // method should check the connection of a smart light, and then it should cancel the timer of a smart light by assigning the value of null to the programTime property.
		if (isConnectionStatus()) {
			setProgramTime(null);	
		}
	}
	
	public void runProgram() { // method should check the connection of a smart light firstly. Then, it should either turn on or turn off the light by checking the programAction property of the smart light if the programTime value equals to the current time
		if (isConnectionStatus()) {
			
				Calendar currentTime = Calendar.getInstance();
				
				if (programTime != null && programAction == true && programTime.get(Calendar.HOUR) == currentTime.get(Calendar.HOUR) && programTime.get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE) && programTime.get(Calendar.SECOND) == currentTime.get(Calendar.SECOND)) {
					turnOnLight();
					programTime = null;
					
				}
				else if (programTime != null && programAction == false && programTime.get(Calendar.HOUR) == currentTime.get(Calendar.HOUR) && programTime.get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE) && programTime.get(Calendar.SECOND) == currentTime.get(Calendar.SECOND)) {
					turnOffLight();
					programTime = null;
					
				}
			
		}
	}
	
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
}
