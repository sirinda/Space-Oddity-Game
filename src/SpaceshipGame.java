import java.util.ArrayList;

public class SpaceshipGame {
	
	//things to be fixed
	private int oxygenLevel;
	private Location currentLocation;
	private ControlRoom controlRoom;
	private ReactorRoom reactorRoom;
	private EngineHull engineHull;
	private SupplyRoom supplyRoom;
	private OxygenStorage oxygenStorage;
	private DockingRoom dockingRoom;
	private boolean isWearingSpaceSuit;
	private boolean engineFixed;
	private boolean reactorFixed;
	private boolean gameOver;
	private ArrayList<String> inventory = new ArrayList<String>();
	
	public SpaceshipGame() {
		this.oxygenLevel = 100;
		this.controlRoom = new ControlRoom();
		this.reactorRoom = new ReactorRoom();
		this.engineHull = new EngineHull();
		this.supplyRoom = new SupplyRoom();
		this.oxygenStorage = new OxygenStorage();
		this.dockingRoom = new DockingRoom();
		this.currentLocation = controlRoom;
	}
	
	public int getOxygenLevel() {
		return this.oxygenLevel;
	}

	public void printIntro() {
		System.out.println(GameArt.introArt);
		System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~* WELCOME TO SPACE ODDITY *~*~*~*~*~*~*~*~*~*~*~*~*~*");
		System.out.println(
			"On a mission to Mars, your spaceship encountered an unexpected meteor shower. \n"
			+ "While you were able to avoid fatal collision, you find that your spaceship has \n"
			+ "sustained heavy damage. Your control panel alerts you that the oxygen tank has \n"
			+ "been irreparably damaged, and you are losing oxygen rapidly.");
		System.out.println();
		System.out.println
			("To fix your spaceship and ensure survival, you must repair all damages done to \n"
			+ "your spaceship before your oxygen level runs out (and you die!)");
		System.out.println("                                ********                            ");
		System.out.println(
				"To get started, you need to know some basic commands to pilot your spaceship. \n"
				+ "\n" 
				+ "NAVIGATION: To navigate around the spaceship, you can type commands like \n"
				+ "\"go north\" to move north. Note: the spaceship consists of only six \"rooms\", \n" 
				+ "so you may not always be able to go a certain direction. Refer to the map often.\n"
				+ "\n" 
				+ "LOCATION: To keep track of your current location, you can type \"map\" for \n"
				+ "a visual, and \"location\" to get a description of your current location. \n"
				+ "\n" 
				+ "OXYGEN: It is important to keep track of your oxygen level, which decreases \n"
				+ "5% with each move you make (exceptions: looking at map, adding inventory, \n"
				+ "and checking oxygen level). To see your oxygen level, type \"oxygen\". \n"
				+ "\n" 
				+ "ADDITIONAL COMMANDS: These can be found in rooms that contain control panels \n"
				+ "or in the room descriptions themselves. Certain rooms, commands, and inventory \n"
				+ "items may serve no purpose at all in your mission to repair your spaceship, so \n"
				+ "act wisely to avoid running out of oxygen."
				+ "\n");
		System.out.println("                                  GOOD LUCK!");


	}
	
	private void printLocation() {
		System.out.println("You are currently at the " + this.currentLocation + ".");
	}
	private void printOxygenLevel() {
		System.out.println("Your oxygen level is currently at " + this.oxygenLevel + "%.");
	}
	private void printInventory() {
		if (inventory.size() == 0) {
			System.out.println("You don't have any items in your inventory yet.");
			return;
		}
		System.out.println("These are the items in your inventory:");
		for (String item: inventory) {
			System.out.println(item);
		}
	}
	private void printMap() {
		System.out.println(GameArt.getMap(currentLocation));
	}
	
	private void printControlPanel(Location location) {
		System.out.println(location.getControlPanelText());
	}
	private void printRoomDescription(Location location) {
		System.out.println(location.getRoomDescription());
	}
	
	private void addToInventory(String item) {
		System.out.println("You have added " + item + " to your inventory.");
		inventory.add(item);
		printInventory();
	}
	private void invalidMove() {
		System.out.println("You can't go that way.");
	}
	private void invalidCommand() {
		System.out.println("Sorry, that's an invalid command. Try typing something else.");
	}
	
	private void reduceOxygen() {
		this.oxygenLevel -= 5;
		printOxygenLevel();
	}
	
