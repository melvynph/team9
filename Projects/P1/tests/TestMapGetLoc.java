import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.*;


public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException {
		MainFrame frame = new MainFrame();
		//NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location (9,11), "name", Color.red);
		PacMan pacman = frame.addPacMan(new Location(1,1));
		Location cookie = new Location(1,2);

		//frame.initPlayers();

		frame.startGame();
		Map map = frame.getMap();

		HashSet<Map.Type> cookieLoc = map.getLoc(cookie);

		assertTrue("ERROR: COOKIE NOT FOUND", cookieLoc.contains(Map.Type.COOKIE));
		assertTrue("ERROR: PACMAN NOT FOUND.", (map.getLoc(new Location(1,1))).contains(Map.Type.PACMAN));
		assertTrue("ERROR: GHOST NOT FOUND.", (map.getLoc(new Location(9,11))).contains(Map.Type.GHOST));
	}
}
