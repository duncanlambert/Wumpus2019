import java.util.Scanner;
public class WumpusRunner {

	public static void main(String[] args) 
	{
			int chosenToPlayAgain = 1;
			Scanner keyReader = new Scanner(System.in);

			Referee ref = new Referee();
			while (chosenToPlayAgain == 1)
			{
				System.out.println("Start game");
				ref.playGame();
				System.out.println("End game");
				System.out.println("Would you like to play again? Press \"1\" for Yes, \"2\" for No.");
				chosenToPlayAgain = keyReader.nextInt();
			}
	}

}
