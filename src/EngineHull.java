
public class EngineHull extends Location{
	

	public String getFixedEngineText() {
		return "You use your spare engine parts to replace the damaged engine. The engine now appears to function normally.";
	}
	public String getInspectEngineText() {
		return "It appears that the fuel pump and other engine parts have been damaged in collision and need replacement.";
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Engine Hull";
	}

	@Override
	public String getControlPanelText() {
		// TODO Auto-generated method stub
		return "***Control Panel Options***\n" +
				"inspect engine";
	}

	@Override
	public String getRoomDescription() {
		// TODO Auto-generated method stub
		return "\n" +
				"It appears that certain parts of the engine hull need to be replaced. \n"
				+ "Type \"inspect engine\" to inspect the damage.";
	}
	

}
