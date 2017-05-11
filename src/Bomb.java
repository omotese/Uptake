import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends GameObject {
	private double x;
	private double y;
	private double size;
	private double maxSize;
	/*
	 * private int fuse; private int explosion;
	 */
	// private static final int EXPAND_SECOND = 1;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.size = 30;
		this.x = Math.round((centerPoint.getX()) / 50) * 50 + 10;
		this.y = Math.round((centerPoint.getY()) / 50) * 50 + 10;
		this.maxSize = 150;
		this.getWorld().bombExists = true;
	}

	@Override
	public Color getColor() {
		return Color.WHITE;
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {
		x -= .3;
		y -= .3;
	}

	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		size += .6;
		if (size >= maxSize) {
			this.die();
		}

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collide(GameObject m) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithMonster(Monster m) {

	}

	@Override
	public void collideWithWall(Wall w) {

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
	}

	@Override
	public void collideWithHero(Hero h) {

	}

	@Override
	public void collideWithExplosion(Explosion e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub

	}

}
