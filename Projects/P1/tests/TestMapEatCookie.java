import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map mymap = frame.getMap();
		frame.addPacMan(new Location(1,1));
		assertTrue(mymap.eatCookie("pacman") != null);
	}
}
