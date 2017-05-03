import java.awt.Color;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel {
	private int width;
	private int height;
	private Color color;

	public SimulationPanel(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		GameWorld world = new GameWorld(width, height, color);
		GameWorldComponent worldComponent = new GameWorldComponent(world);
		add(worldComponent);
	}

}
