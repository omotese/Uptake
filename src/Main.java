import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Starts the game and sets up the window for it
 *
 * @author trenthe. Created May 18, 2017.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameWorld world = new GameWorld(850, 650, Color.LIGHT_GRAY);
		GameWorldComponent worldComponent = new GameWorldComponent(world);

		JFrame frame = new JFrame();
		frame.setSize(850, 650);
		frame.setTitle("BomberEmoji!");
		JPanel panel = new JPanel();

		frame.add(worldComponent, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
