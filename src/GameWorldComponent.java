import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import ballworlds.Ball;
import ballworlds.BallWorldComponent;


public class GameWorldComponent extends JComponent {
	
	private GameWorld world;
	private boolean hasShownNullErrorMessage = false;

	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;
	private Character selectedCharacter = null;
	
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
		
		List<Drawable> drawableParts= this.world.getDrawableParts(); 
		for (Drawable c : drawableParts) {
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
		} else {
			g2.setColor(color);
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
	
	/*public class GameWorldMouseHandler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				GameWorldComponent.this.selectedCharacter.moveDown();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				GameWorldComponent.this.selectedCharacter.moveLeft();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				GameWorldComponent.this.selectedCharacter.moveRight();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
	}*/
	

}
