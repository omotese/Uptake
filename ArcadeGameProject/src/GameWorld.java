import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class GameWorld implements Temporal, Drawable {
	private static final long UPDATE_INTERVAL_MS = 10;
	private final int width;
	private final int height;
	private final Color backgroundColor;
	private boolean bombExists;
	private int bombCount;

	private final List<GameObject> objectList = new ArrayList<GameObject>();
	private final List<GameObject> objectToAdd = new ArrayList<GameObject>();
	private final List<GameObject> objectToRemove = new ArrayList<GameObject>();

	private final Shape background;
	private boolean isPaused = false;
	private int monstersLeft;

	private Hero hero;
	private List<Bomb> bombList;
	private List<Monster> monsters;
	private List<Seeker> seekers;
	private List<PowerUp> powerUps;
	private int levelNum;
	private List<BreakableWall> breakables = new ArrayList<BreakableWall>();

	public GameWorld(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.backgroundColor = color;
		this.background = new Rectangle2D.Double(0, 0, this.width, this.height);
		this.hero = null;
		this.bombList = new ArrayList<Bomb>();
		this.hero = new Hero(this, new Point2D.Double(50, 50));
		this.monsters = new ArrayList<Monster>();
		this.seekers = new ArrayList<Seeker>();
		this.powerUps = new ArrayList<PowerUp>();
		this.addGameObject(hero);
		this.setHero(hero);
		this.addWall();
		this.levelNum = 1;
		this.bombCount = 0;
		this.bombExists = false;

		String levelString = "Level" + levelNum + ".txt";
		try {
			getLevel(levelString);
		} catch (FileNotFoundException e) {
			System.err.println("File " + levelString + " not found.  Exiting.");
		} catch (IOException e) {
			System.err.println("Error closing file.");
		}

		Runnable tickTock = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(UPDATE_INTERVAL_MS);
						timePassed();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(tickTock).start();

	}
	
	public void setBombExists(boolean bombExists) {
		this.bombExists = bombExists;
	}
	
	public boolean getBombExists() {
		return this.bombExists;
	}

	public Color getColor() {
		return this.backgroundColor;
	}

	// Temporal-------------------------------------
	@Override
	public void timePassed() {
		if (!this.isPaused) {
			for (Temporal t : this.objectList) {
				t.timePassed();
			}
		}
		this.objectList.removeAll(this.objectToRemove);
		this.objectToRemove.clear();
		this.objectList.addAll(this.objectToAdd);
		this.objectToAdd.clear();
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub

	}


	@Override
	public void updateFuse() {
	}

	// ---------------------------------------------

	public void addBombList(Bomb bomb) {
		this.bombList.add(bomb);
		bombCount++;
		System.out.println(bombCount);
	}

	public List<Bomb> getBombList() {
		return this.bombList;
	}
	
	public Bomb getLastBomb() {
		return this.bombList.get(0);
	}
	
	public void removeFromBombList(Bomb b) {
		this.bombList.remove(b);
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Hero getHero() {
		return this.hero;
	}

	public void resetAllMonsters() {
		for (Monster m : monsters) {
			m.reset();
		}
		for (Seeker s : seekers) {
			s.reset();
		}
	}

	public void getLevel(String fileName) throws FileNotFoundException {
		int numBlocks = 0;
		int numMonsters = 0;
		int numSeekers = 0;
		int numPowerUps = 0;
		FileReader file = new FileReader(fileName);
		if (levelNum == 1) {
			numBlocks = 22;
			numMonsters = 2;
			numSeekers = 2;
			numPowerUps = 5;
			monstersLeft = 4;
		}
		if (levelNum == 2) {
			numBlocks = 22;
			numMonsters = 4;
			numSeekers = 2;
			numPowerUps = 5;
			monstersLeft = 6;
		}
		if (levelNum == 3) {
			numBlocks = 30;
			numMonsters = 6;
			numSeekers = 3;
			numPowerUps = 5;
			monstersLeft = 9;
		}

		Scanner s = new Scanner(file);
		for (int c = 0; c < numBlocks; c++) {
			try {
				int x = s.nextInt();
				int y = s.nextInt();
				BreakableWall newWall = new BreakableWall(this, new Point2D.Double(x * 50, y * 50));
				this.breakables.add(newWall);
				for (BreakableWall n : breakables) {
					this.addGameObject(n);
				}

			} catch (IllegalArgumentException e) {
				 System.err.println("Bad");
			}
		}
		for (int i = 0; i < numMonsters; i++) {

			try {
				int x = s.nextInt();
				int y = s.nextInt();
				Monster monster = new Monster(this, new Point2D.Double(x * 50, y * 50));
				this.monsters.add(monster);
				this.addGameObject(monster);

			} catch (IllegalArgumentException e) {
				System.err.println("Bad");
			}

		}
		for (int k = 0; k < numSeekers; k++) {

			try {
				int x = s.nextInt();
				int y = s.nextInt();
				Seeker seeker = new Seeker(this, new Point2D.Double(x * 50, y * 50));
				this.seekers.add(seeker);
				this.addGameObject(seeker);

			} catch (IllegalArgumentException e) {
				System.err.println("Bad");
			}
		}

		for (int k = 0; k < numPowerUps; k++) {

			try {
				int x = s.nextInt();
				int y = s.nextInt();
				if (k == 0) {
					SpeedUp speedPower = new SpeedUp(this, new Point2D.Double(x * 50 + 5, y * 50 + 5));
					this.powerUps.add(speedPower);
				}
				if (k == 1) {
					BombExpand bombPower = new BombExpand(this, new Point2D.Double(x * 50 + 5, y * 50 + 5));
					this.powerUps.add(bombPower);
				}
				if (k == 2) {
					MultiBomb multiBomb = new MultiBomb(this, new Point2D.Double(x * 50 + 5, y * 50 + 5));
					this.powerUps.add(multiBomb);
				}
				if (k == 3) {
					Detonator detonator = new Detonator(this, new Point2D.Double(x * 50 + 5, y * 50 + 5));
					this.powerUps.add(detonator);
				}
				if (k == 4) {
					LifeUp lifeUp = new LifeUp(this, new Point2D.Double(x * 50 + 5, y * 50 + 5));
					this.powerUps.add(lifeUp);
				}
				for (PowerUp p : powerUps) {
					this.addGameObject(p);
				}

			} catch (IllegalArgumentException e) {
				System.err.println("Bad");
			}
		}
	}

	public void killAMonster() throws InterruptedException {
		System.out.println("(there were " + this.monstersLeft + " monsters left");

		this.monstersLeft = this.monstersLeft - 1;
		System.out.println("now there are " + this.monstersLeft + " monsters left");
		if (this.monstersLeft == 0) {
			Thread.sleep(1000);
			levelUp();
		}

		System.out.println("there are " + this.monstersLeft + " monsters left)");
	}

	public void addWall() {
		ArrayList<Wall> walls = new ArrayList<Wall>();
		for (int i = 0; i < 13; i++) {
			Wall newWall = new Wall(this, new Point2D.Double(0, 50 * i));
			walls.add(newWall);
		}
		for (int j = 0; j < 16; j++) {
			Wall newWall = new Wall(this, new Point2D.Double(50 * (j + 1), 0));
			walls.add(newWall);
		}
		for (int k = 0; k < 15; k++) {
			Wall newWall = new Wall(this, new Point2D.Double(50 * (k + 1), 600));
			walls.add(newWall);
		}
		for (int j = 0; j < 12; j++) {
			Wall newWall = new Wall(this, new Point2D.Double(800, 50 * (j + 1)));
			walls.add(newWall);
		}
		for (int j = 0; j < 7; j++) {
			for (int k = 0; k < 5; k++) {
				Wall newWall = new Wall(this, new Point2D.Double(100 * (j + 1), (k + 1) * 100));
				walls.add(newWall);
			}
		}
		for (Wall w : walls) {
			this.addGameObject(w);
		}

	}

	public List<GameObject> getObjectList() {
		return this.objectList;
	}

	public Shape getShape() {
		return this.background;
	}

	public void togglePause() {
		if (!this.getIsPaused()) {
			this.setIsPaused(true);
		} else {
			this.setIsPaused(false);
		}

	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;

	}

	public void updateLevel() {
		for (BreakableWall n : breakables) {
			this.removeGameObject(n);
		}
		breakables.clear();
		for (Monster w : monsters) {
			this.removeGameObject(w);
		}
		monsters.clear();
		for (Seeker s : seekers) {
			this.removeGameObject(s);
		}
		seekers.clear();
		for (PowerUp p : powerUps) {
			this.removeGameObject(p);
		}
		for (Bomb b : bombList) {
			this.removeGameObject(b);
		}
		powerUps.clear();

		String levelString = "Level" + levelNum + ".txt";
		try {
			getLevel(levelString);
		} catch (FileNotFoundException e) {
			System.err.println("File " + levelString + " not found.  Exiting.");
		} catch (IOException e) {
			System.err.println("Error closing file.");
		}
		this.getHero().reset();
	}

	public void levelUp() {
		if (levelNum >= 1 && levelNum < 3) {
			this.levelNum++;

			this.updateLevel();

		}
	}

	public void levelDown() {
		if (levelNum > 1 && levelNum <= 3) {
			this.levelNum--;

			this.updateLevel();

		}

	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
	}

	public void removeGameObject(GameObject gameObject) {
		this.objectToRemove.add(gameObject);
	}

	public void addGameObject(GameObject gameObject) {
		this.objectToAdd.add(gameObject);

	}

	public synchronized List<Drawable> getDrawableParts() {
		return new ArrayList<Drawable>(this.objectList);
	}

	public void restart() {
		this.levelNum = 1;
		updateLevel();
	}

	public Dimension getDimension() {
		return new Dimension(this.width, this.height);
	}

	@Override
	public int getSize() {
		return 0;
	}


	@Override
	public void setSize(int size) {

	}

	@Override
	public void drawImage(Graphics2D g2) {
		String fileName = "images/" + "background1";
		fileName += ".png";
		BufferedImage img;
		
		try {
			img = ImageIO.read(new File(fileName));
			g2.drawImage(img, 0, 0, this.width, this.height, null);
		} catch (IOException e) {}
		
	}

}
