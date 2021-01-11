import org.junit.Assert.assertFalse;
import org.junit.Assert.assertTrue;
import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapEatCookie {

	public void testMapEatCookie() {
		Frame frame = new Frame();
		PacMan pacman1 = frame.addPacMan(new Location(0, 0));
		assertTrue(frame.getMap().eatCookie("pacman1") == null);
		pacman.myLoc.shift(1, 1);
		assertFalse(frame.getMap().eatCookie("pacman1") == null);
		//return null;
	}
}