	private void moveLocation(String direction) {
		if (direction.equals("north")) { 
			if (this.currentLocation.equals(controlRoom) || this.currentLocation.equals(reactorRoom)
					||this.currentLocation.equals(engineHull)) {
				invalidMove();
				return;
			}
			else if (this.currentLocation.equals(dockingRoom)) {
				if (!isWearingSpaceSuit) {
					System.out.println("You need to be wearing a space suit to go north. (The engine hull is in outer space.)");
					return;
				}
				else {
					this.currentLocation = engineHull;
				}
			}
			else if (this.currentLocation.equals(oxygenStorage)) {
				this.currentLocation = reactorRoom;
			}
			else if (this.currentLocation.equals(supplyRoom)) {
				this.currentLocation = controlRoom;
			}
			printLocation();
			printRoomDescription(currentLocation);
			reduceOxygen();
		}
		else if (direction.equals("south")) {
			if (this.currentLocation.equals(dockingRoom) || this.currentLocation.equals(oxygenStorage) 
					|| this.currentLocation.equals(supplyRoom)) {
				invalidMove();
				return;
			}
			else if (this.currentLocation.equals(controlRoom)) {
				this.currentLocation = supplyRoom;
			}
			else if (this.currentLocation.equals(reactorRoom)) {
				this.currentLocation = oxygenStorage;
			}
			else if (this.currentLocation.equals(engineHull)) {
				this.currentLocation = dockingRoom;
				if (engineFixed && reactorFixed) {
					dockingRoom.setGameCompleted();
					gameOver = true;
				}
			}
			printLocation();
			printRoomDescription(currentLocation);
			reduceOxygen();

		}
		else if (direction.equals("east")) {
			if (this.currentLocation.equals(controlRoom) || this.currentLocation.equals(supplyRoom)) {
				invalidMove();
				return;
			}
			else if (this.currentLocation.equals(reactorRoom)) {
				this.currentLocation = controlRoom;
			}
			else if (this.currentLocation.equals(oxygenStorage)) {
				this.currentLocation = supplyRoom;
			}
			else if (this.currentLocation.equals(engineHull)) {
				this.currentLocation = reactorRoom;
			}
			else if (this.currentLocation.equals(dockingRoom)) {
				this.currentLocation = oxygenStorage;
			}
			printLocation();
			printRoomDescription(currentLocation);
			reduceOxygen();

		}
		else if (direction.equals("west")) {
			if (this.currentLocation.equals(dockingRoom) || this.currentLocation.equals(engineHull)) {
				invalidMove();
				return;
			}
			else if (this.currentLocation.equals(controlRoom)) {
				this.currentLocation = reactorRoom;
			}
			else if (this.currentLocation.equals(supplyRoom)) {
				this.currentLocation = oxygenStorage;
			}
			else if (this.currentLocation.equals(reactorRoom)) {
				if (!isWearingSpaceSuit) {
					System.out.println("You need to be wearing a space suit to go west.(The engine hull is in outer space.)");
					return;
				}
				else {
					this.currentLocation = engineHull;
				}
			}
			else if (this.currentLocation.equals(oxygenStorage)) {
				this.currentLocation = dockingRoom;
				if (engineFixed && reactorFixed) {
					dockingRoom.setGameCompleted();
					gameOver = true;
				}
			}
			printLocation();
			printRoomDescription(currentLocation);
			reduceOxygen();
		}
		else {
			invalidMove();
		}
	}
	
	public void completeControlRoomAction(String command) {
		if (command.equals("map")) {
			printMap();
			return;
		}
		else if (command.equals("take map") || command.equals("get map") || command.equals("pick up map")) { 
			addToInventory("map");
		}
		else if (command.equals("inspect control panel")) {
			printControlPanel(currentLocation);
			return;
		}
		else {
			invalidCommand();
		}
	}
	
	public void completeReactorRoomAction(String command){
		if (command.equals("inspect reactor control panel")) {
			printControlPanel(reactorRoom);
			reduceOxygen();
			return;
		}
		else if (command.equals("inspect pressure monitoring device")) {
			System.out.println(reactorRoom.getPressureMonitoringDeviceMessage());
			reduceOxygen();
		}
		else if (command.equals("inspect cooling system")) {
			System.out.println(reactorRoom.getCoolingSystemMessage());
			reduceOxygen();
		}
		else if (command.equals("open pressure valves")) {
			System.out.println(reactorRoom.getOpenPressureValvesMessage());
			reduceOxygen();
			reactorFixed = true;
		}
		else if (command.equals("turn on cooler")) { // used to say heater
			System.out.println(reactorRoom.getTurnOnCoolerMessage());
			reduceOxygen();
		}
		else if (command.equals("turn off cooler")) { // used to say heater
			System.out.println(reactorRoom.getTurnOffCoolerMessage());
			reduceOxygen();
		}
		else if (command.equals("turn on reactor")) {
			System.out.println(reactorRoom.getTurnOnReactorMessage());
			reduceOxygen();
		}
		else if (command.equals("turn off reactor")) {
			System.out.println(reactorRoom.getTurnOffReactorMessage());
			reduceOxygen();
		}
		else {
			invalidCommand();
		}
	}
	
	public void completeEngineHullAction(String command){
		if (command.equals("inspect engine")) {
			System.out.println(engineHull.getInspectEngineText());
			reduceOxygen();
		}
		else if (command.equals("use engine parts")) {
			if (!inventory.contains("engine parts")) {
				System.out.println("You don't have any engine parts!");
				return;
			}
			inventory.remove("engine parts");
			engineFixed = true;
			System.out.println(engineHull.getFixedEngineText());
			printInventory();
			reduceOxygen();
		}
		else {
			invalidCommand();
		}
	}
	
