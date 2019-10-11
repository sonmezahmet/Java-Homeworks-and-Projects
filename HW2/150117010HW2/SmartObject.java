 
public abstract class SmartObject {

	private String alias; // name of a smart device
	private String macId; // each device has a unique macID
	private String IP; // networking protocol to communicate with other devices
	private boolean connectionStatus; // smart device is connected to the internet or not
	
	
	public SmartObject() {
		setAlias("Default");
		setMacId("Default");
		setIP("Default");
		setConnectionStatus(false);
	}
	
	public boolean connect(String IP) { // this method connect which connects the smart object with the given IP value
		setIP(IP);
		if (getIP().equals(IP)) { // if ip is set it returns true and prints to screen information message
			setConnectionStatus(true);
			System.out.println(getAlias() + " connection established");
			return true;
		}
		else {
			return false;
		}
	}

	public boolean disconnect() { // this method disconnect which disconnects the smart object
		setIP("Default");
		if (getIP().equals("Default")) { // if ip is set to default value returns true
			setConnectionStatus(false);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void smartObjectToString() { // method of SmartObjectToString which prints the details about a smart object
		System.out.println("This is " + this.getClass().getName() + " device " + getAlias() + "\nMacId : " + getMacId() + "\nIP : " + getIP());
	}

	public boolean controlConnection() { // method of controlConnection which controls the connection of the smart object
		if (isConnectionStatus() == false) {
			System.out.println("This device is not connected. " + this.getClass().getName() + " -> " + getAlias());
			return false;
		}
		else {
			return true;
		}
	}
	
	// abstract methods
	public abstract boolean testObject();
	public abstract boolean shutDownObject();
	
	// getter and setters
	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getMacId() {
		return macId;
	}


	public void setMacId(String macId) {
		this.macId = macId;
	}


	public String getIP() {
		return IP;
	}


	public void setIP(String iP) {
		IP = iP;
	}


	public boolean isConnectionStatus() {
		return connectionStatus;
	}


	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
	
}
