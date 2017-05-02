import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * 
 * @author Lee Trent
 */
public class ControlsPanel extends JFrame {
	public ControlsPanel() {

		JFrame frame = new JFrame("Controller");
		JPanel directionPanel = new JPanel();

		JButton startButton = new JButton("SELECT (space)");
		// frame.add(startButton,BorderLayout.CENTER);
		JButton selectButton = new JButton("START (enter)");
		// frame.add(selectButton,BorderLayout.SOUTH);
		JButton upButton = new JButton("UP");
		directionPanel.add(upButton, BorderLayout.NORTH);
		JButton downButton = new JButton("DOWN");
		directionPanel.add(downButton, BorderLayout.SOUTH);
		JButton leftButton = new JButton("LEFT");
		directionPanel.add(leftButton, BorderLayout.WEST);
		JButton rightButton = new JButton("RIGHT");
		directionPanel.add(rightButton, BorderLayout.EAST);
		JButton aButton = new JButton("A (z)");
		// frame.add(aButton,BorderLayout.PAGE_END);
		JButton bButton = new JButton("B (x)");
		// frame.add(bButton,BorderLayout.PAGE_END);
		frame.add(directionPanel);

		frame.pack();
		frame.setVisible(true);

		// TODO: add listeners, including for keystrokes??
		// TODO: make all the stuff show up in the right places. I quit. 
	}
}
