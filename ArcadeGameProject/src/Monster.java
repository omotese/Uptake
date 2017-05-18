import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Monster extends GameObject {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double startX;
	private double startY;

	public Monster(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.x = this.getCenterPoint().getX();
		this.y = this.getCenterPoint().getY();
		this.startX = centerPoint.getX();
		this.startY = centerPoint.getY();
		this.dx = 0;
		this.dy = 1;
		setColor(Color.RED);

		this.setSize(40);
	}

	// Drawable--------------------------------------
	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
	}

	// Temporal--------------------------------------
	@Override
	public void updatePosition() {
		this.x += dx;
		this.y += dy;
		Point2D newPoint = new Point2D.Double(x, y);
		this.setCenterPoint(newPoint);
		this.detectCollision();
	}

	@Override
	public void die() {
		this.getWorld().removeGameObject(this);
		this.getWorld().killAMonster();
	}

	// Relocatable------------------------------------

	// Collision--------------------------------------
	@Override
	public void collide(GameObject o) {
		o.collideWithMonster(this);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithMonster(this);
	}

	@Override
	public void collideWithWall(Wall w) {
		Random ran = new Random();
		this.x -= this.dx;
		this.y -= this.dy;
		do {
			this.dx = (ran.nextInt(3) - 1);
			this.dy = (ran.nextInt(3) - 1);
		} while (this.dx == 0 && this.dy == 0);
	}

	@Override
	public void collideWithBomb(Bomb b) {
		Random ran = new Random();
		this.x -= this.dx;
		this.y -= this.dy;
		do {
			this.dx = (ran.nextInt(3) - 1);
			this.dy = (ran.nextInt(3) - 1);
		} while (this.dx == 0 && this.dy == 0);

	}

	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
	}

	// --------------------------------------------------------
	public void reset() {
		x = startX;
		y = startY;
	}

	@Override
	public String getName() {
		return "monster";
	}

}
