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


            System.out.println(CurrentRoom);

            while (newRoomChosen == false)
            {
                System.out.println("Which room would you like to move to?");
                moveToRoomNumber = keyReader.nextInt();
                if (moveToRoomNumber < 20 && moveToRoomNumber > 0)
                {
//                    System.out.println(tunnelListCurrentRoom[0]);
//                    System.out.println(tunnelListCurrentRoom[1]);
//                    System.out.println(tunnelListCurrentRoom[2]);
                }

                if (isALegalMove(moveToRoomNumber))
                {
                    CurrentRoomNumber = moveToRoomNumber;
                    newRoomChosen = true;
                }
            }
        }

		
	}
}
