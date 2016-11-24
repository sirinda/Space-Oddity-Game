
public class OxygenStorage extends Location {

	public String toString() {
		return "Oxygen Storage Room";
	}

	
	public String getControlPanelText() {
		return "WARNING: there is irreparable leakage in the oxygen storage compartment.";
	}

	public String getRoomDescription() {
		return "\n" +
				"This is the room in which the spaceship's oxygen tank is stored. To access \n"
				+ "the control panel, type \"inspect control panel\"";
	}

}
