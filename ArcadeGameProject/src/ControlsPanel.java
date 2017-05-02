import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ControlsPanel extends JPanel {
	private static String[] BALL_NAMES = { "Pulsar", "Mover", "Bouncer", "Exploder" };

	/**
	 * Constructs controls for the given world.
	 * 
	 * @param world
	 */
	public ControlsPanel(final GameWorld world) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
}
