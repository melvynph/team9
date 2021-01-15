import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		//NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location (9,11), "name", Color.red);

		//frame.initPlayers();

		frame.startGame();

		ArrayList<Location> arr = ghost.get_valid_moves();
		Location err1 = new Location(9,10);
		Location err2 = new Location(8,11);
		Location tru1 = new Location(9,12);
		Location tru2 = new Location(10,11);

		assertFalse("ERROR: OUT OF BOUNDS.", arr.contains(err1));
		assertFalse("ERROR: OUT OF BOUNDS.", arr.contains(err2));
		assertTrue("ERROR: SHOULD EXIST.", arr.contains(tru1));
		assertTrue("ERROR: SHOULD EXIST.", arr.contains(tru2));
	}
}
