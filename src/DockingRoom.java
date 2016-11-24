
public class DockingRoom extends Location {
	private boolean isGameCompleted;
	
	public void setGameCompleted() {
		isGameCompleted = true;
	}
	
	public String toString() {
		return "Docking Room";
	}

	
	public String getControlPanelText() {
		return "Looks like there's nothing here... Check again later?";
	}

	
	public String getRoomDescription() {
		if (isGameCompleted) {
			return "\n" +
					"To your complete surprise, it appears that a spaceship has docked! \n"
					+ "While you do not know the origins or motives of said spaceship, \n"
					+ "it seems that they are here to rescue you! \n"
					+ "CONGRATULATIONS, YOU HAVE BEEN RESCUED!! \n" 
					+ GameArt.winArt;
		}
		else {
			return "\n" + 
					"Looks like there's nothing here... Check again later?";
		}
	}

}
