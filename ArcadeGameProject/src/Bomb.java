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
		// maybe for a fun extra thing we could make the bombs grow before they
		// explode
		this.x = centerPoint.getX() + 10;
		this.y = centerPoint.getY() + 10;
		this.fuse = 300;
	}

	@Override
	public Color getColor() {
		if (fuse < 10) {
			return new Color(200,100,20,100);
		}
		return new Color(250 - fuse * 250 / 300, 10, 10);
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {
		if (fuse >10) {
			
		x-=.15;
		y-=.15;
		} else if (fuse ==10) {
			x-=15;
			y-=15;
		}

	}

	public void updateFuse() {
		fuse--;
		if (fuse == 0) {
			this.die();
		}
	}

	public Shape getShape() {
		return new Ellipse2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		updateFuse();
		size += .3;
		if (fuse < 10) {
			size = 150;
		}
		// TODO Auto-generated method stub.

	}

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
