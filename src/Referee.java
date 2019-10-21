/**
 * The referee class keeps track of the maze, which room the player is in,
 * and how many arrows the player has.
 * The referee is the one that interacts with the player, decides which 
 * moves the player makes are legal, and handles interactions with the 
 * rest of the objects.
 */
import java.util.Scanner;

public class Referee {
    private Maze myMaze;
    private Room CurrentRoom;
    private int CurrentRoomNumber;
    private Scanner keyReader = new Scanner(System.in);
    private int moveToRoomNumber;
    private boolean gameIsStillPlaying = true;
    private int[] tunnelListCurrentRoom;
    private int arrow = 3;
    private int decision = 0;

	// TODO: decide Rewhich private member variables this class should have and declare them here.
	
	/**
	 * constructor - initialize all variables, including the maze.
	 */
	// TODO: write the Referee constructor.
	
	/**
	 * is a legal move - is the player allowed to move to the given room from
	 * where he or she is now?
	 */
	public Referee()
    {
        myMaze = new Maze();
    }

	public boolean isALegalMove(int proposedDestination)
	{
		boolean isLegal = false;
		//----------------------------------
		// TODO: insert your code here.
		if (tunnelListCurrentRoom[0] == proposedDestination || tunnelListCurrentRoom[1] == proposedDestination || tunnelListCurrentRoom[2] == proposedDestination)
		{
            isLegal = true;
        }
		//----------------------------------
		return isLegal;
	}
	
