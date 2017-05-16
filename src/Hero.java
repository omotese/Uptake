import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Hero extends GameObject {
	private int size;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private boolean isFaster;
	private boolean hasMultiBomb;
	private int lives;
	private boolean hasExpandBombPowerUp;

	public Hero(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.size = 30;
		this.x = centerPoint.getX();
		this.y = centerPoint.getY();
		this.dx = 0;
		this.dy = 0;
		this.lives = 3;
		this.isFaster = false;
		this.hasMultiBomb = false;
		this.hasExpandBombPowerUp = false;
		setColor(Color.YELLOW);
	}

	public void reset() {
		this.y = 50;
		this.x = 50;
		this.isFaster = false;
		this.hasExpandBombPowerUp = false;
		this.hasMultiBomb = false;
	}

	public void stopHero() {
		this.dx = 0;
		this.dy = 0;
	}

	// Setters and getters for powerup features' booleans-----------------------
	public void setIsFaster(boolean isFaster) {
		this.isFaster = isFaster;
	}

	public void setMultiBomb(boolean multiBomb) {
		this.hasMultiBomb = multiBomb;
	}

	public void setHasExpandBombPowerUp(boolean hasExpandBombPowerUp) {
		this.hasExpandBombPowerUp = hasExpandBombPowerUp;
	}

	public boolean getHasMultiBomb() {
		return this.hasMultiBomb;
	}

	public boolean getHasExpandBombPowerUp() {
		return this.hasExpandBombPowerUp;
	}

	public boolean getIsFaster() {
		return this.isFaster;
	}

	// Movement-------------------------------------------
	public void moveUp() {
		if (isFaster == true) {
			this.dy = -5;
		} else {
			this.dy = -2.5;
		}

	}

	public void moveDown() {
		if (isFaster == true) {
			this.dy = 5;
		} else {
			this.dy = 2.5;
		}

	}

	public void moveLeft() {
		if (isFaster == true) {
			this.dx = -5;
		} else {
			this.dx = -2.5;
		}

	}

	public void moveRight() {
		if (isFaster == true) {
			this.dx = 5;
			// System.out.println("dx is " +dx);
		} else {
			this.dx = 2.5;
		}

	}

	public void setBomb() {
		if (this.getWorld().bombExists == false) {
			Bomb b = new Bomb(this.getWorld(), new Point2D.Double(this.x, this.y));
			this.getWorld().addGameObject(b);
			this.getWorld().addBombList(b);
		}
		if (hasMultiBomb) {
			this.getWorld().bombExists = false;
		}
	}

	@Override
	public void updatePosition() {
		this.detectCollision();

		Point2D.Double myPoint = new Point2D.Double(x, y);
		
		this.x += this.dx;
		this.y += this.dy;
		
		this.setCenterPoint(myPoint);
		this.detectCollision();
	}

	// Drawable--------------------------------------
	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.size, this.size);
		return myRect;
	}

	// Temporal--------------------------------------
	@Override
	public void die() {
		this.y = 50;
		this.x = 50;
		this.lives--;
		this.getWorld().resetAllMonsters();
		if (this.lives == 0) {
			this.lives = 3;
			this.getWorld().restart();

		}

	}

	// Collision--------------------------------------
	@Override
	public void collide(GameObject m) {
		m.collideWithHero(this);
	}

	@Override
	public void collideWithWall(Wall w) {
		this.x -= this.dx;
		this.y -= this.dy;
		stopHero();
	}

	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
	}

	@Override
	public void collideWithMonster(Monster m) {
		this.die();
	}

	@Override
	public void collideWithPowerUp(PowerUp p) {

	}

}
