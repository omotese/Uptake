
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class GameWorldComponent extends JComponent {

	private GameWorld world;
	private boolean hasShownNullErrorMessage = false;

	private static final int FRAMES_PER_SECOND = 1;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;
	private Hero hero;

	public GameWorldComponent(GameWorld world) {
		this.world = world;
		this.hero = new Hero(world);
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
		List<Drawable> drawableParts = this.world.getDrawableParts();
		/*drawableParts.addAll(wallHolder());*/
		/*
		 * FileReader file; try { file = new FileReader("ArcadeGameLevels.txt");
		 * } catch (FileNotFoundException exception) { // TODO Auto-generated
		 * catch-block stub. exception.printStackTrace(); } Scanner s = new
		 * Scanner(file); while(s.hasNext()){ try{ String level= s.next();
		 * if(level.equals("Level 1")){ for(int i =0; i<=16; i++){ for(int j=0;
		 * j<=13; j++){ if(s.equals('W')){ Wall newWall= new Wall(this.world);
		 * drawableParts.add(newWall); } } } } }catch(IllegalArgumentException
		 * e){ System.err.println("Bad"); }
		 * 
		 * }
		 */
		KeyListener hl = new HeroListener(hero, this);
		this.addKeyListener(hl);
		drawableParts.add(this.hero);
		System.out.println(hero.getCenterPoint());
		// drawableParts.add(newWall);
		for (Drawable c : drawableParts) {
			drawDrawable(g2, c);
		}
		for(Wall w: wallHolder()) {/*
			g2.setColor(Color.black);*/
			g2.draw(w.getShape());
		}

	}

	public ArrayList<Wall> wallHolder() {
		ArrayList<Wall> walls = new ArrayList<Wall>();
		for (int i = 0; i < 13; i++) {
			Wall newWall = new Wall(0, 50 * i);
			walls.add(newWall);
		}
		for (int j = 0; j < 16; j++) {
			Wall newWall = new Wall(50 * j, 0);
			walls.add(newWall);
		}
		for(int k=0; k<16; k++){
			Wall newWall= new Wall(50*k,650 );
			walls.add(newWall);
		}
		for(int j=0; j<13; j++){
			Wall newWall= new Wall(800, 50*j);
			walls.add(newWall);
			
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

	// public void drawGame(Graphics2D g2) throws FileNotFoundException{
	// FileReader file;
	// file = new FileReader("ArcadeGameLevels.txt");
	// Scanner s = new Scanner(file);
	// while(s.hasNext()){
	// try{
	// String level= s.next();
	// if(level.equals("Level 1")){
	// for(int i =0; i<=16; i++){
	// for(int j=0; j<=13; j++){
	// if(s.equals('W')){
	// drawWall(g2);
	// }
	// }
	// }
	// }
	// }
	//
	// }
	//
	// }

	private void showNullPointerMessage(String nullAttribute, Drawable d) {
		if (!this.hasShownNullErrorMessage) {
			this.hasShownNullErrorMessage = true;
			String message = "I could not draw this Drawable object of type " + d.getClass().getName() + " because its "
					+ nullAttribute + " is null.\n";
			JOptionPane.showMessageDialog(null, message, "Null pointer exception", JOptionPane.ERROR_MESSAGE);
		}
	}

}
