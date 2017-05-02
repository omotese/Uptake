import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class SimulationPanel extends JPanel{
	private static final int GAP_WIDTH = 10;
	
	public SimulationPanel(int width, int height, Color color) {
		// Change layout so the buttons and the world are side-by-side.
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		GameWorld world = new GameWorld(width, height, color);
		GameWorldComponent worldComponent = new GameWorldComponent(world);
		
		add(worldComponent);
		// adds "stretchy stuff" to force the world to the left
		add(Box.createGlue());
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
	}

}
