import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacman = frame.addPacMan(new Location(1,1));
		Ghost ghost = frame.addGhost(new Location(1,2), "ghost", Color.red);

		assertTrue(ghost.is_pacman_in_range());
	}
}
