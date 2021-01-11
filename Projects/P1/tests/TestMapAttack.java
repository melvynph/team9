import java.awt.Color;
import junit.framework.*;
import org.junit.Assert.assertTrue;
import org.junit.Assert.assertFalse;


public class TestMapAttack {

	public void testMapAttack() {
		Frame frame = new Frame();
		PacMan pacman1 = frame.addPacMan(new Location(0, 0));
		Ghost ghost1 = frame.addGhost(new Location(2, 2), "ghost", Color.blue);
		assertFalse(frame.getMap().attack("ghost") == True);
		pacman.myLoc.shift(1, 1);
		assertTrue(frame.getMap().attack("ghost")) == True;
		//return null;
	}
}
