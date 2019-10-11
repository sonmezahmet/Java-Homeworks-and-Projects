
public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera>{

	private boolean status; // takes the value of true if the camera is recording
	private int batteryLife; // represents the battery life of the camera
	private boolean nightVision; // represents the night vision feature of the camera
	
	public SmartCamera() { // no arg constructor
		setAlias("Default");
		setMacId("Default");
		setNightVision(false);
		setBatteryLife(0);
	}
	
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		setAlias(alias);
		setMacId(macId);
		setNightVision(nightVision);
		setBatteryLife(batteryLife);
	}
	
	public void recordOn(boolean isDay) { // this method should check the followings firstly: the connection of a smart camera, the isDay value and the nightVision feature of the smart camera
		if (isConnectionStatus()) {
			if (isDay) {
				if (status == false) {
					setStatus(true);
					System.out.println(this.getClass().getName() + " - " + getAlias() + " is turned on now");
				}
				else {
					System.out.println(this.getClass().getName() + " - " + getAlias() + " has been already turned on");
				}
			}
			else {
				if (nightVision) {
					if (status == false) {
						setStatus(true);
						System.out.println(this.getClass().getName() + " - " + getAlias() + " is turned on now");
					}
					else {
						System.out.println(this.getClass().getName() + " - " + getAlias() + " does not have night vision feature");
					}
				}
			}
		}
	}
	
	public void recordOff() { // this method should check the connection of a smart camera firstly and it should stop recording. In this method, you should update the status property appropriately
		if (isConnectionStatus()) {
			if (status == true) {
				setStatus(false);
			}
			else {
				System.out.println(this.getClass().getName() + " - " + getAlias() + " has been already turned off");
			}
		}
	}
	
	public boolean testObject() { // method should check the connection of a smart camera firstly and it should test the functionalities
		if (isConnectionStatus()) {
			System.out.println("Test is starting for " + this.getClass().getName());
			smartObjectToString();
			recordOn(true);
			recordOff();
			recordOn(false);
			recordOff();
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
				recordOff();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean controlMotion(boolean hasMotion, boolean isDay) { // check motion and night vision sensor
		if (isConnectionStatus()) {
			if (hasMotion) {
				System.out.println("Motion detected");
			}
			else {
				System.out.println("Motion not detected");
			}
			recordOn(isDay);
			return true;
		}
		else {
			return false;
		}
	}
		
	public int compareTo(SmartCamera smartCamera) {
		if (this.batteryLife > smartCamera.batteryLife) {
			return 1;
		}
		else if (this.batteryLife == smartCamera.batteryLife) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		String statusString;
		if (status == true) {
			statusString = "recording";
		}
		else {
			statusString = "not recording";
		}
		return this.getClass().getName() + " -> " + getAlias() + "'s battery life is " + getBatteryLife() + " status is " + statusString;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getBatteryLife() {
		return batteryLife;
	}
	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}
	public boolean isNightVision() {
		return nightVision;
	}
	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
	
	
}
