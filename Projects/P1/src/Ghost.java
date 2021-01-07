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
		ArrayList<Location> ans  = new ArrayList<>();

		Location left = new Location(myLoc.x - 1, myLoc.y);
		Location right = new Location(myLoc.x + 1, myLoc.y);
		Location up = new Location(myLoc.x, myLoc.y - 1);
		Location down = new Location(myLoc.x, myLoc.y + 1);
		if (!(myMap.getLoc(left).contains(Map.Type.WALL)) && (left.x >= 0)) {	// left
			ans.add(left);
		}
		if (!(myMap.getLoc(right).contains(Map.Type.WALL)) && (right.x <= 30)) {		// right
			ans.add(right);
		}
		if (!(myMap.getLoc(up).contains(Map.Type.WALL)) && (up.y >= 0)) {	// up
			ans.add(up);
		}
		if (!(myMap.getLoc(down).contains(Map.Type.WALL)) && (down.y <= 30)) {	// down
			ans.add(down);
		}

		return ans;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
