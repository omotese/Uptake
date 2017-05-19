import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start by running
 * main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author Lee, Joy, and Chloe
 *
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
