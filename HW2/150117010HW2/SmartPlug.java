import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable{

	private boolean status; // takes the value of true if the plug is turned on
	private Calendar programTime; // keeps the exact time of automatic activation of the smart device
	private boolean programAction; // keeps the next action of the smart device (either turn on or turn off)
	
	public SmartPlug() { // no arg constructor
		setAlias("Default");
		setMacId("Default");
	}

	public SmartPlug(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	
	public void turnOn() { // this method should check the connection of a smart plug firstly and it should turn on the plug by printing the opening time
		if (isConnectionStatus()) {
			if (status == false) {
				setStatus(true);
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
	
	public void turnOff() { // method should check the connection of a smart plug firstly and it should turn off the plug by printing the power-off time
		if (isConnectionStatus()) {
			if (status == true) {
				setStatus(false);
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
	
	public boolean testObject() { // this method should check the connection of a smart plug firstly and it should test the functionalities
		if (isConnectionStatus()) {
			System.out.println("Test is starting for " + this.getClass().getName());
			smartObjectToString();
			turnOn();
			turnOff();
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
			if (status == true) {
				turnOff();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setTimer(int seconds) { // this method should set the timer of a smart plug with the given amount of seconds
		if (isConnectionStatus()) {
			setProgramTime(Calendar.getInstance());
			programTime.add(Calendar.SECOND, seconds);
			
			if (status == true) {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " will be turned off " + seconds + " later! (Current Time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
			}
			else {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " will be turned on " + seconds + " later! (Current Time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
			}
		}
	}
	
	public void cancelTimer() { // method should check the connection of a smart plug, and then it should cancel the timer of a smart plug by assigning the value of null to the programTime property.
		if (isConnectionStatus()) {
			setProgramTime(null);	
		}
	}
	
	public void runProgram() { // method should check the connection of a smart plug firstly. Then, it should either turn on or turn off the light by checking the programAction property of the smart plug if the programTime value equals to the current time
		if (isConnectionStatus()) {
			Calendar currentTime = Calendar.getInstance();
			
				if (programTime != null && programAction == true && programTime.get(Calendar.HOUR) == currentTime.get(Calendar.HOUR) && programTime.get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE) && programTime.get(Calendar.SECOND) == currentTime.get(Calendar.SECOND)) {
					turnOn();
					programTime = null;
					
				}
				else if (programTime != null && programAction == false && programTime.get(Calendar.HOUR) == currentTime.get(Calendar.HOUR) && programTime.get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE) && programTime.get(Calendar.SECOND) == currentTime.get(Calendar.SECOND)) {
					turnOff();
					programTime = null;
					
				}
			
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
