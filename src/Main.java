import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame helpPage = new JFrame();
				helpPage.setSize(600, 200);
				helpPage.setTitle("Game Instruction");
				JLabel inst = new JLabel("baaah");
				helpPage.add(inst);
				helpPage.pack();

				if (help.getText().equals("Help")) {
					world.togglePause();
					help.setText("Resume");
					helpPage.setVisible(true);
				}else{
				if (help.getText().equals("Resume")) {
					help.setText("Help");
					helpPage.setVisible(false);
					world.togglePause();
				}
				}
			}

		});

		JPanel panel = new JPanel();
		// panel.add(worldComponent, BorderLayout.CENTER);
		panel.add(help);

		frame.add(worldComponent, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
