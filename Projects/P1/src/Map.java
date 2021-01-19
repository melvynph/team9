import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location
		if (field.get(loc) != null && locations.get(name) != null) {
			if (type.equals(Map.Type.PACMAN)) {
				PacManComponent pacman = (PacManComponent) components.get(name);
				Location prev = locations.get(name);
				pacman.setLocation(loc.x,loc.y);
				locations.put(name,loc);
				components.put(name,pacman);
				field.get(prev).remove(type);
				field.get(loc).add(type);
				return true;
			}

			if (type.equals(Map.Type.GHOST)) {
				GhostComponent ghost = (GhostComponent) components.get(name);
				Location prev = locations.get(name);
				ghost.setLocation(loc.x,loc.y);
				locations.put(name,loc);
				components.put(name,ghost);
				field.get(prev).remove(type);
				this.add(name, loc, ghost, type);
				return true;
			}
		}
		return false;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		HashSet<Type> ans = new HashSet<>();
		if (field.get(loc) != null && field.get(loc).equals(wallSet)) {
			ans.add(Type.WALL);
		} else {
			if (field.get(loc) == null || field.get(loc).equals(emptySet)) {
				ans.add(Type.EMPTY);
			} else if (field.get(loc) != null) {
				if (field.get(loc).contains(Type.PACMAN)) {
					ans.add(Type.PACMAN);
				}
				if (field.get(loc).contains(Type.GHOST)) {
					ans.add(Type.GHOST);
				}
				if (field.get(loc).contains(Type.COOKIE)) {
					ans.add(Type.COOKIE);
				}
			}
		}
	//wallSet and emptySet will help you write this method
		return ans;
	}

	public boolean attack(String Name) { 
		Location pac_loc;
		if (!locations.containsKey("pacman")) {
			return false;
		}
		pac_loc = locations.get("pacman");

		if (move(Name, pac_loc, Map.Type.GHOST) == true && field.get(pac_loc).contains(Map.Type.PACMAN) == true && field.get(pac_loc).contains(Map.Type.GHOST) == true) {
				gameOver = true; //this is literally all you guys have to do
				return true;//this is literally all you guys have to do. You dont need all these extra checks
		}
		return false;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		if (locations.containsKey(name)) {
			Location loc = locations.get(name);
			if (field.get(loc).contains(Type.COOKIE) && field.get(loc).contains(Type.PACMAN)) {
				String str = "tok_x" + loc.x +"_y" + loc.y;
				field.get(loc).remove(Type.COOKIE);
				cookies++;
				locations.remove(str);
				return components.remove(str);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
