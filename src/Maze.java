/**
 * A maze is a collection of twenty linked Rooms.
 * It also keeps track of the locations of the rooms of bats, the rooms with pits,
 * and the current location of the Wumpus. (Note that you only need their _locations_).
 */
public class Maze {

	// TODO: decide which private member variables Maze needs and set them up here.
	
	/**
	 * constructor
	 * Sets up the twenty rooms, initializing them with their links.
	 */
	public Maze()
	{
		//--------------------
		// Insert your code here.
		
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
		boolean hasBats = false;
		//--------------------
		// Insert your code here.
			
		//--------------------
		return hasBats;
	 }
	
	 /**
	 * containsPit - indicates whether there is a pit in the given room.
	 * @param whichRoom - the number of the room in question
	 * @return whether there is a pit in this room.
	 */	
	 // TODO: write this method, including the method signature.
 
	 /**
	 * containsWumpus - indicates whether there is a Wumpus in the given room.
	 * @param whichRoom - the number of the room in question
	 * @return whether there is a Wumpus in this room.
	 */	
	 // TODO: write this method, including the method signature.
 	 
	/**
	 * toString - not used in the game, but may be helpful in debugging
	 * @return a list of the entire maze of rooms.
	 */
	// TODO: You write the Maze's toString method (optional)
}
