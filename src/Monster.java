import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Monster extends GameObject {

	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Monster(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.x = (int) centerPoint.getX();
		this.y = (int) centerPoint.getY();
		Random ran = new Random();
		this.dx = ran.nextInt(2) +1;
		this.dy = ran.nextInt(2) +1;
		this.size = 40;
	}

	@Override

	public void die() {
		this.world.removeGameObject(this);
	}

	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}

	@Override
	public Color getColor() {
		return Color.red;
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, this.size, this.size);
	}

	@Override
	public void updatePosition() {
		// System.out.println(this.world.getObjectList().size());
		this.x += dx;
		this.y += dy;
		Point2D newPoint = new Point2D.Double(x, y);

		for (int i = 0; i < this.world.getObjectList().size(); i++) {
			if ((this.world.getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.world.getObjectList().get(i));
			}
		}

		this.setCenterPoint(newPoint);

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public double getDiameter() {
		return size;
	}

	@Override
	public void collide(GameObject m) {
		m.collideWithMonster(this);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithMonster(this);
	}

	@Override
	public void collideWithMonster(Monster m) {
	}

	@Override
	public void collideWithWall(Wall w) {
		Random ran = new Random();
		this.x -= this.dx;
		this.y -= this.dy;
		this.dx = (ran.nextInt(3) - 1) * 2;
		this.dy = (ran.nextInt(3) - 1) * 2;

	}

	@Override
	public void collideWithBomb(Explosion e) {
		this.die();

	}

	@Override
	public void collideWithBreakable(BreakableBlock b) {
		this.dx = -dx;
		this.dy = -dy;

	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub

	}

}
