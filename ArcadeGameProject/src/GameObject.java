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
	// super methods----------------------------------------

	public abstract String getName();

	public void setColor(Color myColor) {
		this.color = myColor;
	}

	public GameWorld getWorld() {
		return this.world;
	}

	public void detectCollision() {
		for (int i = 0; i < this.getWorld().getObjectList().size(); i++) {
			if ((this.getWorld().getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.getWorld().getObjectList().get(i));
			}
		}
	}

	// Drawable----------------------------------------
	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}

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

		// g2.setColor(this.getColor());
		// g2.fill(this.getShape());
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	// Temporal----------------------------------------

	@Override
	public void timePassed() {
		if (!isPaused) {
			updateFuse();
			updatePosition();
		}
	}

	@Override
	public boolean getIsPaused() {
		return isPaused;
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
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

	// Relocatable----------------------------------------
	@Override
	public void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}

	// Collision----------------------------------------
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
