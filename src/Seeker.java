import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * TODO Put here a description of what this class does.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class Seeker extends Monster {
	private double x;
	private double y;
	private double startX;
	private double startY;
	private int dx;
	private int dy;
	private boolean movingX;

	public Seeker(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.x = this.getCenterPoint().getX();
		this.y = this.getCenterPoint().getY();
		this.startX = centerPoint.getX();
		this.startY = centerPoint.getY();
		this.dx = 0;
		this.dy = 0;
		setColor(Color.BLACK);
	}

	@Override
	public String getName() {
		return "seeker";
	}

	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
		return myRect;
	}

	/**
	 * Moves the hero with respect to the set dx and dy
	 */
	@Override
	public void updatePosition() {
		movingX = !movingX;
		this.detectHero();
		if (movingX) {
			this.x += this.dx;
		} else {
			this.y += this.dy;
		}
		Point2D newPoint = new Point2D.Double(this.x, this.y);
		this.setCenterPoint(newPoint);
		this.detectCollision();
	}

	/**
	 * TODO
	 */
	@Override
	public void collideWithWall(Wall w) {
		if (movingX) {
			this.x -= this.dx;
			this.dx = 0;
		} else {
			this.y -= this.dy;

			this.dy = 0;
		}
	}

	/**
	 * TODO
	 */
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

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void detectHero() {
		Point2D heroPosition = this.getWorld().getHero().getCenterPoint();

		if (Math.abs(heroPosition.getX() - this.getCenterPoint().getX()) < 150
				&& (Math.abs(heroPosition.getY() - this.getCenterPoint().getY()) < 150)) {
			if (heroPosition.getX() < this.getCenterPoint().getX()) {
				this.dx = -1;
			} else {
				this.dx = 1;
			}
			if (heroPosition.getY() - this.getCenterPoint().getY() < 0) {
				this.dy = -1;
			} else {
				this.dy = 1;
			}
		}

	}

}
