import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		MainFrame frame = new MainFrame();
		//NoFrame frame = new NoFrame();

		Ghost red = frame.addGhost(new Location(1,1), "name", Color.red);
		Ghost blue = frame.addGhost(new Location(1,23), "name", Color.blue);
		PacMan pacman = frame.addPacMan(new Location (11,11));

		//frame.initPlayers();

		frame.startGame();

		ArrayList<Location> arr_red = red.get_valid_moves();
		ArrayList<Location> arr_blue = blue.get_valid_moves();
		Location err1 = new Location(0,1);
		Location err2 = new Location(1,24);
		//Location tru1 = new Location(2,1);
		//Location tru2 = new Location(1,22);

		System.out.println(arr_red);
		System.out.println(arr_blue);
		assertFalse("ERROR: OUT OF BOUNDS.", arr_red.contains(err1));
		assertFalse("ERROR: OUT OF BOUNDS.", arr_blue.contains(err2));
		//assertTrue("ERROR: SHOULD EXIST.", arr_blue.contains(tru1));
		//assertTrue("ERROR: SHOULD EXIST.", arr_blue.contains(tru2));
	}
}
