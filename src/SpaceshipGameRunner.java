
public class SpaceshipGameRunner {
	public static void main(String[] args) {
		
		while (true) {
			SpaceshipGame g = new SpaceshipGame();
			g.run();
			System.out.println("Do you want to play again? Press y to play again, or n to stop.");
			if (TextIO.getln().trim().toLowerCase().equals("n")) {
				System.out.println("See you later!");
				return;
			}
		}

	}
}
