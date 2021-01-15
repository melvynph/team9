import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
	
		NoFrame validMove = new NoFrame();
		PacMan pacman2 = validMove.addPacMan(new Location(1, 1));
		//Pacman can move up or right
		//PacMan pacman3 = validMove.addPacMan(new Location(0, 0));
		//Pacman can move anywhere
		assertTrue(pacman2.move());

	}
}
