import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Explosion extends GameObject {
	private double x;
	private double y;
	private int fuse;

	public Explosion(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setSize(50);

		this.x = this.getCenterPoint().getX();
		this.y = this.getCenterPoint().getY();
		setColor(Color.pink);
		this.fuse = 50;
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, getSize(), getSize());
	}

	@Override
	public void updateFuse() {
		this.detectCollision();
		this.fuse--;
		if (fuse <= 0) {
			this.die();
		}
	}

	@Override
	public void collide(GameObject o) {
		o.collideWithExplosion(this);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithExplosion(this);
	}

	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithExplosion(this);
	}

	public void collideWithBomb(Bomb b) {
		b.collideWithExplosion(this);
	}

	@Override
	public String getName() {
		return "explosion";
	}

}
