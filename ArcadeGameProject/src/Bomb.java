import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Bomb extends Block {
	private double x;
	private double y;
	private double size;

	public Bomb(Point2D centerPoint) {
		this.setCenterPoint(centerPoint);
		this.size = 30;
		this.x = this.getCenterPoint().getX();
		this.y = this.getCenterPoint().getY();
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {

	}

	public Shape getShape() {
		return new Ellipse2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
