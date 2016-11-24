
public class ControlRoom extends Location{
	SpaceshipGame game;

	public String toString() {
		return "Control Room";
	}

	
	public String getControlPanelText() {
		return "Reactor Room - WARNING. \n" +
				"Oxygen Room - WARNING. \n" +
				"Engine Hull-  WARNING." ;
	}

	
	public String getRoomDescription() {
		return  "\n" +
				"Here you can keep track of all of the spaceship's vital processes.\n" +
				"Type \"inspect control panel\" to see the status of your spaceship. \n" +
				"Pick up a map by typing \"pick up map\", then type \"map\" at any time to inspect the map. \n"+
				"You can type \"inventory\" at any time to view your belongings. \n"
				+"You can check your oxygen level at any time by typing \"oxygen\".";
	}
}
