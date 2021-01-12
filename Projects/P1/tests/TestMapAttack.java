import java.awt.Color;
import junit.framework.*;
import java.io.*;

public class TestMapAttack extends TestCase{
	
	public void testMapAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(0, 0));
		Ghost ghost = frame.addGhost(new Location(2, 2), "ghost", Color.blue);
		assertFalse(frame.getMap().attack("ghost"));
		pacman.myLoc.shift(1, 1);
		assertTrue(frame.getMap().attack("ghost"));
		//return null;
	}
}
