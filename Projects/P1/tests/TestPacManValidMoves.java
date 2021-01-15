import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		//NoFrame frame = new NoFrame();

		PacMan pacman = frame.addPacMan(new Location (1,3));

		//frame.initPlayers();

		frame.startGame();

		ArrayList<Location> arr = pacman.get_valid_moves();
//		for (int i=0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).x + ", " + arr.get(i).y);
//		}
		 Location err1 = new Location(9,10);
		 Location err2 = new Location(8,11);
		 Location tru1 = new Location(9,12);
		 Location tru2 = new Location(10,11);
		 Location tru3 = new Location(10,12);

		 assertFalse("ERROR: OUT OF BOUNDS.", arr.contains(err1));
		 assertFalse("ERROR: OUT OF BOUNDS.", arr.contains(err2));
		 assertTrue("ERROR: SHOULD EXIST.", arr.contains(tru1));
		 assertTrue("ERROR: SHOULD EXIST.", arr.contains(tru2));
		 assertTrue("ERROR: SHOULD EXIST.", arr.contains(tru3));
	}
}
