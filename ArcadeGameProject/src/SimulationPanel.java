import java.awt.Color;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel {

	public SimulationPanel(int width, int height, Color color) {
		GameWorld world = new GameWorld(width, height, color);
		GameWorldComponent worldComponent = new GameWorldComponent(world);
		add(worldComponent);
	}

}
