import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Bomb extends Block {
	private double x;
	private double y;
	private Color blockColor;
	private static int size;

	public Bomb(GameWorld world, double x, double y) {
		super(world);
		this.blockColor = Color.black;
		this.size = 30;

		// these next two lines actually need to include some sort of rounding
		// to the nearest whole cell but idk how big you guys have made the
		// cells. It should be pretty easy to do, can you do it?
		this.x = x;
		this.y = y;
	}

	@Override
	public Color getColor() {
		return this.blockColor;
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

}