import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
	
	private static final Color BACKGROUND_COLOR =Color.GREEN;
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
	 * This helper method constructs a list of simulation objects that will each
	 * simulate a world of bouncing balls.
	 * 
	 * @return a list of worlds
	 */
	private static SimulationPanel constructSimulation() {
		int width = 600;
		int height = 700;
		Color c = BACKGROUND_COLOR;
		SimulationPanel sp = new SimulationPanel(width, height,c);
		return sp;
		
		/*ArrayList<SimulationPanel> result = new ArrayList<SimulationPanel>();
		
		for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++) {
			int width = Random.randRange(MIN_WIDTH, MAX_WIDTH);
			int height = Random.randRange(MIN_HEIGHT, MAX_HEIGHT);
			Color c = BACKGROUND_COLORS[i % BACKGROUND_COLORS.length];
			SimulationPanel sp = new SimulationPanel(width, height, c);
			result.add(sp);
		}
		return result;*/
	}

}