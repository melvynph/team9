import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacman = frame.addPacMan(new Location(1,1));
		Ghost ghost = frame.addGhost(new Location(1,2), "ghost", Color.red);

		assertTrue(pacman.is_ghost_in_range());
	}
}

