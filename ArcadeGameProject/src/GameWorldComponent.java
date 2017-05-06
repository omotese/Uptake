
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class GameWorldComponent extends JComponent {

	private GameWorld world;
	private boolean hasShownNullErrorMessage = false;

	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;
	private Hero hero;

	public GameWorldComponent(GameWorld world) {
		this.world = world;
		this.hero = new Hero(world, new Point2D.Double(50, 50));
		this.world.addGameObject(hero);

		setPreferredSize(world.getSize());
		setMaximumSize(world.getSize());

		KeyListener hl = new HeroListener(hero, this);
		this.addKeyListener(hl);
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
		drawableParts.addAll(wallHolder());

		FileReader file = null;
		try {
			file = new FileReader("ArcadeGameLevels.txt");
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			try {
				String level = s.nextLine();
				if (level.equals("Level 1")) {
					while (s.hasNext()) {
						String current = s.next();
						if (current.equals("End")) {
							break;
						}
						int x = s.nextInt();
						int y = s.nextInt();
						Wall currentWall = new Wall(this.world, (double) x*50, (double) y*50);
						drawableParts.add(currentWall);
					}

				}

			} catch (IllegalArgumentException e) {
				System.err.println("Bad");
			}

		}

		for (Drawable c : drawableParts) {
			drawDrawable(g2, c);
		}

	}

	public ArrayList<Wall> wallHolder() {
		ArrayList<Wall> walls = new ArrayList<Wall>();
		for (int i = 0; i < 13; i++) {
			Wall newWall = new Wall(this.world,0, 50 * i);
			walls.add(newWall);
		}
		for (int j = 0; j < 16; j++) {
			Wall newWall = new Wall(this.world,50 * (j + 1), 0);
			walls.add(newWall);
		}
		for (int k = 0; k < 15; k++) {
			Wall newWall = new Wall(this.world,50 * (k + 1), 600);
			walls.add(newWall);
		}
		for (int j = 0; j < 12; j++) {
			Wall newWall = new Wall(this.world,800, 50 * (j + 1));
			walls.add(newWall);

		}
		for (int j = 0; j < 7; j++) {
			for (int k = 0; k < 5; k++) {
				Wall newWall = new Wall(this.world,100 * (j + 1), (k + 1) * 100);
				walls.add(newWall);
			}
		}
		return walls;
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
			String message = "I could not draw this Drawable object of type " + d.getClass().getName() + " because its "
					+ nullAttribute + " is null.\n";
			JOptionPane.showMessageDialog(null, message, "Null pointer exception", JOptionPane.ERROR_MESSAGE);
		}
	}

}
