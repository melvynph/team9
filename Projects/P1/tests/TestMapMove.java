import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase{

	public void testMapMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacman = frame.addPacMan(new Location(1,1));
		Ghost ghost = frame.addGhost(new Location(1,2), "ghost", Color.red);
		
		assertTrue(pacman.myMap.move("pacman",new Location(1,3),Map.Type.PACMAN));
		assertTrue(ghost.myMap.move("ghost",new Location(1,4),Map.Type.GHOST));
		//cookies can't be moved
		assertFalse(ghost.myMap.move("ghost",new Location(1,4),Map.Type.COOKIE));
		
	}
}
