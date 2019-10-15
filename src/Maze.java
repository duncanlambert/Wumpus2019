import java.util.Arrays;

/**
 * A maze is a collection of twenty linked Rooms.
 * It also keeps track of the locations of the rooms of bats, the rooms with pits,
 * and the current location of the Wumpus. (Note that you only need their _locations_).
 */
public class Maze
{
	Room[] listofrooms = new Room[20];
	Room BatRoom1;
	Room BatRoom2;
	Room PitRoom1;
	Room PitRoom2;
	Room WumpusRoom;

	int[][] listofroomconnections = {{2,8,14}, {7,13,19}, {12,18,0}, {16,17,19}, {11,14,18}, {13,15,18}, {9,14,16},
			{1,15,17}, {10,16, 0}, {6,11,19}, {8,12,17}, {4,9,13}, {2, 10, 15}, {1, 5, 11}, {4, 6, 0}, {5, 7, 12},
			{3, 6, 8}, {3, 7, 10}, {2, 4, 5}, {1, 3, 9}};
	// TODO: decide which private member variables Maze needs and set them up here.
	
	/**
	 * constructor
	 * Sets up the twenty rooms, initializing them with their links.
	 */
	public Maze()
	{
		//--------------------
		// Insert your code here.

		for (int i=0; i<20;i++)
		{
			listofrooms[i] = new Room(i, listofroomconnections[i][0], listofroomconnections[i][1], listofroomconnections[i][2]);
			//System.out.println(listofrooms[i]);
		}

		WumpusRoom = listofrooms[(int)(Math.random()*20)];
		System.out.println("WumpusRoom is room "+WumpusRoom);

		BatRoom1 = listofrooms[(int)(Math.random()*20)];
		System.out.println("BatRoom 1 is room "+BatRoom1);
		while (BatRoom1 == WumpusRoom)
		{
			BatRoom1 = listofrooms[(int)(Math.random()*20)];
			System.out.println("***** BatRoom 1 is room "+BatRoom1);
		}

		BatRoom2 = listofrooms[(int)(Math.random()*20)];
		System.out.println("BatRoom 2 is room "+BatRoom2);
		while (BatRoom2 == WumpusRoom || BatRoom2 == BatRoom1)
		{
			BatRoom2 = listofrooms[(int)(Math.random()*20)];
			System.out.println("*******BatRoom 2 is room "+BatRoom2);
		}

		PitRoom1 = listofrooms[(int)(Math.random()*20)];
		System.out.println("PitRoom 1 is room "+PitRoom1);
		while (PitRoom1 == WumpusRoom || PitRoom1 == BatRoom1 || PitRoom1 == BatRoom2)
		{
			PitRoom1 = listofrooms[(int)(Math.random()*20)];
			System.out.println("******PitRoom 1 is room "+PitRoom1);
		}

		PitRoom2 = listofrooms[(int)(Math.random()*20)];
		System.out.println("PitRoom 2 is room "+PitRoom2);
		while (PitRoom2 == WumpusRoom || PitRoom2 == BatRoom1 || PitRoom2 == BatRoom2 || PitRoom2 == PitRoom1)
		{
			PitRoom2 = listofrooms[(int)(Math.random()*20)];
			System.out.println("******PitRoom 2 is room "+PitRoom2);
		}


		//--------------------
	}
	/**
	 * getDescriptionForRoom - returns a description of the given room 
	 * and its tunnels.
	 * e.g., "You are in room 9. Tunnels lead to rooms 11, 16 and 7. I smell a wumpus!"
	 * e.g., "You are in room 0. Tunnels lead to rooms 4, 7, and 9."
	 * e.g., "You are in room 12. Tunnels lead to rooms 6, 13, and 18. I feel a draft! Bats nearby!"
	 * NOTE: THIS DOES NOT PRINT ANYTHING.
	 * @param which room number
	 * @return the description.
	 */
	// TODO: You write the Maze's getDescriptionForRoom method, including its method signature.
	String getDescriptionForRoom()
    {
        return "n";
    }

	/**
	 * getAvailableTunnels - returns an array of room numbers that are
	 * connected to the given room.
	 * @param which room number
	 * @return an array of room numbers attached to this room.
	 */
	int[] getTunnels(int whichRoom)
	{
		int[] roomList = null;
		//--------------------
		// Insert your code here.
		roomList[0] = listofroomconnections[whichRoom][0];
		roomList[1] = listofroomconnections[whichRoom][1];
		roomList[2] = listofroomconnections[whichRoom][2];
		
		//--------------------
		return roomList;
	}
	
	/**
	 * containsBats - indicates whether there are bats in the given room.
	 * @param whichRoom - the number of the room in question
	 * @return whether there are bats in this room.
	 */
	 boolean containsBats(int whichRoom)
	 {
		boolean hasBats;
		//--------------------
		// Insert your code here.

		 if (listofrooms[whichRoom] == BatRoom1 || listofrooms[whichRoom] == BatRoom2)
		 {
		 	hasBats = true;
		 }
		 else
		 {
		 	hasBats = false;
		 }
		//--------------------
		return hasBats;
	 }
	
	 /**
	 * containsPit - indicates whether there is a pit in the given room.
	 * @param whichRoom - the number of the room in question
	 * @return whether there is a pit in this room.
	 */	
	 // TODO: write this method, including the method signature.
	boolean containsPit(int whichRoom)
	{
		boolean containsPit;
		if (listofrooms[whichRoom] == PitRoom1 || listofrooms[whichRoom] == PitRoom2)
		{
			containsPit = true;
		}
		else
		{
			containsPit = false;
		}
		return containsPit;
	}
 
	 /**
	 * containsWumpus - indicates whether there is a Wumpus in the given room.
	 * @param whichRoom - the number of the room in question
	 * @return whether there is a Wumpus in this room.
	 */	
	 // TODO: write this method, including the method signature.
	boolean containsWumpus(int whichRoom)
	{
		boolean containsWumpus;
		if (listofrooms[whichRoom] == WumpusRoom)
		{
			containsWumpus = true;
		}
		else
		{
			containsWumpus = false;
		}
		return containsWumpus;
	}
 	 
	/**
	 * toString - not used in the game, but may be helpful in debugging
	 * @return a list of the entire maze of rooms.
	 */

	public String toString()
	{
		return "The entire maze: " + Arrays.toString(listofrooms);
	}
	// TODO: You write the Maze's toString method (optional)

	Room getRoom(int roomNumber)
	{
		Room chosenRoom = listofrooms[0];
		for (int i=0;i<20;i++)
        {
			//System.out.println(listofrooms[i].getId());
            if (listofrooms[i].getId() == roomNumber)
            {
                chosenRoom = listofrooms[i];
            }
        }
		return chosenRoom;
	}
}
