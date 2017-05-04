import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Brick extends Block {
	private Color brickColor;
	private static final int SIZE = 30;
	
	public Brick(GameWorld world) {
		super(world);
		this.brickColor = Color.black;
	}


	@Override
	public Color getColor() {
		return this.brickColor;
	}

	@Override
	public void updateSize() {
		
	}


	@Override
	public void updateColor() {
		
	}


	@Override
	public double getDiameter() {
		return SIZE;
	}


	@Override
	public void updatePosition() {
		
	}

}
