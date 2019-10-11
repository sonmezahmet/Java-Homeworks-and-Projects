import java.util.ArrayList;
import java.util.Arrays;

public class SmartHome {

	private ArrayList<SmartObject> smartObjectList;
	
	public SmartHome() {
		smartObjectList = new ArrayList<SmartObject>();
	}
	
	public boolean addSmartObject(SmartObject smartObject) {
		int ipBits = 100; // starting ip bits
		
			for (int i = 0 ; i < smartObjectList.size() ; i++) { // find empty ip bits
				if (smartObjectList.get(i).getIP().equals("10.0.0." + ipBits)) {
					ipBits++;
				}
			}
		
		smartObject.connect("10.0.0." + ipBits);
		smartObjectList.add(smartObject); // add smart object to list
		
		if (smartObjectList.contains(smartObject)) {
			smartObject.testObject();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeSmartObject(SmartObject smartObject) {
		smartObjectList.remove(smartObject); // remove smart object to list
		
		if (smartObjectList.contains(smartObject)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void controlLocation(boolean onCome) {
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof LocationControl) {
				if (onCome) {
					((LocationControl)smartObjectList.get(i)).onCome();
				}
				else {
					((LocationControl)smartObjectList.get(i)).onLeave();
				}
			}
		}
	}
	
	public void controlMotion(boolean hasMotion, boolean isDay) {
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof MotionControl) {
				((MotionControl)smartObjectList.get(i)).controlMotion(hasMotion, isDay);
			}
		}
	}
	
	public void controlProgrammable() {
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof Programmable) {
				((Programmable)smartObjectList.get(i)).runProgram();
			}
		}
	}
	
	public void controlTimer(int seconds) {
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof Programmable) {
				if (seconds > 0) {
					((Programmable)smartObjectList.get(i)).setTimer(seconds);
				}
				else if (seconds == 0) {
					((Programmable)smartObjectList.get(i)).cancelTimer();
				}
			}
		}
	}
	
	public void controlTimerRandomly() {
		int[] randomSeconds = {0,5,10};
		int selectedRandomSecond;
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof Programmable) {
				selectedRandomSecond = randomSeconds[(int)(Math.random() * 3)];
				if (selectedRandomSecond == 0) {
					((Programmable)smartObjectList.get(i)).cancelTimer();
				}
				else {
					((Programmable)smartObjectList.get(i)).setTimer(selectedRandomSecond);
				}
			}
		}
	}
	
	public void sortCameras() { // sort cameras
		int numberOfSmartCameras = 0;
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof SmartCamera) {
				numberOfSmartCameras++;
			}
		}
		SmartCamera[] smartCameras = new SmartCamera[numberOfSmartCameras];
		int index = 0;
		for (int i = 0 ; i < smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof SmartCamera) {
				smartCameras[index] = ((SmartCamera)smartObjectList.get(i));
				index++;
			}
		}
		Arrays.sort(smartCameras);
		for (int i = 0 ; i < numberOfSmartCameras ; i++) {
			System.out.println(smartCameras[i].toString());
		}
	}

	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}
}
