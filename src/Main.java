import java.awt.Color;

import javax.swing.JFrame;

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
		SimulationPanel world = new SimulationPanel(500, 500, Color.GREEN);
		JFrame frame = new GameWorldFrame(world);
		frame.add(world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
