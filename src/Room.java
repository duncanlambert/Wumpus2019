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
	private int r_id;
	private int r_tunnel0;
	private int r_tunnel1;
	private int r_tunnel2;

	
	/**
	 * constructor 
	 * @param id
	 * @param tunnel0
	 * @param tunnel1
	 * @param tunnel2
	 */
	public Room(int id, int tunnel0, int tunnel1, int tunnel2)
	{
	// TODO: You write the Room's constructor.

		r_id = id;
		r_tunnel0 = tunnel0;
		r_tunnel1 = tunnel1;
		r_tunnel2 = tunnel2;

	}
	/**
	 * getTunnels - returns an array of tunnel numbers for this room.
	 * @return an array of room numbers
	 */
	public int[] getTunnels()
	{
		int[] tunnelList = {r_tunnel0, r_tunnel1, r_tunnel2};// I just put the "= null" part here so it will compile.
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
		// fix the next line so this method works as intended.
		return r_id; // replace this....
		//--------------------
	}
	
	/**
	 * toString - returns a description of this room and its tunnels.
	 * for example:
	 *    "You are in room 9. Tunnels lead to rooms 11, 16 and 7."
	 * @return - the description of the room.
	 */
	// TODO: You write the Room's toString method, including its signature.
	public String toString()
	{
		return "You are in Room "+r_id+". Tunnels lead to rooms ";
	}
}
