import java.awt.Color;

import javax.swing.JFrame;

/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start
 * by running main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author Buffalo
 *
 */
public class Main {
	
	private static final Color BACKGROUND_COLOR= Color.GREEN;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimulationPanel world = constructSimulation();
		JFrame frame = new GameWorldFrame(world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Construct a single simulation of the game.
	 * 
	 * @return a world
	 */
	private static SimulationPanel constructSimulation() {
		int width = 600;
		int height = 700;
		Color c = BACKGROUND_COLOR;
		SimulationPanel sp = new SimulationPanel(width, height,c);
		return sp;
		
	}

}