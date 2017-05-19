import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class GameObject implements Drawable, Temporal, Relocatable, Collision {
	private Point2D centerPoint;
	private boolean isPaused;
	private GameWorld world;
	private Color color;
	private int size;
	private Rectangle2D shape;
	private BufferedImage img;

	public GameObject(GameWorld world, Point2D centerPoint) {
		this.centerPoint = centerPoint;
		this.world = world;
		this.isPaused = false;
		this.color = null;
		this.size = 0;

		this.shape = new Rectangle2D.Double(this.centerPoint.getX(), this.centerPoint.getY(), this.size, this.size);
		loadImage();
	}

	public abstract String getName();


	public GameWorld getWorld() {
		return this.world;
	}

	/*
	 * This method detects when a game object collides with another game object.
	 * We loop through the objects in the world's list of objects and check to see 
	 * if they are intersecting.
	 */
	public void detectCollision() {
		for (int i = 0; i < this.getWorld().getObjectList().size(); i++) {
			if ((this.getWorld().getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.getWorld().getObjectList().get(i));
			}
		}
	}

	/*
	 * 
	 */
	public void loadImage() {
		String fileName = "images/" + this.getName();
		fileName += ".png";

		try {
			this.img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			
		}

	}

	@Override
	public void drawImage(Graphics2D g2) {

		g2.drawImage(this.img, (int) this.getCenterPoint().getX(), (int) this.getCenterPoint().getY(), this.getSize(),
				this.getSize(), null);

	}
	
	/*
	 * These are various getters and setters that we will use for the subclasses
	 */
	public void setColor(Color myColor) {
		this.color = myColor;
	}
	
	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}

	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}	
	
	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}	
	
	@Override
	public boolean getIsPaused() {
		return isPaused;
	}
	
	@Override
	public void timePassed() {
		if (!isPaused) {
			updateFuse();
			updatePosition();
		}
	}

	@Override
	public void die() {
		this.getWorld().removeGameObject(this);
	}

	@Override
	public void updatePosition() {

	}

	@Override
	public void updateFuse() {

	}


	/*
	 * These methods deal with the collisions that can occur in the game. Each subclass overrides them with
	 * their own specific actions.
	 */
	@Override
	public void collide(GameObject o) {
	}

	@Override
	public void collideWithHero(Hero h) {
	}

	@Override
	public void collideWithMonster(Monster m) {
	}

	@Override
	public void collideWithSeeker(Seeker s) {
	}

	@Override
	public void collideWithWall(Wall w) {
	}

	@Override
	public void collideWithBomb(Bomb b) {
	}

	@Override
	public void collideWithExplosion(Explosion e) {
	}

	@Override
	public void collideWithBombExpand(BombExpand b) {
	}

	@Override
	public void collideWithMultiBomb(MultiBomb m) {
	}

	@Override
	public void collideWithSpeedUp(SpeedUp s) {
	}

	@Override
	public void collideWithDetonator(Detonator d) {
	}

	public void collideWithLifeUp(LifeUp l) {

	}
}
