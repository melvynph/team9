import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() {

		Location left = new Location(myLoc.x - 1, myLoc.y);
		Location right = new Location(myLoc.x + 1, myLoc.y);
		Location up = new Location(myLoc.x, myLoc.y - 1);
		Location down = new Location(myLoc.x, myLoc.y + 1);
		Location curr = new Location(myLoc.x, myLoc.y);

		if(myMap.getLoc(left).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return true;
		}
		if(myMap.getLoc(right).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return true;
		}
		if(myMap.getLoc(up).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return true;
		}
		if(myMap.getLoc(down).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return true;
		}
		return false;
	}

	public boolean attack() {
		if(is_pacman_in_range()){
			myMap.attack(myName)
			return true;
		} else{
			return false;
		}
	}
}
