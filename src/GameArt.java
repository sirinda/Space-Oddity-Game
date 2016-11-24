
public class GameArt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static String getMap(Location location) {
		if (location.getClass().equals(ControlRoom.class)) {
			return controlRoom;
		}
		if (location.getClass().equals(ReactorRoom.class)) {
			return reactorRoom;
		}
		if (location.getClass().equals(EngineHull.class)) {
			return engineHull;
		}
		if (location.getClass().equals(SupplyRoom.class)) {
			return supplyRoom;
		}
		if (location.getClass().equals(OxygenStorage.class)) {
			return oxygenStorage;
		}
		if (location.getClass().equals(DockingRoom.class)) {
			return dockingRoom;
		}
		return "";
	}
	
	public static String introArt = "" +

"                           *     .--. \n" +
"                                / /  `\n" +
"               +               | |	\n" +
"                      '         \\ \\__,\n" +
"                  *          +   '--'  *\n" +
"                      +   /\\      \n" +
"         +              .'  '.   *\n" +
"                *      /======\\      +\n" +
"                      ;:.  _   ;\n" +
"                      |:. (_)  |\n" +
"                      |:.  _   |\n" +
"            +         |:. (_)  |\n" +
"                      ;:.      ;\n" +
"                    .' \\:.    / `.   \n" +
"                   / .-'':._.'`-. \n" +
"                   |/    /||\\    \\|\n" +
"                 _..--\"\"\"****\"\"\"--.._\n" +
"           _.-'``                    ``'-._\n" +
"         -'                                '-";
	
	
	public static String winArt = "" + 
"            \\  _.-'~~~~'-._   /	\n" +
"     .      .-~ \\__/  \\__/ ~-.		\n" +         
"          .-~   (oo)  (oo)    ~-.	\n" +
"         (_____//~~\\\\//~~\\\\______) \n" +
"    _.-~`                         `~-._\n" +
"   /O=O=O=O=O=O=O=O=O=O=O=O=O=O=O=O=O=O\\     *\n" +
"   \\___________________________________/\n" +
"              \\x x x x x x x/\n" +
"      .  *     \\x_x_x_x_x_x/";

	public static String engineHull = "" +
			"+--------------+--------------+-------------+\n" +
			"| Engine Hull  | Reactor Room | Control Room|\n" +
			"|              |              |             |\n" +
			"|   **YOU**    |              |             |\n" + 
			"|              |              |             |\n" +
			"+-------------------------------------------+\n" +
			"| Docking Room |Oxygen Storage| Supply Room |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"+--------------+--------------+-------------+\n";
	public static String reactorRoom = "" +
			"+--------------+--------------+-------------+\n" +
			"| Engine Hull  | Reactor Room | Control Room|\n" +
			"|              |              |             |\n" +
			"|              |   **YOU**    |             |\n" +
			"|              |              |             |\n" +
			"+-------------------------------------------+\n" +
			"| Docking Room |Oxygen Storage| Supply Room |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"+--------------+--------------+-------------+\n";
	public static String controlRoom = "" +
			"+--------------+--------------+-------------+\n" +
			"| Engine Hull  | Reactor Room | Control Room|\n" +
			"|              |              |             |\n" +
			"|              |              |   **YOU**   |\n" +
			"|              |              |             |\n" +
			"+-------------------------------------------+\n" +
			"| Docking Room |Oxygen Storage| Supply Room |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"+--------------+--------------+-------------+\n";
	public static String dockingRoom = "" +
			"+--------------+--------------+-------------+\n" +
			"| Engine Hull  | Reactor Room | Control Room|\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"+-------------------------------------------+\n" +
			"| Docking Room |Oxygen Storage| Supply Room |\n" +
			"|              |              |             |\n" +
			"|   **YOU**    |              |             |\n" + 
			"|              |              |             |\n" +
			"+--------------+--------------+-------------+\n";
	public static String oxygenStorage = "" +
			"+--------------+--------------+-------------+\n" +
			"| Engine Hull  | Reactor Room | Control Room|\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"+-------------------------------------------+\n" +
			"| Docking Room |Oxygen Storage| Supply Room |\n" +
			"|              |              |             |\n" +
			"|              |   **YOU**    |             |\n" +
			"|              |              |             |\n" +
			"+--------------+--------------+-------------+\n";
	public static String supplyRoom = "" +
			"+--------------+--------------+-------------+\n" +
			"| Engine Hull  | Reactor Room | Control Room|\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"|              |              |             |\n" +
			"+-------------------------------------------+\n" +
			"| Docking Room |Oxygen Storage| Supply Room |\n" +
			"|              |              |             |\n" +
			"|              |              |   **YOU**   |\n" +
			"|              |              |             |\n" +
			"+--------------+--------------+-------------+\n";
}
