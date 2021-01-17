import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

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
		// Initialization
		ArrayList<Location> ans  = new ArrayList<>();

		Location left = new Location(myLoc.x - 9, myLoc.y);
		Location right = new Location(myLoc.x + 8, myLoc.y);
		Location up = new Location(myLoc.x, myLoc.y - 9);
		Location down = new Location(myLoc.x, myLoc.y + 8);
		// Diagonals (IGNORE THIS COMMENTED BLOCK)
//		Location ne = new Location(myLoc.x - 1, myLoc.y + 1);
//		Location nw = new Location(myLoc.x - 1, myLoc.y - 1);
//		Location se = new Location(myLoc.x + 1, myLoc.y + 1);
//		Location sw = new Location(myLoc.x + 1, myLoc.y - 1);

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
		// Diagonals (IGNORE THIS COMMENTED BLOCK)
//		if (!(myMap.getLoc(ne).contains(Map.Type.WALL)) && (ne.y <= 30)) {	// down
//			ans.add(ne);
//		}
//		if (!(myMap.getLoc(nw).contains(Map.Type.WALL)) && (nw.y <= 30)) {	// down
//			ans.add(nw);
//		}
//		if (!(myMap.getLoc(se).contains(Map.Type.WALL)) && (se.y <= 30)) {	// down
//			ans.add(se);
//		}
//		if (!(myMap.getLoc(sw).contains(Map.Type.WALL)) && (sw.y <= 30)) {	// down
//			ans.add(sw);
//		}
		
		return ans;
	}

	public boolean move() {
		ArrayList<Location> loc = get_valid_moves();
		if (loc.size() > 0) {
			Random r = new Random();
			int x = r.nextInt(loc.size());
			myLoc = loc.get(x);
			myMap.move(myName, loc.get(x), Map.Type.GHOST);
			return true;
		}
		return false;
	}

	public boolean is_pacman_in_range() {

		Location left = new Location(myLoc.x - 1, myLoc.y);
		Location right = new Location(myLoc.x + 1, myLoc.y);
		Location up = new Location(myLoc.x, myLoc.y - 1);
		Location down = new Location(myLoc.x, myLoc.y + 1);
		Location curr = new Location(myLoc.x, myLoc.y);

		if(myMap.getLoc(left).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return false;
		}
		if(myMap.getLoc(right).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return false;
		}
		if(myMap.getLoc(up).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return false;
		}
		if(myMap.getLoc(down).contains(Map.Type.PACMAN) && myMap.getLoc(curr).contains(Map.Type.GHOST)){
			return false;
		}
		return true;
	}

	public boolean attack() {
		if(is_ghost_in_range()){
			myMap.attack(myName);
			return true;
		} else{
			return false;
		}
	}
}