	/**
	 * playGame - the main game loop
	 */
	public void playGame()
	{
		// TODO: write the Referee method "playGame."

		System.out.println("Playing Game."); // placeholder code.
        System.out.println("--------------------------------------");
        gameIsStillPlaying = true;
        myMaze = new Maze();
        //System.out.println(myMaze);

        CurrentRoomNumber = (int)(Math.random()*20);
        CurrentRoom = myMaze.getRoom(CurrentRoomNumber);
        while(CurrentRoom == myMaze.WumpusRoom || CurrentRoom == myMaze.BatRoom1 || CurrentRoom == myMaze.BatRoom2 ||
                CurrentRoom == myMaze.PitRoom1 || CurrentRoom == myMaze.PitRoom2)
        {
            CurrentRoomNumber = (int)(Math.random()*20);
            CurrentRoom = myMaze.getRoom(CurrentRoomNumber);
        }
        while(gameIsStillPlaying)
        {
            boolean newRoomChosen = false;
            //System.out.println(CurrentRoomNumber);


            CurrentRoom = myMaze.getRoom(CurrentRoomNumber);


            tunnelListCurrentRoom = CurrentRoom.getTunnels();


            if (myMaze.containsBats(tunnelListCurrentRoom[0]) || myMaze.containsBats(tunnelListCurrentRoom[1]) || myMaze.containsBats(tunnelListCurrentRoom[2]))
            {
                System.out.println("--------------------------------------");
                System.out.println("\033[31mBats are nearby\033[0m");
                System.out.println("--------------------------------------");
            }

            if (myMaze.containsPit(tunnelListCurrentRoom[0]) || myMaze.containsPit(tunnelListCurrentRoom[1]) || myMaze.containsPit(tunnelListCurrentRoom[2]))
            {
                System.out.println("--------------------------------------");
                System.out.println("\033[35mA pit is nearby.\033[0m");
                System.out.println("--------------------------------------");
            }



            if (myMaze.containsWumpus(tunnelListCurrentRoom[0]) || myMaze.containsWumpus(tunnelListCurrentRoom[1]) || myMaze.containsWumpus(tunnelListCurrentRoom[2]))
            {
                System.out.println("\033[32mThe Wumpus is nearby.\033[0m");
                while (decision < 1 || decision > 2)
                {
                    System.out.println("Do you want to shoot an arrow? Press 1 for yes and 2 for no.");
                    decision = keyReader.nextInt();
                }
                if (decision == 1)
                {
                    System.out.println("You can shoot into Room " + tunnelListCurrentRoom[0] + ", Room " +
                            tunnelListCurrentRoom[1] + ", Room " + tunnelListCurrentRoom[2]);
                    System.out.println("Which room do you want to shoot into?");
                    int roomshootinginto = keyReader.nextInt();
                    if (roomshootinginto == myMaze.WumpusRoom.getId()) {
                        System.out.println("--------------------------------------");
                        System.out.println("\033[33mYou have slain the wumpus. You win!\033[0m");
                        System.out.println("--------------------------------------");
                        gameIsStillPlaying = false;
                        break;
                    }
                    else
                    {
                        System.out.println("--------------------------------------");
                        System.out.println("You missed the wumpus. It moved away");
                        myMaze.setWumpusRoom();
                    }
                    arrow = arrow - 1;
                    if (arrow > 1)
                    {
                        System.out.println("You have " + arrow + " arrows left.");
                        System.out.println("--------------------------------------");
                    }
                    else if (arrow == 1)
                    {
                        System.out.println("You have 1 arrow left.");
                        System.out.println("--------------------------------------");
                    }
                    else
                    {
                        System.out.println("--------------------------------------");
                        System.out.println("\033[31mYou have no arrows left. You lose!\033[0m");
                        System.out.println("--------------------------------------");
                        gameIsStillPlaying = false;
                    }
                    decision = 0;
                }
                else if (decision == 2)
                {
                    decision = 0;
                }
            }

            if (gameIsStillPlaying) {

                System.out.println(CurrentRoom);

                while (newRoomChosen == false) {
                    System.out.println("Which room would you like to move to?");
                    System.out.println("--------------------------------------");
                    moveToRoomNumber = keyReader.nextInt();
                    if (moveToRoomNumber < 20 && moveToRoomNumber > 0) {
                        //                    System.out.println(tunnelListCurrentRoom[0]);
                        //                    System.out.println(tunnelListCurrentRoom[1]);
                        //                    System.out.println(tunnelListCurrentRoom[2]);
                    }

                    if (isALegalMove(moveToRoomNumber)) {
                        CurrentRoomNumber = moveToRoomNumber;
                        newRoomChosen = true;
                    }
                }

                while (myMaze.containsBats(CurrentRoomNumber)) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\033[34mYou ran into bats! You've been teleported!\033[0m");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    Room formerBatRoom = myMaze.BatRoom1;
                    if (CurrentRoomNumber == myMaze.BatRoom1.getId())
                    {
                        while (myMaze.BatRoom1 == formerBatRoom || myMaze.BatRoom1 == myMaze.BatRoom2 || myMaze.BatRoom1 == myMaze.PitRoom1
                                || myMaze.BatRoom1 == myMaze.PitRoom2 || myMaze.BatRoom1 == myMaze.WumpusRoom)
                        {
                            myMaze.BatRoom1 = myMaze.listofrooms[(int)(Math.random()*20)];
                        }
                    }
                    if (CurrentRoomNumber == myMaze.BatRoom2.getId())
                    {
                        while (myMaze.BatRoom2 == formerBatRoom || myMaze.BatRoom2 == myMaze.BatRoom1 || myMaze.BatRoom2 == myMaze.PitRoom1
                                || myMaze.BatRoom2 == myMaze.PitRoom2 || myMaze.BatRoom2 == myMaze.WumpusRoom)
                        {
                            myMaze.BatRoom2 = myMaze.listofrooms[(int)(Math.random()*20)];
                        }
                    }
                    CurrentRoomNumber = (int) (Math.random() * 20);
                }

                if (myMaze.containsPit(CurrentRoomNumber)) {
                    System.out.println("--------------------------------------");
                    System.out.println("\033[31mYou fell in a pit! You lose!\033[0m");
                    System.out.println("--------------------------------------");
                    gameIsStillPlaying = false;
                }

                if (myMaze.containsWumpus(CurrentRoomNumber)) {
                    System.out.println("--------------------------------------");
                    System.out.println("\033[31mYou ran into the wumpus! You lose!\033[0m");
                    System.out.println("--------------------------------------");
                    gameIsStillPlaying = false;
                }
            }
        }
	}
}
