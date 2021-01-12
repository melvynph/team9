import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		PacMan pacman = frame.addPacMan(new Location(1,1));
		WallComponent wall1 = new WallComponent(2,1, 20);
		WallComponent wall2 = new WallComponent(1,2, 20);
		Pacman pacman = frame.addPacMan(new Location(0,0));
		WallComponent wall1 = new WallComponent(0,1, 20);
		WallComponent wall2 = new WallComponent(0,-1, 20);
		WallComponent wall3 = new WallComponent(1,0, 20);
		WallComponent wall4 = new WallComponent(-1,0, 20);
		//Pacman cannot move because walls on all sides
		assertFalse(pacman.move());
	
		NoFrame validMove = new NoFrame();
		PacMan pacman2 = validMove.addPacMan(new Location(1, 1));
		//Pacman can move up or right
		Pacman pacman2 = validMove.addPacman(new Location(0, 0));
		//Pacman can move anywhere
		assertTrue(pacman2.move());

	}
}
