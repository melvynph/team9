import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		Pacman pacman = frame.addPacMan(new Location(15,15));
		WallComponent wall1 = new WallComponent(15,14, 20);
		WallComponent wall2 = new WallComponent(15,16, 20);
		WallComponent wall3 = new WallComponent(14,15, 20);
		WallComponent wall4 = new WallComponent(16,15, 20);
		//Pacman cannot move because walls on all sides
		assertFalse(pacman.move());
	
		NoFrame validMove = new NoFrame();
		Pacman pacman2 = validMove.addPacman(new Location(15, 15));
		//Pacman can move anywhere
		assertTrue(pacman2.move());

	}
}
