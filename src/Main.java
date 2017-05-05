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
		SimulationPanel worldPanel = new SimulationPanel(850, 650, Color.LIGHT_GRAY);
		JFrame frame = new GameWorldFrame(worldPanel);
		frame.add(worldPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		HeroListener myListener = new HeroListener(hero, world);
		// we need to pass it a hero and a world, and I know they exist because
		// they are getting drawn, but I can't figure out where they're getting
		// constructed?
	}
}
