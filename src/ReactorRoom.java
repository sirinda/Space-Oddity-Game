
public class ReactorRoom extends Location {
	
	public String getOpenPressureValvesMessage() {
		return "The pressure valve is open. The pressure appears to have stabilized.";	
	}
	
	
	public String getTurnOnReactorMessage() {
		return "The reactor is starting up.";	
	}
	public String getTurnOffReactorMessage() {
		return "The reactor is shutting down.";	
	}
	
	public String getTurnOnCoolerMessage() {
		return "The reactor will decrease temperature only if current temperature is unstable.";	
	}
	
	public String getTurnOffCoolerMessage() {
		return "The reactor will allow for temperature increase only if current temperature is unstable";	
	}
	public String getPressureMonitoringDeviceMessage() {
		return "WARNING: pressure valve malfunctioning";
	}
	public String getCoolingSystemMessage() {
		return "It appears that the temperature of the reactor is stable.";
	}
	@Override
	public String toString() {
		return "Reactor Room";
	}

	@Override
	public String getControlPanelText() {
		return "***Control Panel Options***\n" +
				"turn on cooler\n" +
				"turn off cooler \n" +
				"open pressure valves\n" +
				"turn on reactor\n" +
				"turn off reactor";
	}

	@Override
	public String getRoomDescription() {
		return "\n" +
				"This room contains the main power source for the entire spaceship. \n" +
				"Looking around the room, you notice a pressure monitoring device, \n" +
				"and a cooling system. You may need to check the status of these \n" +
				"systems for repair. To do so, type \"inspect pressure monitoring device\",\n" +
				"or \"inspect cooling system\". Type \"inspect reactor control panel\" \n" +
				"to see even more commands.";
	}

}
