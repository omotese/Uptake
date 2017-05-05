import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Hero extends Character {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private Point2D centerPoint;

	public Hero(GameWorld world) {
		super(world);
		this.x = 50;
		this.y = 50;
		this.dx = 1;
		this.dy = 1;
		this.centerPoint = new Point2D.Double(x, y);
	}
	


	public void moveUp() {
		if (this.y-10 >= 50) {
			this.y -= 10;
		}
	}

	public void moveDown() {
		if (this.y + 10 <= 550) {
			this.y += 10;
		}
	}

	public void moveLeft() {
		if (this.x - 10 >= 50) {
			this.x -= 10;
		}
	}

	public void moveRight() {
		if (this.x + 10 <= 750) {
			this.x += 10;
		}
	}

	public void setBomb() {
		new Bomb(getWorld(), x, y);// ?
	}

	public Shape getShape() {
		return new Ellipse2D.Double(x, y, 50, 50);
	}

	@Override
	public Color getColor() {
		return Color.yellow;
	}

	@Override
	public void updatePosition() {
		Point2D.Double myPoint = new Point2D.Double(x, y);
		this.setCenterPoint(myPoint);
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point2D getCenterPoint() {
		return centerPoint;
	}

}
