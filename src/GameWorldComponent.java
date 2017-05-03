import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;


public class GameWorldComponent extends JComponent {
	
	private GameWorld world;
	private boolean hasShownNullErrorMessage = false;

	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;

	public GameWorldComponent(GameWorld world) {
		this.world = world;
		
		setPreferredSize(world.getSize());
		setMaximumSize(world.getSize());
		
		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				// Periodically asks Java to repaint this component
				try {
					while (true) {
						Thread.sleep(REPAINT_INTERVAL_MS);
						repaint();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(repainter).start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		drawDrawable(g2, this.world);
		
		List<Drawable> characterParts= this.world.getDrawableCharacters(); 
		for (Drawable c : characterParts) {
			drawDrawable(g2, c);
		}
	}
	
	private void drawDrawable(Graphics2D g2, Drawable c) {
		Color color = c.getColor();
		if (color == null) {
			showNullPointerMessage("color", c);
			return;
		}
		Shape shape = c.getShape();
		if (shape == null) {
			showNullPointerMessage("shape", c);
			return;
		}

		
		g2.fill(shape);
	}
	
	private void showNullPointerMessage(String nullAttribute, Drawable d) {
		if (!this.hasShownNullErrorMessage) {
			this.hasShownNullErrorMessage = true;
			String message = "I could not draw this Drawable object of type "
					+ d.getClass().getName() + " because its " + nullAttribute
					+ " is null.\n";
			JOptionPane.showMessageDialog(null, message,
					"Null pointer exception", JOptionPane.ERROR_MESSAGE);
		}
	}

}
