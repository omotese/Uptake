
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * TODO Put here a description of what this class does.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class GameWorldComponent extends JComponent {

	private GameWorld world;
	private boolean hasShownNullErrorMessage = false;

	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param world
	 */
	public GameWorldComponent(GameWorld world) {
		this.world = world;

		setPreferredSize(world.getDimension());
		setMaximumSize(world.getDimension());

		KeyListener level = new GameListener(this.world);
		this.addKeyListener(level);

		this.setFocusable(true);
		this.requestFocus();

		Runnable repainter = new Runnable() {
			/**
			 * TODO
			 */
			@Override
			public void run() {

				try {
					while (true) {
						Thread.sleep(REPAINT_INTERVAL_MS);
						repaint();
					}
				} catch (InterruptedException exception) {

				}
			}
		};
		new Thread(repainter).start();

	}

	/**
	 * TODO
	 */
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
		c.drawImage(g2);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param nullAttribute
	 * @param d
	 */
	private void showNullPointerMessage(String nullAttribute, Drawable d) {
		if (!this.hasShownNullErrorMessage) {
			this.hasShownNullErrorMessage = true;
			String message = "I could not draw this Drawable object of type " + d.getClass().getName() + " because its "
					+ nullAttribute + " is null.\n";
			JOptionPane.showMessageDialog(null, message, "Null pointer exception", JOptionPane.ERROR_MESSAGE);
		}
	}

}
