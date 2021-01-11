import org.junit.Assert.assertTrue;
import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		Frame frame = new Frame();
		PacMan pacman1 = frame.addPacMan(new Location(0, 0));
		assertTure(pacman1.consume() == null);
		//return null;	
	}
}
