// A room has an id number and three "tunnels" that lead to other rooms.
// These tunnels can be represented by numbers. So, for example, one room might have
// id = 9 and tunnels leading to 11, 16 and 7. Note that the "tunnel numbers"
// should be the same as the room numbers they lead to - I am using them
// interchangeably in the documentation. These might also turn out to be the indices 
// of the rooms in the maze (hint, hint).

// NOTE: this class doesn't need to know what all the connections in the maze are - 
//       in this file, you are just setting up information about a specific room, and
//       something else will tell you what this room's connections are when you 
//       create it. 
//       Nor is this Room class keeping track of the locations of the player, bats, pits,
//       or Wumpus.
public class Room {

	// TODO: Decide which private member variables Room needs and set them up here.
	
	/**
	 * constructor 
	 * @param id
	 * @param tunnel1
	 * @param tunnel2
	 * @param tunnel3
	 */
	public Room(int id, int tunnel1, int tunnel2, int tunnel3)
	{
	// TODO: You write the Room's constructor.
	}
	/**
	 * getTunnels - returns an array of tunnel numbers for this room.
	 * @return an array of room numbers
	 */
	public int[] getTunnels()
	{
		int[] tunnelList = null;// I just put the "= null" part here so it will compile.
		//--------------------
		// Insert your code here.
		
		//--------------------
		return tunnelList;
	}
	
	/**
	 * getID - returns the id number for this room
	 * @return the id number.
	 */
	public int getId()
	{
		//--------------------
		// TODO: fix the next line so this method works as intended.
		return -1; // replace this....
		//--------------------
	}
	
	/**
	 * toString - returns a description of this room and its tunnels.
	 * for example:
	 *    "You are in room 9. Tunnels lead to rooms 11, 16 and 7."
	 * @return - the description of the room.
	 */
	// TODO: You write the Room's toString method, including its signature.
}
