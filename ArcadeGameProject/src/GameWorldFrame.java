import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;



public class GameWorldFrame extends JFrame {
	private static final int GAP = 10;

	/**
	 * Constructs a frame for displaying the given simulations.
	 * 
	 * @param panels
	 *            a non-empty list of simulation panels to display
	 */
	public GameWorldFrame(SimulationPanel panel) {
		setTitle("Game World");

		add(panel);

		add(quitButtonComponent(), BorderLayout.PAGE_END);
		setResizable(false);
		
		pack();
	}

	/**
	 * Adds a quit button to the bottom-right corner of the window.
	 */
	private JComponent quitButtonComponent() {
		Box quitPanel = Box.createHorizontalBox();
		quitPanel
				.setBorder(BorderFactory.createEmptyBorder(0, GAP, GAP, GAP));
		quitPanel.add(Box.createHorizontalGlue());
		JButton quitButton = new JButton("Quit");
		quitPanel.add(quitButton);

		ActionListener quitter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		};
		
		quitButton.addActionListener(quitter);
		return quitPanel;
	}

}

