import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

	
		NoFrame validMove = new NoFrame();
		Ghost ghost2 = validMove.addGhost(new Location(1, 1), "ghost2", Color.red);
		//Ghost can move anywhere
		assertTrue(ghost2.move());
	
	}
}
