import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Door extends Block {
	private Color doorColor;
	private static final int SIZE = 30;
	
	public Door(GameWorld world) {
		super(world);
		this.doorColor = Color.pink;
	}


	@Override
	public Color getColor() {
		return this.doorColor;
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
