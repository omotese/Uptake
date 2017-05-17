
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
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

		setPreferredSize(world.getDimension());
		setMaximumSize(world.getDimension());

		KeyListener level = new GameListener(this.world);
		this.addKeyListener(level);
		
		this.setFocusable(true);
		this.requestFocus();

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
		List<Drawable> drawableParts = this.world.getDrawableParts();

		for (Drawable c : drawableParts) {
			drawDrawable(g2, c);
		}

	}

	private void drawDrawable(Graphics2D g2, Drawable c) {
//		Color color = c.getColor();
//		if (color == null) {
//			showNullPointerMessage("color", c);
//			return;
//		}
//		Shape shape = c.getShape();
//		if (shape == null) {
//			showNullPointerMessage("shape", c);
//			return;
//		} else {
//			//Color co = new Color(50, 50, 50, 0);
//			g2.setColor(color);
//		}
//		g2.fill(shape);
		c.drawImage(g2);
		
//		BufferedImage img = c.getImage();
//		if (img == null) {
//			showNullPointerMessage("img", c);
//			return;
//		} else {
//			//Color co = new Color(50, 50, 50, 0);
//			g2.setColor(color);
//		}
//		g2.drawImage(img, x, y, c, squareSize, null);

		
	}

	private void showNullPointerMessage(String nullAttribute, Drawable d) {
		if (!this.hasShownNullErrorMessage) {
			this.hasShownNullErrorMessage = true;
			String message = "I could not draw this Drawable object of type " + d.getClass().getName() + " because its "
					+ nullAttribute + " is null.\n";
			JOptionPane.showMessageDialog(null, message, "Null pointer exception", JOptionPane.ERROR_MESSAGE);
		}
	}

}
