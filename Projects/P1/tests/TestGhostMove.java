import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		Ghost ghost = frame.addGhost(new Location(1, 1), "ghost", Color.red);
		WallComponent wall1 = new WallComponent(1,2, 20);
		WallComponent wall2 = new WallComponent(2,1, 20);
		//Ghost cannot move because walls on all sides
		assertFalse(ghost.move());
	
		NoFrame validMove = new NoFrame();
		Ghost ghost2 = validMove.addGhost(new Location(1, 1), "ghost2", Color.red);
		//Ghost can move anywhere
		assertTrue(ghost.move());
	
	}
}