	public void completeSupplyRoomAction(String command){
		if (command.equals("pick up drone") || command.equals("add drone")
				|| command.equals("take drone")) {
			if (inventory.contains("drone")) {
				System.out.println("You can only take one of each item.");
				return;
			}
			supplyRoom.takeItem("drone");
			inventory.add("drone");
			reduceOxygen();


		}
		else if (command.equals("pick up spacesuit") || command.equals("add spacesuit")
				|| command.equals("take spacesuit")) {
			if (inventory.contains("spacesuit")) {
				System.out.println("You can only take one of each item.");
				return;
			}
			supplyRoom.takeItem("spacesuit");
			inventory.add("spacesuit");
			reduceOxygen();

		}
		else if (command.equals("pick up engine parts") || command.equals("add engine parts")
				|| command.equals("take engine parts") || command.equals("add one crate of engine parts")) {
			if (inventory.contains("engine parts")) {
				System.out.println("You can only take one of each item.");
				return;
			}
			supplyRoom.takeItem("engine parts");
			inventory.add("engine parts");
			reduceOxygen();

		}
		else if (command.equals("pick up instruction manual") || command.equals("add instruction manual")
				|| command.equals("take instruction manual")) {
			if (inventory.contains("instruction manual")) {
				System.out.println("You can only take one of each item.");
				return;
			}
			supplyRoom.takeItem("instruction manual");
			inventory.add("instruction manual");
			reduceOxygen();

		}
		else {
			invalidCommand();
		}
	}
	
	public void completeOxygenStorageAction(String command){
		if (command.equals("inspect control panel")) {
			printControlPanel(currentLocation);
			return;
		}
		else {
			invalidCommand();
		}
	}
	
	public void completeAction(String command) {
		command = command.toLowerCase().trim();
	/*GENERAL COMMANDS (location non-specific)*/
		if (command.equals("location") || command.startsWith("where am i")) {
			printLocation();
			return;
		}
		else if (command.startsWith("go") || command.startsWith("move")) {
			String[] listOfWords = command.split(" ");
			if (listOfWords.length < 2) {
				invalidCommand();
				return;
			}
			moveLocation(listOfWords[1]);
			return;
		}
		else if (command.equals("oxygen") || command.equalsIgnoreCase("oxygen level")) {
			printOxygenLevel();
			return;
		}
		else if (command.startsWith("look around") || command.equals("look") || command.equals("description")) {
			printRoomDescription(currentLocation);
			return;
		}
		else if (command.startsWith("help")) {
			//help();
			return;
		}
		else if (command.startsWith("inventory")) {
			printInventory();
			return;
		}
		else if (command.equals("map") && !currentLocation.equals(controlRoom)) {
			if (inventory.contains("map")) {
				printMap();
				return;
			}
			else {
				System.out.println("Sorry, you don't have a map. Go back to the Control Room to pick up the map.");
				return;
			}
			
		}
		else if ((command.equals("wear spacesuit") || command.equals("use spacesuit") || command.equals("put on spacesuit")) && inventory.contains("spacesuit") && !isWearingSpaceSuit) {
			isWearingSpaceSuit = true;
			System.out.println("You are now wearing the spacesuit.");
			return;
		}
			
	/*ROOM-SPECIFIC COMMANDS*/
		
		/*CONTROL ROOM*/
		else if (this.currentLocation.equals(controlRoom)) {
			completeControlRoomAction(command);
		}
		
		/*REACTOR ROOM*/

		else if (this.currentLocation.equals(reactorRoom)) {
			completeReactorRoomAction(command);
		}
		
		/*ENGINE HULL*/

		else if (currentLocation.equals(engineHull)) {
			completeEngineHullAction(command);
		}
		
		/*SUPPLY ROOM*/

		else if (currentLocation.equals(supplyRoom)) {
			completeSupplyRoomAction(command);
		}
		
		/*OXYGEN STORAGE*/
		else if (currentLocation.equals(oxygenStorage)) {
			completeOxygenStorageAction(command);
			
		}
		
		else {
			invalidCommand();
		}
	}
	
	public void win() {
		System.out.println("~~~~~~MISSION ACCOMPLISHED!~~~~~");
	}
	
	public void run() {
		printIntro();
		System.out.println("******************************************************************************\n");
		printLocation();
		printRoomDescription(controlRoom);
		while(!(gameOver) && (oxygenLevel > 0)) {
			String input = TextIO.getln();
			completeAction(input);
		}
		if (oxygenLevel <= 0) {
			System.out.println("\n" + "You ran out of oxygen!");
		}
		else if (gameOver && oxygenLevel > 0) {
			win();
		}
		System.out.println(" \n" + "(******************************GAME OVER******************************)");
	}
}
