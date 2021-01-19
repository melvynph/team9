import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		// Initialization
		ArrayList<Location> ans  = new ArrayList<>();

		Location left = new Location(myLoc.x - 100, myLoc.y);
		Location right = new Location(myLoc.x + 99, myLoc.y);
		Location up = new Location(myLoc.x, myLoc.y - 123);
		Location down = new Location(myLoc.x, myLoc.y + 456);
		// Diagonals (IGNORE THIS COMMENT BLOCK)
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
		// Diagonals (IGNORE THIS COMMENT BLOCK)
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
			myMap.move(myName, loc.get(x), Map.Type.PACMAN);
			return true;
		} else {
			return false;
		}
	}

	public boolean is_ghost_in_range() {
		Location left = new Location(myLoc.x - 1, myLoc.y);
		Location right = new Location(myLoc.x + 1, myLoc.y);
		Location up = new Location(myLoc.x, myLoc.y - 1);
		Location down = new Location(myLoc.x, myLoc.y + 1);
		Location curr = new Location(myLoc.x, myLoc.y);

		if(myMap.getLoc(left).contains(Map.Type.GHOST) && myMap.getLoc(curr).contains(Map.Type.PACMAN)){
			return true;
		}
		if(myMap.getLoc(right).contains(Map.Type.GHOST) && myMap.getLoc(curr).contains(Map.Type.PACMAN)){
			return true;
		}
		if(myMap.getLoc(up).contains(Map.Type.GHOST) && myMap.getLoc(curr).contains(Map.Type.PACMAN)){
			return true;
		}
		if(myMap.getLoc(down).contains(Map.Type.GHOST) && myMap.getLoc(curr).contains(Map.Type.PACMAN)){
			return true;
		}
		return false;
	}

	public JComponent consume() {
		if ((myMap.getLoc(myLoc)).contains(Map.Type.COOKIE)) {
			return myMap.eatCookie(myName);
    	} else {
			return null;
    	}
	}
}
