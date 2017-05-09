import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Bomb extends Block {
	private double x;
	private double y;
	private double size;
	private int fuse;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
			this.size = 30;
			this.x = centerPoint.getX() + 10;
			this.y = centerPoint.getY() + 10;
			this.fuse = 400;
			this.getWorld().bombExists = true;

		
	}

	@Override
	public Color getColor() {
		if (fuse < 10) {
			return Color.white;
		}
		return new Color(250 - fuse * 250 / 400, 10, 10);
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {
		x -= .03;
		y -= .03;
		if (fuse < 120) {
			x -= .3;
			y -= .3;
		}

	}

	public void updateFuse() {
		fuse--;
		if (fuse == 0) {
			this.die();
			this.getWorld().bombExists = false;
		}
	}

	public Shape getShape() {
		return new Ellipse2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		updateFuse();
		size += .06;
		if (fuse < 120) {
			size += .6;
		}
	}
	// TODO Auto-generated method stub.

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	void collide(GameObject m) {
		// TODO Auto-generated method stub.

	}

	@Override
	void collideWithHero(Hero m) {
		// TODO Auto-generated method stub.

	}

	@Override
	void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub.

	}

}
