
public class SupplyRoom extends Location{
	private int numDrones = 10;
	private int numSpacesuits = 2;
	private int numEngineParts = 1;
	private int numInstructionManuals = 1;
	
	
	public void takeItem(String item) {
		if (item.equals("drone")) {
			if (numDrones <= 0) {
				System.out.println("There are no more left of that item.");
				return;
			}
			numDrones--;
		}
		
		else if (item.equals("spacesuit")) {
			if (numSpacesuits <= 0) {
				System.out.println("There are no more left of that item.");
				return;
			}
			numSpacesuits--;
		}
		else if (item.equals("engine parts")) {
			if (numEngineParts <= 0) {
				System.out.println("There are no more left of that item.");
				return;
			}
			numEngineParts--;
		}
		else if (item.equals("instruction manual")) {
			if (numInstructionManuals <= 0) {
				System.out.println("There are no more left of that item.");
				return;
			}
			numInstructionManuals--;
		}
		else {
			System.out.println("That item doesn't exist.");
		}

	}
	
	
	public String toString() {
		return "Supply Room";
	}

	
	public String getControlPanelText() {
		return "***Inventory Restocker***\n" +
				"add drone\n" +
				"add spacesuit\n" +
				"add engine parts\n" +
				"add instruction manual";
	}

	
	public String getRoomDescription() {
		return "\n" +
				"You can add items in the supply room to your inventory by typing \"add\" + name of item. You can only have one of each item. "
				+ "\nThere are a total of 10 drones, 2 spacesuits, an instruction manual, and one crate of engine parts in the room. \n"
				+ "Items in your inventory can be used in any room by typing \"use [object]\". (This may be helpful in fixing damages!)";
	}

}
