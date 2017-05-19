import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * TODO Put here a description of what this class does.
 *
 * @author trenthe. Created May 18, 2017.
 */
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

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
	}

	@Override
	public void updatePosition() {
		this.x += dx;
		this.y += dy;
		Point2D newPoint = new Point2D.Double(x, y);
		this.setCenterPoint(newPoint);
		this.detectCollision();
	}

	/**
	 * Removes the monster from the list that the world keeps track of
	 */
	@Override
	public void die() {
		this.getWorld().removeGameObject(this);
		this.getWorld().removeFromMonsterList(this);

	}

	@Override
	public void collide(GameObject o) {
		o.collideWithMonster(this);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithMonster(this);
	}

	/**
	 *
	 */
	@Override
	public void collideWithWall(Wall w) {
		bounceBack();
	}


	@Override
	public void collideWithBomb(Bomb b) {
		bounceBack();

	}

	/**
	 * bounces away from a thing it can't go through
	 *
	 */
	public void bounceBack() {
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

	public void reset() {
		x = startX;
		y = startY;
	}

	@Override
	public String getName() {
		return "monster";
	}

}
