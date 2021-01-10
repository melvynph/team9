import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

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
		return null;	
	}

	public boolean move() {
		ArrayList<Location> loc = this.get_valid_moves();
		if (loc.size() > 0) {
			myMap.move(this.myName,loc.get(0),Map.Type.PACMAN);
			return true;
		}
		return false;
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
 		return null;
	}
}
